package gen;

class FlaschenUmfueller {
    <T extends Getraenk> T umfuellen (GenerischeFlasche<T> von, GenerischeFlasche<T> nach) {

        T result = nach.leeren();
        nach.fuellen(von.leeren());
        return result;
    }

    // public static void main(String[] args) {
    //     new FlaschenUmfueller().umfuellen(
    //         new GenerischeFlasche<Bier>(500),
    //         new GenerischeFlasche<Bier>(500));
    // }
}

public class GenerischeFlasche<T extends Getraenk> {

    //angenomenn T == Bier
    private final int groesse; //in ml
    private T inhalt;
    //static final int MAXGROESSE = 2000;

    GenerischeFlasche(int groesse) {
        this.groesse = groesse;
        this.inhalt = null;
    }

    void fuellen(T g) {
        this.inhalt = g;
    }

    T leeren() {
        T g = this.inhalt;
        this.inhalt = null;
        return g;
    }

    boolean istLeer() {
        return this.inhalt == null;
    }

    public static void main(String[] args) {
        GenerischeFlasche<Bier> f1 = new GenerischeFlasche<>(500);
        GenerischeFlasche<Wein> f2 = new GenerischeFlasche<>(700);
          
        Bier b = new Bier("Ur-Krostitzer", 4.9, "Pils");
        Wein w = new Wein("Äbbelwoi", 6.0, "gelb trüb");

        f1.fuellen(w);
    }
}
