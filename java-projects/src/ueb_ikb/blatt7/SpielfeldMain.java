package ueb_ikb.blatt7;
import java.util.Scanner;

public class SpielfeldMain {
    public static void main(String[] args) {
        SchachSpielfeld sf1 = new SchachSpielfeld();
        System.out.println(sf1); 

        // TicTacToeSpielfeld tf1 = new TicTacToeSpielfeld();
        // System.out.println(tf1); 
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

    String farbe;

    SchachFigur(String symbol, String farbe) {
        super(symbol);
        this.farbe = farbe;
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

    public String[] getZug(Spielfeld spielfeld) {
        return new String[]{" ", " "};
    }

}

class SchachSpieler extends Spieler {

    SchachSpieler(String name) {
        super(name);
    }

    public String[] getZug(Spielfeld spielfeld) {
        Scanner sc = new Scanner(System.in);
        String[] antwort = new String[2];
        System.out.println("Von-Feld eingeben: ");
        antwort[0] = sc.nextLine();
        System.out.println("Nach-Feld eingeben: ");
        antwort[1] = sc.nextLine();
        return antwort;
    }
}

class TicTacToeSpieler extends Spieler {

    TicTacToeSpieler(String name) {
        super(name);
    }

    public String[] getZug(Spielfeld spielfeld) {
        Scanner sc = new Scanner(System.in);
        String[] antwort = new String[2];
        System.out.println("Wo wollen Sie setzen?: ");
        antwort[1] = sc.nextLine();
        return antwort;
    }
}

class Spielfeld {

    protected Spielfigur[][] spielfeld;  //nur interne Darstellung

    Spielfeld(int groesse) {
        this.spielfeld = new Spielfigur[groesse][groesse];
        for(int i = 0; i < groesse; i++) {
            for(int k = 0; k < groesse; k++) {
                spielfeld[i][k] = new Spielfigur(" ");
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
                    zeile += " " + spielfeld[(i-1)/2][(k-1)/4].getSymbol() + " ";
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
        spielfeld[x][y] = spielfigur;
    }

    public Spielfigur getlesen(int x, int y) {
        return spielfeld[x][y];
    }
}

class SchachSpielfeld extends Spielfeld {

    SchachSpielfeld() {
        super(8);
        //Bauern
        for(int i = 0; i < spielfeld.length; i++) {
            this.spielfeld[1][i] = new SchachFigur("\u265F", "schwarz");
            this.spielfeld[6][i] = new SchachFigur("\u2659", "weiß");
        }
        //-------------------------Grundreihe-------------------------
        //Türme
        for(int i = 0; i < 2; i++) {
            this.spielfeld[0][7*i] = new SchachFigur("\u265C", "schwarz");
            this.spielfeld[7][7*i] = new SchachFigur("\u265C", "weiß");
        }
        // schwarz
        this.spielfeld[0][1] = new SchachFigur("♞", "schwarz");
        this.spielfeld[0][2] = new SchachFigur("♝", "schwarz");
        this.spielfeld[0][3] = new SchachFigur("♛", "schwarz");
        this.spielfeld[0][4] = new SchachFigur("♚", "schwarz");
        this.spielfeld[0][5] = new SchachFigur("♝", "schwarz");
        this.spielfeld[0][6] = new SchachFigur("♞", "schwarz");
        // weiß
        this.spielfeld[7][1] = new SchachFigur("♘", "weiß");
        this.spielfeld[7][2] = new SchachFigur("♗", "weiß");
        this.spielfeld[7][3] = new SchachFigur("♕", "weiß");
        this.spielfeld[7][4] = new SchachFigur("♔", "weiß");
        this.spielfeld[7][5] = new SchachFigur("♗", "weiß");
        this.spielfeld[7][6] = new SchachFigur("♘", "weiß");
    }
}

class TicTacToeSpielfeld extends Spielfeld {

    TicTacToeSpielfeld() {
        super(3);
    }
}

