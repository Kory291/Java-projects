abstract class Getraenk {
    String name;
    Getraenk (String name) {
        this.name = name;
    }
    public String toString() {
        return String.format("name=%s", name);
    }
}

class Apfelsaft extends Getraenk {
    boolean istKlar;
    Apfelsaft (String name, boolean istKlar) {
        super(name);
        this.istKlar = istKlar;
    }
    public String toString() {
        return String.format("%s, istKlar=%b", super.toString(), istKlar);
    }
}

abstract class AlkoholischesGetraenk extends Getraenk {
    double alkGehalt;
    AlkoholischesGetraenk (String name, double alkGehalt) {
        super (name);
        this.alkGehalt = alkGehalt;
    }
    public String toString() {
        return String.format("%s, alkGehalt=%.1f", super.toString(), alkGehalt);
    }
}

class Bier extends AlkoholischesGetraenk {
    String sorte;
    Bier (String name, double alkGehalt, String sorte) {
        super(name, alkGehalt);
        this.sorte = sorte;
    }
    public String toString() {
        return String.format("%s, sorte=%s", super.toString(), sorte);
    }
}

class Wein extends AlkoholischesGetraenk {
    String farbe;
    Wein (String name, double alkGehalt, String farbe) {
        super(name, alkGehalt);
        this.farbe = farbe;
    }
    public String toString() {
        return String.format("%s, farbe=%s", super.toString(), farbe);
    }
}


