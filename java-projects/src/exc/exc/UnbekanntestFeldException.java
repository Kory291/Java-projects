package exc;
public class UnbekanntestFeldException extends Exception {
    
    String feldName;
    String grund;

    UnbekanntestFeldException(String feldName, String grund) {
        this.feldName = feldName;
        this.grund = grund;
    }

    @Override
    public String toString() {
        return "Feld fehlerhaft";
    }
}
