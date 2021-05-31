public class Waehrungsrechner {
    public static void main(String[] args) {
        DM d = new DM(10);
        System.out.println(d.addieren(d));

        Euro e = new Euro(5);
        System.out.println(e.addieren(new DM(10)));
        System.out.println("---");
        
    }
}

class Waehrung {
    
    private double betrag;
    private final double wechselkursToEuro;
    private final String kuerzel;

    Waehrung(double betrag, double wechselkurs, String kuerzel) {
        this.betrag = betrag;
        this.wechselkursToEuro = wechselkurs;
        this.kuerzel = kuerzel;
    }

    double addieren(Waehrung w) {
        betrag = betrag * wechselkursToEuro;
        betrag += w.betrag * w.wechselkursToEuro;
        betrag = betrag * (1/wechselkursToEuro);
        return betrag;
    }

    @Override
    public String toString() {
        return betrag + " " + kuerzel;
    }

}

class Euro extends Waehrung {

    Euro(double betrag) {
        super(betrag, 1, "EUR");
    }
}

class DM extends Waehrung {
    DM(double betrag) {
        super(betrag, 0.511292, "DM");
    }
}

class Franc extends Waehrung {   

    Franc(double betrag) {
        super(betrag, 0.152449, "Franc");
    }
}