package TicTacToe;

public class Spielfeld {
    private static char[][] feldZustand; // X für Spieler 1, O für Spieler 2, '' für noch nicht besetzt.

    public static void spielfeldAnzeigen() {
        for(int x = 0; x < 15; x++) {
            if(x % 4 != 0) System.out.printf("")
            System.out.printf("%d")
        }
    }


    static private void spiel() {

    }

    static private void erbitteZug() {

    }

    public char[][] getFeldZustand() {
        return this.feldZustand;
    }

    public static void main(String[] args) {
        spiel();
    }
}
