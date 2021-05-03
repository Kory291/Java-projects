package acc;

public enum Waehrung {
    
    EURO (1.0), DOLLAR (0.92), YEN (0.0085);

    private double faktor;

    private Waehrung (double faktor) {
        this.faktor = faktor;
    }

    public double inEuro (double betrag) {
        return betrag*faktor;
    }
}
