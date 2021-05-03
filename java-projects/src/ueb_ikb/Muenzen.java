package ueb_ikb;

public class Muenzen {
   
    static long muenzwechsel (int betrag) {
        return wechseln (betrag, 50);
    }

    static long wechseln (int betrag, int hoechste) {

        // Rekursionende
        if (betrag == 0) return 1;
        if (hoechste == 1) return 1;

        long anzahl = 0;

        // Variante a) höchste Cent-Münze verwenden, wenn verwendbar
        if (betrag >= hoechste) {
            anzahl += wechseln(betrag-hoechste, hoechste);
        }

        // Variante b) nächsthöchste Münze
        switch (hoechste) {
            case  2: anzahl += wechseln(betrag,  1); break;
            case  5: anzahl += wechseln(betrag,  2); break;
            case 10: anzahl += wechseln(betrag,  5); break;
            case 20: anzahl += wechseln(betrag, 10); break;
            case 50: anzahl += wechseln(betrag, 20); break;
        }

        return anzahl;
    }

    public static void main(String[] args) {
        
        muenzwechsel(7);
        int[] werte = new int[] {7, 23, 87};
        for (int w: werte) {
            System.out.printf("%d Cent kann in %d Varianten gewechselt werden\n", w, muenzwechsel(w));
        }
    }
}
