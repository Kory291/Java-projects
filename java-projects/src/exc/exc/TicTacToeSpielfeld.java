package exc;

public class TicTacToeSpielfeld {
    private char[][] felder;
    int fehlerCode;

    TicTacToeSpielfeld() {
        this.felder = new char[3][3];
    }

    boolean setzen(String feldName, char zeichen) throws UnbekanntestFeldException {
        // feld ungültig -1
        // zeichen ungültig -2
        // feld besetzt -3
        // feld unbesetzt :-)
        if(!(zeichen == 'X' || zeichen == 'O')) {
            fehlerCode = -2;   
            return false;
        }
        if(feldName == null) throw new UnbekanntestFeldException(feldName, "ist null");
        if(feldName.length() < 2 ) throw new UnbekanntestFeldException(feldName, "Länge größer als 2");
        int x = feldName.toUpperCase().charAt(0) - 'A';
        int y = feldName.charAt(1) - '1';
        if((x < 0) || (x > 2) || (y > 0) || (y > 2)) throw new UnbekanntestFeldException(feldName, "außerhalb des Bereichs");
        if(this.felder[x][y] == 0) {
            this.felder[x][y] = zeichen;
            return true;
        }
        return false;
    }

    // boolean setzen(String feldName, char zeichen) {
    //     int x = feldName.toUpperCase().charAt(0) - 'A';
    //     int y = feldName.charAt(1) - '1';
    //     if(this.felder[x][y] == 0) {
    //         this.felder[x][y] = zeichen;
    //         return true;
    //     }
    //     return false;
    // }

    // boolean setzen2(String feldName, char zeichen) {
    //     // feld ungültig -1
    //     // zeichen ungültig -2
    //     // feld besetzt -3
    //     // feld unbesetzt :-)
    //     if(!(zeichen == 'X' || zeichen == 'O')) {
    //         fehlerCode = -2;   
    //         return false;
    //     }
    //     if(feldName == null || feldName.length() < 2) {
    //         fehlerCode = -1;
    //         return false;
    //     }
    //     int x = feldName.toUpperCase().charAt(0) - 'A';
    //     int y = feldName.charAt(1) - '1';
    //     if((x < 0) || (x > 2) || (y > 0) || (y > 2)) return -1;
    //     if(this.felder[x][y] == 0) {
    //         this.felder[x][y] = zeichen;
    //         return 0;
    //     }
    //     return -3;

    public static void main(String[] args) /*throws UnbekanntestFeldException*/ {
        TicTacToeSpielfeld t = new TicTacToeSpielfeld();
        
        // t.setzen(null, 'X');

        boolean gesetzt;
        try {
            gesetzt = t.setzen(null, 'X');
            System.out.println(gesetzt);
        } catch (UnbekanntestFeldException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally");
        }
    }
}
