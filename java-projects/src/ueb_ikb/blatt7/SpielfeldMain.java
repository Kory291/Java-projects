package ueb_ikb.blatt7;

public class SpielfeldMain {
    
}

class Spielfigur {
    
    private final String zeichen;

    Spielfigur(String zeichen) {
        this.zeichen = zeichen;
    }

    @Override
    public String toString() {
        return zeichen;
    }

    public String getSymbol() {
        return zeichen;
    }
}

class Spieler {
    
    private final String name;

    Spieler(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Spielfeld getZug(Spielfeld spielfeld) {

    }

}

class Spielfeld {

    private String[][] spielfeld;  //nur interne Darstellung

    Spielfeld(int groesse) {
        this.spielfeld = new String[groesse][groesse];
    }

    @Override
    public String toString() {
        String repraensentation;
        for(int i = 0; i < 4 * spielfeld.length; i++) {
            for(int k = 0; k < 4 * spielfeld.length; k++) {
                if(k % 4 == 0 && i % 4 == 0) {
                    String zeile = "" + spielfeld[i][k] + ""
                }
            }
        }
        return repraensentation;
    }

    public void setzen(Spielfigur spielfigur, int x, int y) {
        spielfeld[x][y] = spielfigur.getSymbol();
    }

    public String lesen(int x, int y) {
        return spielfeld[x][y];
    }
}
