import java.util.Arrays;
import java.util.Scanner;

class Wuerfel {
    private int augenzahl;
    private boolean wuerfelrecht;

    Wuerfel() {
        wuerfle();
        wuerfelrecht = false;
    }

    void wuerfle() {
        augenzahl = new java.util.Random().nextInt(6) + 1;
    }

    public int getAugenzahl() {
        return augenzahl;
    }

    @Override
    public String toString() {
        switch (augenzahl) {
            case 1:
                return 
                "+---+\n" +
                "|   |\n" +
                "| * |\n" +
                "|   |\n" +
                "+---+";
            case 2:
                return 
                "+---+\n" +
                "|*  |\n" +
                "|   |\n" +
                "|  *|\n" +
                "+---+";
            case 3:
                return 
                "+---+\n" +
                "|  *|\n" +
                "| * |\n" +
                "|*  |\n" +
                "+---+";
            case 4:
                return 
                "+---+\n" +
                "|* *|\n" +
                "|   |\n" +
                "|* *|\n" +
                "+---+";
            case 5:
                return 
                "+---+\n" +
                "|* *|\n" +
                "| * |\n" +
                "|* *|\n" +
                "+---+";
            case 6:
                return 
                "+---+\n" + 
                "|* *|\n" +
                "|* *|\n" +
                "|* *|\n" +
                "+---+"; 
        }
        return null;
    }   
}

class Kniffel {
    private Wuerfel[] wuerfel = new Wuerfel[5];
    private int maxWuerfeAnzahl = 2;

    Kniffel() {
        for(int i = 0; i < 5; i++) {
            wuerfel[i] = new Wuerfel();
        }
    }

    public int[] getAlleAugenzahlen() {
        int[] result = new int[5];
        for(int i = 0; i < 5; i++) {
            result[i] = wuerfel[i].getAugenzahl();
        };
        return result;
    }

    public void spielzug() {
        for(int i = 0; i < 2; i++) { 
            neuWuerfeln(auswahlWegwerfen());   
        }
    } 

    private void neuWuerfeln(int[] nochmalWuerfeln) {
        if(maxWuerfeAnzahl > 0) {
            for(int i = 0; i < nochmalWuerfeln.length; i++) {
                wuerfel[nochmalWuerfeln[i] - 1] = new Wuerfel();
            }
            maxWuerfeAnzahl--;
        }
    }

    private int[] auswahlWegwerfen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("wie viele Würfel wollen sie nochmal werfen?");
        int k = sc.nextInt();
        int[] wegwurfAuswahl = new int[k];
        System.out.println("Welche Würfel wollen sie nochmal werfen?");
        for(int i = 0; i < k; i++) {
            int save = sc.nextInt();
            if(validationAugenzahl(save) == true) wegwurfAuswahl[i] = save;
            else if(validationAugenzahl(save) != true) i--;
        }
        return wegwurfAuswahl;
    }

    private boolean validationAugenzahl(int wuerfelStelle) {
        if ((wuerfelStelle > 0) && (wuerfelStelle < 6)) return true;
        return false;
    }

    //gibt mir die Anzah der Würfelaugen - das macht mir das Bestimmen der Punktzahl gefühlt einfacher
    private int[] anzahlAugenzahlenSortiert() {
        int[] anzahlAugenZahl = new int[6]; //Beim Index 0 wird die Häufigkeit der 1 gespeichert. Beim Index 1 für die 2 usw...
        for(int i = 0; i < 6; i++) {
            for(int k = 0; k < 5; k++)
            if(wuerfel[k].getAugenzahl() == i + 1) {
                anzahlAugenZahl[i]++;
            }
        }
        return anzahlAugenZahl;
    }

    public int zugErgebnis() {
        anzahlAugenzahlenSortiert();
        return 0;
    }

    private int dreierPasch() {
        int[] augenzahlen = anzahlAugenzahlenSortiert()
        for(int i = 0; i < 6; i++) {
            if(augenzahlen[i] == 3) return 17;
        }
        return 0;
    }

    //
    private int viererPasch() {
        int[] augenzahlen = anzahlAugenzahlenSortiert()
        for(int i = 0; i < 6; i++) {
            if(augenzahlen[i] == 4) return 24;
        }
        return 0;
    }

    //ist ein Kniffel, gibt 50 Punkte zurück
    private int fuenferPasch() {
        int[] augenzahlen = anzahlAugenzahlenSortiert();
        for(int i = 0; i < 6; i++) {
            if(augenzahlen[i] == 5) return 50;
        }
        return 0;
    }

    private int kleineStraße() {

    }

    private int großeStraße() {
        int[] augenzahlen = anzahlAugenzahlenSortiert();
        for(int i = 1; i < 5; i++) {
            if(augenzahlen[i] != 1) return 0;
        }
        return 0;
    }

    private int[] untererBlock() {

    }

    private int[] obererBlock() {
        
    }

}

public class Wuerfel_Kniffel {
    public static void main(String[] args) {
        Kniffel kniffel1 = new Kniffel();
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        kniffel1.spielzug();
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        kniffel1.zugErgebnis();
        /*
        int[] wegwerfen2 = kniffel1.auswahlWegwerfen();
        kniffel1.neuWuerfeln(wegwerfen2);
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        int[] wegwerfen3 = kniffel1.auswahlWegwerfen();
        kniffel1.neuWuerfeln(wegwerfen3);
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        */
    }
}