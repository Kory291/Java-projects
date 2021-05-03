package ueb_ikb.blatt3;

class Konto {

    int nr;
    String inhaber;
    double betrag;
    int auszahlungen;

    static double zinssatz = 2.5f;

    public void verzinsen() {
        betrag += betrag * Konto.zinssatz/100f;
    }

    public Konto(int nr, String inhaber) {
        this.nr = nr;
        this.inhaber = inhaber;
        betrag = 100;
        auszahlungen = 0;
    }

    public void einzahlen(double einzahlung) {
        betrag += einzahlung;
    }

    public double auszahlen(double auszahlung) {
       
        int gebuehr = auszahlungen >= 2 ? 1 : 0;
        // betrag = auszahlung
        if (betrag >= auszahlung + gebuehr) {
            betrag = betrag - (auszahlung + gebuehr);
            auszahlungen += 1;
            return auszahlung;
        } else {
            return 0; // Auszahlung geht nicht
        }
    }
}
