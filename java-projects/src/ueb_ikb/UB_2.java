package ueb_ikb;

public class UB_2 {

    static int[] Cent = { 1, 2, 5, 10, 20, 50 };

    static long muenzwechsel(int betrag, int muenzen) {
        // if (betrag < 0 || muenzen == 0)
        //     return 0;
        // else if (betrag == 0)
        //     return 1;
        // else

        if (betrag < 0) return 0;
        
        if ((betrag == 0) || (muenzen == 0)) return 1;

            //      Variante b) höchste reduzieren    + Variante a) höchste Münze verwenden
            return (muenzwechsel(betrag, muenzen - 1) + muenzwechsel(betrag - Cent[muenzen], muenzen));
    }

    static long muenzwechsel(int betrag) {
        return muenzwechsel(betrag, Cent.length-1);
    }

    public static void main(String[] args) {
        System.out.println("test");
        System.out.println(muenzwechsel(7));
        System.out.println(muenzwechsel(23));
        System.out.println(muenzwechsel(87));
    }
}
