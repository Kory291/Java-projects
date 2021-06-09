package ueb_ikb.blatt7;
import java.util.Collection;

public class Spielkarten {
    public static void main(String[] args) {
        Kartenstapel skat = new Kartenstapel(Blatt.Poker);
        System.out.println("--");
    }
}

enum Blatt {

    Skat(32), Poker(52);
    Spielkarte[] spielkarten;

    Blatt(int karten) {
        for(int i = 0; i < karten; i++) {
            spielkarten[i] = new Spielkarte();
        }
    }
}


class Spielkarte {
    final String farbe;
    final String wert;

    Spielkarte() {
        this.farbe = 
    }
}

class Kartenstapel {
    Blatt typ;
    Kartenstapel(Blatt typ) {
        this.typ = typ;
    }

    public Spielkarte karteAusteilen() {

    }

    public void mischen() {

    }
}