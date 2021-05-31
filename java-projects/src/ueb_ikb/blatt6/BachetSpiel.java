import java.util.Scanner;

public class BachetSpiel {
    public static void main(String[] args) {
        //System.out.println(new Bachet(new SpielerMensch(), new SpielerComputer()).spielen());
        System.out.println(new Bachet(new SpielerComputer(), new SpielerComputer()).spielen());
    }
}

class Bachet {
    
    private int punkte;
    //Spieler spieler1;
    //Spieler spieler2;
    final private Spieler[] spieler;

    Bachet(Spieler spieler1, Spieler spieler2) {
        spieler = new Spieler[] {spieler1, spieler2}; 
        punkte = new java.util.Random().nextInt(29) + 1;
    }

    public int spielen() {
        int zuege = 0;

        do {
            System.out.printf("Spieler %d am Zug. Punkte: %d\n", zuege % 2 == 0 ? 1 : 2, punkte);
            /*
            if(zuege % 2 == 0) {
                punkte += spieler1.setze(spieler1, this.punkte);
            } else {
                punkte += spieler2.setze(spieler2, this.punkte);
            }
            */
            punkte += spieler[(zuege % 2)].getZahl(punkte);
            if(punkte == 100) {
                return zuege % 2 == 0 ? 1 : 2; 
            }
            zuege++;
        } while(punkte < 100);
    return 0;
    }
}

interface Spieler {
    /*
    static int setze(Spieler spieler, int punkte) {
        if(spieler instanceof SpielerMensch) {
            return ((SpielerMensch) spieler).zahlZuSetzen(punkte); 
        } else if (spieler instanceof SpielerComputer) {
            return ((SpielerComputer) spieler).berechneZug(punkte);
        } 
        return 0;
    }
    */
    int getZahl(int wert);
}

class SpielerMensch implements Spieler {
    private int zahlZuSetzen(int punkte) {
        Scanner sc = new Scanner(System.in);
        int zahl;
        do {
            System.out.println("Welche Zahl wollen Sie eingeben?");
            zahl = sc.nextInt();
        } while (zahl < 1 || zahl > 10);
        return zahl;
    }

    @Override
    public int getZahl(int wert) {
        return zahlZuSetzen(wert);
    }
}

class SpielerComputer implements Spieler {
    private int berechneZug(int punkte) {
        if(punkte >= 90) return 100 - punkte;
        if(punkte >= 80 && punkte < 89) return 89 - punkte;
        return new java.util.Random().nextInt(10) + 1;
    }

    private int clever(int punkte) {
        int d = (100 - punkte) % 11;
        return (d==0)? 1 : d;
    }

    public int getZahl(int wert) {
        //return berechneZug(wert);
        return clever(wert);
    }
}