package abs;

public abstract class Frage {
    String frage;
    Frage(String frage) {
        this.frage = frage;
    }

    String getAnzeigeText() {
        return String.format("Beantworten Sie die folgende Frage: %s\n", frage);
    }

    abstract int getMaxPunkte();
    abstract int getPunktzahl(String teilnehmerLoesung);
}
