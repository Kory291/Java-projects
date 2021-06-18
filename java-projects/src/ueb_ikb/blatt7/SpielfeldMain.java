package ueb_ikb.blatt7;

public class SpielfeldMain {
    public static void main(String[] args) {
        Spielfeld sf1 = new Spielfeld(6);
        System.out.println(sf1); 
    }
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

class SchachFigur extends Spielfigur {

    SchachFigur(String symbol) {
        super(symbol);
    }
}

class TicTacToeFigur extends Spielfigur {

    TicTacToeFigur(String symbol) {
        super(symbol);
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

    public String getZug(Spielfeld spielfeld) {
        return "";
    }

}

class SchachSpieler extends Spieler {

    SchachSpieler(String name) {
        super(name);
    }

}

class TicTacToeSpieler extends Spieler {

    TicTacToeSpieler(String name) {
        super(name);
    }
}

class Spielfeld {

    private String[][] spielfeld;  //nur interne Darstellung

    Spielfeld(int groesse) {
        this.spielfeld = new String[groesse][groesse];
        for(int i = 0; i < groesse; i++) {
            for(int k = 0; k < groesse; k++) {
                spielfeld[i][k] = "\u265F";
            }
        }
    }

    @Override
    public String toString() {
        String repraensentation = "";
        String zeile = "";
        for(int i = 1; i < 2 * spielfeld.length + 2; i++) {
            for(int k = 1; k < 4 * spielfeld.length + 3; k++) {
                if(k % 4 == 0 && i % 2 == 0) {
                    zeile += " " + spielfeld[(i - 1)/4][(k - 1)/4] + " ";
                }
                else if(k % 4 == 2 && i % 2 == 0) {
                    zeile += "|";
                }
                if(k % 4 == 0 && i % 2 == 1) {
                    zeile += "---";
                }
                else if(k % 4 == 2 && i % 2 == 1) {
                    zeile += "+";
                }
            }
            repraensentation += zeile + "\n";
            zeile = "";
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

class SchachSpielfeld extends Spielfeld {

    SchachSpielfeld() {
        super(8);
    }
}

class TicTacToeSpielfeld extends Spielfeld {

    TicTacToeSpielfeld() {
        super(3);
    }
    
}