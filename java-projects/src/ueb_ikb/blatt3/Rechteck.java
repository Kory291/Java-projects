package ueb_ikb.blatt3;


class Punkt {
    int x, y;

    Punkt (int x, int y) {
        this.x=x;
        this.y=y;
    }
}

class Rechteck {

    int breite;
    int hoehe;

    Rechteck (int b, int h) {
        this.breite = b; // Math.abs(b);
        hoehe = h; // Math.abs(h);
    }

    Rechteck (Punkt a, Punkt b) {
        // this (a.x-b.x, a.y-b.y);    // ohne Negativ-Prüfung
       
        // this(Math.abs(a.x-b.x), Math.abs(a.y-b.y));  // korrekt wegen absolutem Betrag

        this.breite = punktdiff(a.x,b.x);
        this.hoehe =  a.y<b.y ? b.y-a.y : a.y-b.y;
    }

    int punktdiff(int zahl1, int zahl2) {
        
        return (zahl1 < zahl2) ? zahl2 - zahl1 : zahl1 - zahl2;
/*        
        int diff;
        if (zahl1 < zahl2) {
        diff = zahl2 - zahl1;
        }
        else diff = zahl1 - zahl2;
        return diff;
*/
        }

    int umfang() {
        return 2*(breite+hoehe);
    }

    int flaeche () {
        return breite*hoehe;
    }

    public static void main(String[] args) {
        Rechteck r1 = new Rechteck (10, 15);
        System.out.printf("Umfang=%d, Flaeche=%d\n", r1.umfang(), r1.flaeche());

        Rechteck r2 = new Rechteck (new Punkt(2,10), new Punkt(7,3));
        System.out.printf("Umfang=%d, Flaeche=%d\n", r2.umfang(), r2.flaeche());
    }
}