public class Flasche {
    
    private final int groesse;  // in ml
    private Getraenk inhalt;
    // static final int MAXGROESSE = 2000;

    Flasche (int groesse) {
        this.groesse = groesse;
        this.inhalt = null;
    }

    void fuellen (Getraenk g) {
        this.inhalt = g;
    }

    Getraenk leeren() {
        Getraenk g = this.inhalt;
        this.inhalt = null;
        return g;
    }

    boolean istLeer () {
        return this.inhalt == null;
    }

    public static void main(String[] args) {
        Flasche f1 = new Flasche(500);
        Flasche f2 = new Flasche(700);

        Bier b = new Bier("Ur-Krostitzer", 4.9, "Pils");
        Wein w = new Wein("Äbbelwoi", 6.0, "gelb trüb");

        f1.fuellen(b);
        f2.fuellen(w);

        b.name = "Radeberger";

        Bier b1 = (Bier) f1.leeren();
        f1.fuellen(w);

        System.out.println("-");

    }

}
