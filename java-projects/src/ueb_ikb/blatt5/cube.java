class Wuerfel {
    private int augenzahl;

    Wuerfel() {
        wuerfle();
    }

    void wuerfle() {
        augenzahl = new java.util.Random().nextInt(6) + 1;
    }

    public int getAugenzahl() {
        return augenzahl;
    }

    public String[] ausgabeInString() {
        switch (augenzahl) {
            case 1:
                String[] ausgabe1 = {
                    "+---+",
                    "|   |",
                    "| * |",
                    "|   |",
                    "+---+"
                };
                return ausgabe1;
            case 2:
                String[] ausgabe2 = {
                    "+---+",
                    "|*  |",
                    "|   |",
                    "|  *|",
                    "+---+"
                };
                return ausgabe2; 
            case 3:
                String[] ausgabe3 = {
                    "+---+",
                    "|  *|",
                    "| * |",
                    "|*  |",
                    "+---+"
                };
                return ausgabe3;
            case 4:
                String[] ausgabe4 = {
                    "+---+",
                    "|* *|",
                    "|   |",
                    "|* *|",
                    "+---+"
                };
                return ausgabe4;
            case 5:
                String[] ausgabe5 = {
                    "+---+",
                    "|* *|",
                    "| * |",
                    "|* *|",
                    "+---+"
                };
                return ausgabe5;
            case 6:
                String[] ausgabe6 = {
                    "+---+",
                    "|* *|",
                    "|* *|",
                    "|* *|",
                    "+---+"
                };
                return ausgabe6; 
        }
        return null;
    }   
}



public class cube {
    public static void main(String[] args) {
        Wuerfel wuerfel1 = new Wuerfel();
        String[] ausgabeWuerfel1 = wuerfel1.ausgabeInString();
        for(int i = 0; i < 5; i++) {
            System.out.println(ausgabeWuerfel1[i]);
        }
    }
}
