public class KontoMain {
    public static void main(String[] args) {
        Konto k1 = new Konto(100, 1, "Schäfer", "Lukas", "Alex");
        System.out.println("---");
    }
}

class Konto {
    private final int kontoNr;
    private int kontostand;
    private String nachname;
    private String[] vornamen;

    Konto(int kontostand, int kontoNr, String nachname, String... vornamen) {
        this.kontoNr = kontoNr;
        this.kontostand = kontostand;
        this.vornamen = vornamen;
        this.nachname = nachname;
    }
}

class Girokonto extends Konto {
    Girokonto(int kontostand, int kontoNr, String vorname, String nachname) {
        super(kontoNr ,kontoNr, vorname, nachname);
    }
}

class Tagesgeldkonto extends Konto {
    Tagesgeldkonto(int kontostand, int kontoNr, String vorname, String nachname) {
        super(kontoNr ,kontoNr, vorname, nachname);
    }
}
