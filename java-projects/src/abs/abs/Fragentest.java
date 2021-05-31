package abs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


enum MC {

    AntwortABC("ABC"), AntwortBC("BC"), AntwortBCE("BCE");
    MCAntworter a;
    MC(String antwort) {
        this.a = new MCAntworter(antwort);
    }

    MCAntworter getAntworter() {
        return a;
    }
}

class MCAntworter extends InputStream {

    byte[] antwort;
    int pos;

    MCAntworter(String antwort) {
        this.antwort = antwort.getBytes();
        this.pos = 0;
    }
    
    @Override
    public int read() throws IOException {
        if(this.pos < antwort.length) {
            return antwort[pos++];
        }
        return -1;
    }
}

public class Fragentest {

    static void frageStellen(Frage f) {
        Scanner sc = new Scanner(System.in);
        System.out.println(f.getAnzeigeText());
        String eingabe = sc.nextLine();
        System.out.printf("Erreiche Punktzahl: %d\n", f.getPunktzahl(eingabe));
    }

    static void frageStellenThor(Frage f, InputStream antwort) {
        Scanner sc = new Scanner(System.in);
        System.out.println(f.getAnzeigeText());
        String eingabe = sc.nextLine();
        System.out.printf("Erreiche Punktzahl: %d\n", f.getPunktzahl(eingabe));
    }

    static void frageStellenStudent(Frage f) {
        frageStellenStudent(f, null);
    }

    static void frageStellenStudent(Frage f, String antwort) {
        String eingabe = sc.nextLine();
        System.out.println(f.getAnzeigeText());

        if(antwort == null) {
            Scanner sc = new Scanner(System.in);
            System.out.println(f.getAnzeigeText());
            eingabe = sc.nextLine();
        } else {
            eingabe = antwort;
        }
        System.out.printf("Erreiche Punktzahl: %d\n", f.getPunktzahl(eingabe));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Frage[] fragen = {
            new FrageFT("Wie heißt die Hauptstadt Sachsens?", "Dresden", 2),
            new FrageMC("Was sind die Primzahlen?", new String[] {"1", "2", "3", "4", "5"}, new int[] {1, -1, 1, 1, -1, 1})
        };

        System.out.println(f1.getAnzeigeText());
        String eingabe = sc.nextLine();
        System.out.printf("Erreiche Punkte: %d\n", f1.getPunktzahl(eingabe));

        for(int pos = 0; pos < fragen.length; pos++) {}

    }
}   
