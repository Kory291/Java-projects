package ueb_ikb.blatt6;

public class Waehrungsrechner {
    public static void main(String[] args) {
        DM d = new DM(10);
        System.out.println(d.addieren(d));

        Euro e = new Euro(5);
        System.out.println(e.addieren(d));
        System.out.println("---");
    }
}

class Waehrung {
    
    double betrag;

    Waehrung(double betrag) {
        this.betrag = betrag;
    }

    double addieren(Waehrung w) {
        return 0;
    }
}

class Euro extends Waehrung {

    final static double wechselkursToEuro = 1;
    final static double wechselkursFromEuro = 1/wechselkursToEuro;

    Euro(double betrag) {
        super(betrag);
    }

    double addieren(Waehrung w) {
        return betrag += w.betrag;
    }

    double getWechselkurs() {
        return wechselkursToEuro;
    }

}

class DM extends Waehrung {

    final static double wechselkursToEuro = 2;
    final static double wechselkursFromEuro = 1/wechselkursToEuro;

    DM(double betrag) {
        super(betrag);
    }

}

class Franc extends Waehrung {

    final static double wechselkursToEuro = 3;
    final static double wechselkursFromEuro = 1/wechselkursToEuro;
    
    Franc(double betrag) {
        super(betrag);
    }

}