package gen;

public class Flasche {

    private final int groesse; //in ml
    private Getreank inhalt;
    //static final int MAXGROESSE = 2000;

    Flasche(int groesse) {
        this.groesse = groesse;
        this.inhalt = null;
    }

    void fuellen(Getreank g) {
        this.inhalt = g;
    }

    Getreank leeren() {
        Getrank g = this.inhalt;
        this.inhalt = null;
        return g;
    }

    boolean istLeer() {
        return this.inhalt == null;
    }

    public static void main(String[] args) {
        Flasche f1 = new Flashe(500);
        Flasche f2 = new Flasche(700);

        Bier b = new Bier("Ur-Krostitzer", 4.9, "Pils");
        Wein w = new Wein("Äbbelwoi", 6.0, "gelb trüb");
    }
}
