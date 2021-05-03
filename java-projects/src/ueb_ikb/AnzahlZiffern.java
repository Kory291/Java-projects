
package ueb_ikb;

/**
 * AnzahlZiffern
 */
public class AnzahlZiffern {

    
    static int anzahlZiffern (long v, int b) {
        int res = 1;
        while (v >= b) {
            v = v/b;
            res = res + 1;
        }
        return res;
    }

    static int anzahlZiffern (long v) {

        return anzahlZiffern(v, 10);
        /*
        // 0 ... 9 --> Division durch 10: 0
        // 10 ... 99 --> Division durch 10: 1...9
        // 100 ... 999 --> Division durch 10: 10 und 99
        int res = 1;
        while (v >= 10) {
            v = v/10;
            res = res + 1;
        }
        return res;
        */
    }

    static int anzahlZiffernRekursiv (long v) {
        return v<10 ? 1 : anzahlZiffernRekursiv(v/10)+1;

        // if (v<10) {
        //     return 1;
        // }

        // return anzahlZiffernRekursiv(v/10)+1;
    }

    public static void main(String[] args) {
        
        System.out.println(anzahlZiffern(834929));
        System.out.println(anzahlZiffernRekursiv(834929));

    }
}