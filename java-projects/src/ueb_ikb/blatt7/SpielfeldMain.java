package ueb_ikb.blatt7;
import java.util.Scanner;

public class SpielfeldMain {
    public static void main(String[] args) {
        // SchachSpielfeld sf1 = new SchachSpielfeld();
        // System.out.println(sf1);
        // System.out.println(sf1.getlesen("B8")); 
        // sf1.setzen(new SchachFigur("B", "weiß"), "B4", "B8");
        // System.out.println(sf1);

        // Schach schachSpiel1 = new Schach("Lukas", "Jona");
        // schachSpiel1.spielen();

        TicTacToe tic = new TicTacToe("Lukas", "Jona");
        tic.spielen();
        // TicTacToeSpielfeld tf1 = new TicTacToeSpielfeld();
        // tf1.spielfeld[1][1] = new TicTacToeFigur("X");
        // System.out.println(tf1); 
        // System.out.println(tf1.getlesen("B2"));
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

    public String getFarbe() {
        return this.farbe;
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

    //String[0] Nach-Feld, String[1] Von-Feld, Von-Nach Logik ist auch bei vielen anderen Spielen, wie Dame, später auch bei Mühle
    public String[] getZug(Spielfeld spielfeld) {
        return new String[]{" ", " "};
    }

}

class SchachSpieler extends Spieler {

    SchachSpieler(String name) {
        super(name);
    }

    @Override
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
                    zeile += " " + spielfeld[(k-1)/4][(i-1)/2].getSymbol() + " ";
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

    //zug[0] == Zielfeld, zug[1] == Von-Feld
    public void setzen(Spielfigur spielfigur, String... zug) {
        int xZu = zug[0].charAt(0) - 'A';
        int yZu = spielfeld.length - 1 - zug[0].charAt(1) + '1';
        if(zug.length == 2) {
            int xVon = zug[1].charAt(0) - 'A';
            int yVon = spielfeld.length - 1 - zug[1].charAt(1) + '1';
            spielfeld[xVon][yVon] = new Spielfigur(" ");
        }
        spielfeld[xZu][yZu] = spielfigur;
    }

    public Spielfigur getlesen(String feld) {
        int x = feld.charAt(0) - 'A';
        int y = spielfeld.length - 1 - feld.charAt(1) + '1';
        return spielfeld[x][y];
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
            this.spielfeld[i][1] = new SchachFigur("\u265F", "schwarz");
            this.spielfeld[i][6] = new SchachFigur("\u2659", "weiß");
        }
        //-------------------------Grundreihe-------------------------
        //Türme
        for(int i = 0; i < 2; i++) {
            this.spielfeld[7*i][0] = new SchachFigur("\u265C", "schwarz");
            this.spielfeld[7*i][7] = new SchachFigur("\u265C", "weiß");
        }
        // schwarz
        this.spielfeld[1][0] = new SchachFigur("♞", "schwarz");
        this.spielfeld[2][0] = new SchachFigur("♝", "schwarz");
        this.spielfeld[3][0] = new SchachFigur("♛", "schwarz");
        this.spielfeld[4][0] = new SchachFigur("♚", "schwarz");
        this.spielfeld[5][0] = new SchachFigur("♝", "schwarz");
        this.spielfeld[6][0] = new SchachFigur("♞", "schwarz");
        // weiß
        this.spielfeld[1][7] = new SchachFigur("♘", "weiß");
        this.spielfeld[2][7] = new SchachFigur("♗", "weiß");
        this.spielfeld[3][7] = new SchachFigur("♕", "weiß");
        this.spielfeld[4][7] = new SchachFigur("♔", "weiß");
        this.spielfeld[5][7] = new SchachFigur("♗", "weiß");
        this.spielfeld[6][7] = new SchachFigur("♘", "weiß");
    }
}

class TicTacToeSpielfeld extends Spielfeld {

    TicTacToeSpielfeld() {
        super(3);
    }
}

class Schach {

    private SchachSpielfeld sfeld = new SchachSpielfeld();
    private SchachSpieler[] spieler = new SchachSpieler[2];

    Schach(String nameSp1, String nameSp2) {
        this.spieler[0] = new SchachSpieler(nameSp1);
        this.spieler[1] = new SchachSpieler(nameSp2);
    }

