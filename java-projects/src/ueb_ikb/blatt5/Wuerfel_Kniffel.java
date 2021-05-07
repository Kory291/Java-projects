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

    public String[] ausgabeInString() {
        switch (augenzahl) {
            case 1:
                String[] ausgabe1 = {
                    "+---+",
                    "|   |",
                    "| * |",
                    "|   |",
                    "+---+"
                };
                return ausgabe1;
            case 2:
                String[] ausgabe2 = {
                    "+---+",
                    "|*  |",
                    "|   |",
                    "|  *|",
                    "+---+"
                };
                return ausgabe2; 
            case 3:
                String[] ausgabe3 = {
                    "+---+",
                    "|  *|",
                    "| * |",
                    "|*  |",
                    "+---+"
                };
                return ausgabe3;
            case 4:
                String[] ausgabe4 = {
                    "+---+",
                    "|* *|",
                    "|   |",
                    "|* *|",
                    "+---+"
                };
                return ausgabe4;
            case 5:
                String[] ausgabe5 = {
                    "+---+",
                    "|* *|",
                    "| * |",
                    "|* *|",
                    "+---+"
                };
                return ausgabe5;
            case 6:
                String[] ausgabe6 = {
                    "+---+",
                    "|* *|",
                    "|* *|",
                    "|* *|",
                    "+---+"
                };
                return ausgabe6; 
        }
        return null;
    }   
}

class Kniffel {
    private Wuerfel[] wuerfel = new Wuerfel[5];
    private int maxWuerfeAnzahl = 2;
    private boolean[] beiseiteGelegt = new boolean[] {false, false, false, false, false,};

    Kniffel() {
        for(int i = 0; i < 5; i++) {
            wuerfel[i] = new Wuerfel();
        }
        System.out.println("gewürfelt");
    }

    public int[] getAlleAugenzahlen() {
        int[] result = new int[5];
        for(int i = 0; i < 5; i++) {
            result[i] = wuerfel[i].getAugenzahl();
        };
        return result;
    }

    public void neuWuerfeln(int[] nochmalWuerfeln) {
        if(maxWuerfeAnzahl > 0) {
            for(int i = 0; i < nochmalWuerfeln.length; i++) {
                wuerfel[nochmalWuerfeln[i] - 1] = new Wuerfel();
            }
            maxWuerfeAnzahl--;
        }
    }

    public int[] auswahlWegwerfen() {
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

}

public class Wuerfel_Kniffel {
    public static void main(String[] args) {
        Kniffel kniffel1 = new Kniffel();
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        int[] wegwerfen = kniffel1.auswahlWegwerfen();
        kniffel1.neuWuerfeln(wegwerfen);
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        int[] wegwerfen2 = kniffel1.auswahlWegwerfen();
        kniffel1.neuWuerfeln(wegwerfen2);
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
        int[] wegwerfen3 = kniffel1.auswahlWegwerfen();
        kniffel1.neuWuerfeln(wegwerfen3);
        System.out.println(Arrays.toString(kniffel1.getAlleAugenzahlen()));
    }
}