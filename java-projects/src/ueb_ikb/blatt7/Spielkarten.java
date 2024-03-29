package ueb_ikb.blatt7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Spielkarten {
    public static void main(String[] args) {
        Kartenstapel skat = new Kartenstapel(Blatt.Skat);
        skat.mischen();
        System.out.printf("Gemischt: %s\n\n", skat);
        skat.sortieren();
        System.out.printf("Sortiert: %s\n\n", skat);

        
        // austeilen
        int spieler = 0;
        for(Spielkarte[] hand: skat.austeilen(4,4,4)) {
            System.out.printf("Spieler #%d erhält %s\n", ++spieler, Arrays.toString(hand));
        }
    }
}

// Lösung ist nicht schön, weil ich so jede Karte einzeln einpflegen muss, gerade bei Eigenschaften, die doppelt sind ist das unschön
class Gewichtung {
    public int getGewichtung(String gesucht, String typ) {
        switch(gesucht) {
            case "Schellen": return 1;
            case "Herz": return 2;
            case "Grün": return 3;
            case "Eichel": return 4;
            case "Karo": return 1;
            case "Pik": return 3;
            case "Kreuz": return 4;
            case "2": return 1;
            case "3": return 2;
            case "4": return 3;
            case "5": return 4;
            case "6": return 5;
            case "7":
                if(typ == "Skat") return 1;
                else if (typ == "Poker") return 6;
            case "8":
                if(typ == "Skat") return 2;
                else if (typ == "Poker") return 7;
            case "9":
                if(typ == "Skat") return 3;
                else if (typ == "Poker") return 8;
            case "10":
                if(typ == "Skat") return 6;
                else if (typ == "Poker") return 9;
            case "Dame":
                if(typ == "Skat") return 4;
                else if(typ == "Poker") return 11;
            case "König":
                if(typ == "Skat") return 5;
                else if(typ == "Poker") return 12;
            case "Ass":
                if(typ == "Skat") return 7;
                else if(typ == "Poker") return 13;
            case "Bube": return 10;   
            default: return 0;
        }
    }
}

enum Blatt {

    Skat(
        new String[]{"Schellen", "Herz", "Grün", "Eichel"},
        new String[]{"7", "8", "9", "Dame", "König", "10", "Ass"},
        "Skat"
    ), Poker(
        new String[]{"Karo", "Herz", "Pik", "Kreuz"},
        new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "König", "Ass"},
        "Poker"
    );

    ArrayList<Spielkarte> spielkarten = new ArrayList<>();

    Blatt(String[] farben, String[] werte, String typ) {
        for(int i = 0; i < farben.length; i++) {
            for(int k = 0; k < werte.length; k++) {
                spielkarten.add(new Spielkarte(farben[i], werte[k], typ));
            }
        }
    }
}

class Spielkarte implements Comparable<Spielkarte> {

    private final String typ;
    private final String farbe;
    private final String wert;
    static Gewichtung waage = new Gewichtung();
    
    Spielkarte(String farbe, String wert, String typ) {
        this.farbe = farbe;
        this.wert = wert;
        this.typ = typ;  
    }

    @Override
    public int compareTo(Spielkarte spielkarte) {
        return 
            waage.getGewichtung(farbe, typ) - waage.getGewichtung(spielkarte.farbe, spielkarte.typ) != 0 ? 
            waage.getGewichtung(farbe, typ) - waage.getGewichtung(spielkarte.farbe, spielkarte.typ) : 
            waage.getGewichtung(wert, typ) - waage.getGewichtung(spielkarte.wert, spielkarte.typ);
    }

    public String getFarbe() {
        return farbe;
    }

    public String getWert() {
        return wert;
    }

    @Override
    public String toString() {
        return farbe + " " + wert;
    }
}

class Kartenstapel {
    
    private ArrayList<Spielkarte> kartenstapel = new ArrayList<>();

    Kartenstapel(Blatt typ) {
        kartenstapel = (ArrayList<Spielkarte>) typ.spielkarten.clone();
    }

    @Override
    public String toString() {
        String antwort = "";
        for(int i = 0; i < kartenstapel.size(); i++) {
            Spielkarte karte = kartenstapel.get(i);
            antwort += karte.getFarbe() + " " +karte.getWert() + ", ";
        }
        return antwort;
    }

    public Spielkarte[][] austeilen(int... spieler) {
        int summe = 0;
        for(int i: spieler) {
            summe += i;
        }
        if(summe > kartenstapel.size()) return null;
        Spielkarte[][] antwort = new Spielkarte[spieler.length][spieler[0]];
        for(int i = 0; i < spieler.length; i++) {
            for(int k = 0; k < spieler[0]; k++) {
                antwort[i][k] = kartenstapel.remove(0);
            }
        }
        return antwort;
    }

    public void sortieren() {
        Collections.sort(kartenstapel);
    }

    public void mischen() {
        Collections.shuffle(kartenstapel);
    }
}