    public void spielen() {
        boolean koenigSchwarz = true;
        boolean koenigWeiß = true;
        int amZug = 1;
        String feld;
        String zug[] = new String[2];
        do {
            amZug = 1 - amZug;
            koenigSchwarz = false;
            koenigWeiß = false;
            System.out.println(sfeld);
            System.out.printf("Am Zug ist: %s\n", spieler[amZug]);
            zug = spieler[amZug].getZug(sfeld);
            if(sfeld.getlesen(zug[0]).getSymbol() != " ") {
                sfeld.setzen(new SchachFigur(sfeld.getlesen(zug[0]).getSymbol(), ((SchachFigur) sfeld.getlesen(zug[0])).getFarbe()), zug[1], zug[0]);
            } else {
                System.out.println("Keine Figur ausgewählt");
            }
            // gucken, ob noch beide Könige auf dem Feld sind --> Spielende
            for(int i = 65; i < 65 + sfeld.spielfeld.length; i++) {
                for(int k = 1; k < sfeld.spielfeld.length + 1; k++) {
                    feld = "";
                    feld += ((char)i);
                    feld += k;
                    if(sfeld.getlesen(feld).getSymbol() == "♔") {
                        koenigWeiß = true;
                    }
                    else if(sfeld.getlesen(feld).getSymbol() == "♚") {
                        koenigSchwarz = true;
                    }
                }
            }
        } while ((koenigSchwarz && koenigWeiß) == true);
        System.out.println("Sieger ist: " + spieler[amZug].toString());
    }
}

class TicTacToe {
    
    TicTacToeSpieler spieler[] = new TicTacToeSpieler[2];
    TicTacToeSpielfeld tfeld = new TicTacToeSpielfeld();
    TicTacToeFigur figuren[] = new TicTacToeFigur[2];

    TicTacToe(String nameSp1, String nameSp2) {
        this.spieler[0] = new TicTacToeSpieler(nameSp1);
        this.spieler[1] = new TicTacToeSpieler(nameSp2);
        this.figuren[0] = new TicTacToeFigur("X");
        this.figuren[1] = new TicTacToeFigur("O");
    }

    private String siegerBestimmen(TicTacToeSpielfeld tfeld) {

        // Spalten
        for (int x=0; x<3; x++) {
            if ((tfeld.getlesen(x, 0).getSymbol() != " ") && (tfeld.getlesen(x, 0).getSymbol() == tfeld.getlesen(x, 1).getSymbol()) && (tfeld.getlesen(x, 1).getSymbol() == tfeld.getlesen(x, 2).getSymbol())) {
                return tfeld.getlesen(x, 0).getSymbol();
            }
        }

        // Zeilen
        for (int y=0; y<3; y++) {
            if (tfeld.getlesen(0, y).getSymbol() != " " && (tfeld.getlesen(0, y).getSymbol() == tfeld.getlesen(1, y).getSymbol()) && (tfeld.getlesen(1, y).getSymbol() == tfeld.getlesen(2, y).getSymbol())) {
                return tfeld.getlesen(0, y).getSymbol();
            }
        }

        // NW-SO-Diagonale
        if ((tfeld.getlesen(0, 0).getSymbol() != " ") && (tfeld.getlesen(0, 0).getSymbol() == tfeld.getlesen(1, 1).getSymbol()) && (tfeld.getlesen(1, 1).getSymbol() == tfeld.getlesen(1, 1).getSymbol())) {
            return tfeld.getlesen(0, 0).getSymbol();
        }

        // SW-NO-Diagonale
        if ((tfeld.getlesen(0, 2).getSymbol() != " ") && (tfeld.getlesen(0, 2).getSymbol() ==tfeld.getlesen(1, 1).getSymbol()) && (tfeld.getlesen(1, 1).getSymbol() == tfeld.getlesen(2, 0).getSymbol())) {
            return tfeld.getlesen(0, 2).getSymbol();
        }

        return "-"; // kein Sieger
    }

    public void spielen() {
        int zuege = 0;
        String feld;
        do{
            System.out.println(tfeld);
            feld = spieler[zuege % 2].getZug(tfeld)[1];
            while(tfeld.getlesen(feld).getSymbol() == "X" || tfeld.getlesen(feld).getSymbol() == "O") {
                System.out.println("Dort kann nicht gesetzt werden.");
                feld = spieler[zuege % 2].getZug(tfeld)[1];
            }
            tfeld.setzen(figuren[zuege % 2], feld);
            zuege++;
        } while((siegerBestimmen(tfeld) == "-") && zuege < 9);
        System.out.println(tfeld);
        System.out.printf("Sieger: %s (%s)", spieler[(zuege - 1 )% 2], figuren[(zuege - 1) % 2].getSymbol());
    }
}