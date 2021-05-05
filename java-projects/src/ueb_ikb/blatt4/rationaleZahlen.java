class RZ {

    int zaehler;
    int nenner;

    RZ(int zaehler, int nenner) {
        this.nenner = Math.abs(nenner);
        this.zaehler = Math.abs(zaehler);
        kuerzen();
    }

    void kuerzen() {
        //moderner euklidischer Algorithmus zur Bestimmung des GGT
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
        this.zaehler =  (this.zaehler * andererBruch.nenner) + (andererBruch.zaehler * this.nenner);
        this.nenner = this.nenner * andererBruch.nenner;
        kuerzen();
    }

    static RZ summe(RZ x, RZ y) {
        RZ z = new RZ((x.zaehler * y.nenner) + (y.zaehler * x.nenner), x.nenner * y.nenner);
        z.kuerzen();
        return z;
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
        RZ bruch2 = bruch1.summe(new RZ(8,4), new RZ(2,1));
        System.out.println("---");
    }
}