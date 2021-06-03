class Tagesgeldkonto extends Konto {

    private final Konto referenzKonto;

    Tagesgeldkonto(int kontostand, int kontoNr, String nachname, Konto referenzKonto, String... vorname) {
        super(kontoNr ,kontoNr, nachname, vorname);
        this.referenzKonto = referenzKonto;
    }

    public void ueberweisen(double b) {
        referenzKonto.einzahlen(this.abbuchen(b));
    }
}
