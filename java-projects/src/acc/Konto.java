package acc;

import java.util.ArrayList;
import java.util.List;

public class Konto {
    private int kontoNummer;
    private String inh_nachname, inh_vorname;
    private double kontoStand;

    private double dispo = 100;

    private static int anzKonten = 0;

    public double getDispo() {
        return dispo;
    }

    public void setDispo(double dispo) {
        this.dispo = Math.min (this.dispo*1.1, dispo);
    }

    double getKontoStand() {
        return kontoStand;
    }

    public int getNr() {
        return kontoNummer;
    }

    public String getInhaber() {
        return inh_vorname + " " + inh_nachname;
    }

    void setInhaber (String s) {
        String[] a = s.split(" ");
        this.inh_vorname = a[0];
        this.inh_nachname = a[1];
    }

    List<Double> aenderungen;

    Konto(int nr, String i, double s) {
        this.kontoNummer = nr;
        setInhaber(i);
        kontoStand = s;
        this.dispo = 100;
        this.aenderungen = new ArrayList<Double>();
    }

    public double auszahlen (double betrag, Waehrung w) {
        return this.auszahlen(w.inEuro(betrag));
    }
    
    public double auszahlen (double betrag) {
        if ((betrag>0) && (this.kontoStand + this.dispo>=betrag)) {
            this.kontoStand -= betrag;
            this.aenderungen.add(-betrag);
            return betrag;
        }
        return 0d;
    }

    public double einzahlen (double betrag, Waehrung w) {
        return this.einzahlen(w.inEuro(betrag));
    }

    public double einzahlen (double betrag) {
        if (betrag>0) {
            this.kontoStand += betrag;
            this.aenderungen.add(betrag);
            return betrag;
        }
        return 0d;
    }

}

