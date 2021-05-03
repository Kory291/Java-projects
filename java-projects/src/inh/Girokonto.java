package inh;

public class Girokonto extends Konto {
    
    private double zinssatz;
    private double gebuehr;
    String inhaber;

    Girokonto (double kontostand, double z, double g) {
        super(kontostand); // ruft Konstruktor der Oberklasse auf
        this.zinssatz = z;
        this.gebuehr = g;
        this.inhaber = "GirokontoInhaber";
    }

    void verzinsen() {
        this.kontoStand *= (1 + this.zinssatz/100d);
    }

    //Überladen
    double einzahlen(double b1, double b2) {
        return einzahlen(b1) + einzahlen(b2);
    }

    //Überschreiben
    @Override
    public double auszahlen(double betrag) {
        if((betrag+gebuehr) == super.auszahlen(betrag+gebuehr)) {
            return betrag;
        }
        return 0d;
    }
}