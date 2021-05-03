package inh;

public class Konto {
    private int kontoNummer;
    protected double kontoStand;
    static int maxNr = 0;
    String inhaber;

    public double getKontoStand() {
        return kontoStand;
    }

    Konto(double s) {
        this.kontoNummer = ++Konto.maxNr;
        kontoStand = s;
        this.inhaber = "KontoInhaber";
    }

   
    public double auszahlen (double betrag) {
        if ((betrag>0) && (this.kontoStand >=betrag)) {
            this.kontoStand -= betrag;
            return betrag;
        }
        return 0d;
    }

    public double einzahlen (double betrag) {
        if (betrag>0) {
            this.kontoStand += betrag;
            return betrag;
        }
        return 0d;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }


    public static void main(String[] args) {
        Girokonto g = new Girokonto(100, 2.5f, 1d);
        g.verzinsen();
        g.auszahlen(50);

        g.toString();

        ((Konto)g).auszahlen(10);
        System.out.println("--");
    }
}