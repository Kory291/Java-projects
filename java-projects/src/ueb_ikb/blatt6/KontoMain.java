public class KontoMain {
    public static void main(String[] args) {
        //Konto k1 = new Konto(100, 1, "Schäfer", "Martin", "Klaus");
        
        //Girokonto g1 = new Girokonto(100, 2, "Schäfer", "Lukas", "Martin");
        System.out.println("--");
    }
}

abstract class Konto {
    private final int kontoNr;
    private int kontostand;
    private String nachname;
    private String[] vornamen;

    Konto(int kontostand, int kontoNr, String nachname, String... vornamen) {
        this.kontoNr = kontoNr;
        this.kontostand = kontostand;
        this.setInhaber(nachname, vornamen);
    }

    int getKontoNr() {
        return this.kontoNr;
    }

    void setInhaber(String nachname, String... vornamen) {
        this.nachname = nachname;
        this.vornamen = vornamen.clone();
    }

    void einzahlen(double d) {
        if(d > 0) {
            this.kontostand += d;
        }
    }

    protected double abbuchen (double abbBetrag) {
        if((abbBetrag < 0) || (abbBetrag > kontostand)) {
            return 0;
        }
        kontostand -= abbBetrag;
        return abbBetrag;
    }
}