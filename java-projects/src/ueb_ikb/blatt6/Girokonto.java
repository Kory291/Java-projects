class Girokonto extends Konto {
    Girokonto(int kontostand, int kontoNr, String nachname, String... vorname) {
        super(kontoNr ,kontoNr, nachname, vorname);
    }

    public double auszahlen(double auszahlung) {
        return abbuchen(auszahlen(auszahlung)); //Delegation
    }

    public void ueberweisen(double b, Konto zielKonto) {
        zielKonto.einzahlen(this.abbuchen(b));
    }
}
