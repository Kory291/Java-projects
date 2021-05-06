class RZ {

    private int zaehler;
    private int nenner;

    RZ(int zaehler, int nenner) {
        this.nenner = Math.abs(nenner);
        this.zaehler = Math.abs(zaehler);
        kuerzen();
    }

    void kuerzen() {
        //moderner euklidischer Algorithmus zur Bestimmung des ggT
        int ggT = euclid(this.zaehler, this.nenner);
        this.zaehler = zaehler / ggT;
        this.nenner = nenner / ggT; 
    }

    int euclid(int a,int b) {
        if(b == 0) {
            return a;
        }
        else {
            return euclid(b,(a % b));
        }
    }

    void addiere(RZ andererBruch) {
        this.zaehler =  (this.getZaehler() * andererBruch.getNenner()) + (andererBruch.getZaehler() * this.getNenner());
        this.nenner = this.nenner * andererBruch.getNenner();
        kuerzen();
    }

    public static RZ summe(RZ x, RZ y) {
        RZ z = new RZ((x.zaehler * y.nenner) + (y.zaehler * x.nenner), x.nenner * y.nenner);
        z.kuerzen();
        return z;
    }

    public static RZ summe2(RZ x, RZ y) {
        RZ z = new RZ(x.getZaehler(), x.getNenner());
        z.addiere(y);
        return z;
    }

    public int getNenner() {
        return this.nenner;
    }

    public int getZaehler() {
        return this.zaehler;
    }
}

public class rationaleZahlen {
    public static void main(String[] args) {
        RZ bruch1 = new RZ(8,4);
        System.out.println("---");
        bruch1.kuerzen();
        System.out.println("---");
        bruch1.addiere(new RZ(2, 1));
        System.out.println("---");
        RZ bruch2 = RZ.summe(new RZ(8,4), new RZ(2,1));
        System.out.println("---");
        RZ bruch3 = RZ.summe2(new RZ(4, 16), new RZ(3, 6));
        System.out.println("---");
    }
}