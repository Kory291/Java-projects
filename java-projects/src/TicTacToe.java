import java.util.Scanner;

public class TicTacToe {

    static char[][] spielfeld;

    
    static void spielfeldAnzeigen() {

        System.out.print("\n      A  B  C");
        for (int y=0; y<3; y++) {
            System.out.printf("\n %d : ", y+1);
            for (int x=0; x<3; x++) {
                System.out.printf(" %c ", spielfeld[x][y]);
            }
        }
    }

    static char siegerBestimmen() {

        // Spalten
        for (int x=0; x<3; x++) {
            if ((spielfeld[x][0] != ' ') && (spielfeld[x][0] == spielfeld[x][1]) && (spielfeld[x][1] == spielfeld[x][2])) {
                return spielfeld[x][0];
            }
        }

        // Zeilen
        for (int y=0; y<3; y++) {
            if ((spielfeld[0][y] != ' ') && (spielfeld[0][y] == spielfeld[1][y]) && (spielfeld[1][y] == spielfeld[2][y])) {
                return spielfeld[0][y];
            }
        }

        // NW-SO-Diagonale
        if ((spielfeld[0][0] != ' ') && (spielfeld[0][0] == spielfeld[1][1]) && (spielfeld[1][1] == spielfeld[2][2])) {
            return spielfeld[0][0];
        }

        // SW-NO-Diagonale
        if ((spielfeld[0][2] != ' ') && (spielfeld[0][2] == spielfeld[1][1]) && (spielfeld[1][1] == spielfeld[2][0])) {
            return spielfeld[0][2];
        }

        return '-'; // kein Sieger
    }
    
    static void setzen (String feld, char zeichen) {
        int x = feld.charAt(0)-'A';
        int y = feld.charAt(1)-'1';
        spielfeld[x][y] = zeichen;
    }

    public static void main(String[] args) {
        
        spielfeld = new char[][] {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        spielfeldAnzeigen();

        Scanner sc = new Scanner(System.in);
        int anzahlZuege = 0;
        boolean ersterSpieler = true;
        char sieger;
        do {
            System.out.printf("\n%s Spieler setzt auf", ersterSpieler ? "1." : "2.");
            String setzenAuf = sc.nextLine();

            setzen (setzenAuf, ersterSpieler ? 'X' : 'O');
            spielfeldAnzeigen();
            anzahlZuege++;
            ersterSpieler = !ersterSpieler;
            sieger = siegerBestimmen();
        } while ((anzahlZuege<9) && (sieger =='-'));

        System.out.println("Sieger ist " + sieger);
        spielfeldAnzeigen();
    }
}