package ueb_ikb.blatt6;

public class BachetSpiel {
    
}

class Bachet {
    
    int punkte;
    Spieler spieler1;
    Spieler spieler2;

    Bachet(Spieler spieler1, Spieler spieler2) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        punkte = new java.util.Random().nextInt(29) + 1;
    }

    public int spielen() {
        int zuege = 1;
        do {
            zuege % 2 == 0 ? spieler1.setze() : spieler2.setze();
            if(punkte == 100) {
                return zuege % 2 == 0 ? 1 : 2; 
            }
        } while(punkte < 100);
    return 0;
    }
}

class Spieler {
    int setze() {
        
    }
}

class SpielerMensch extends Spieler {
    void zahlZUSetzen() {

    }
}

class SpielerComputer extends Spieler {
    void berechneZug() {

    }
}