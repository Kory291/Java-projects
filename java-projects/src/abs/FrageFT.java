public class FrageFT extends Frage{
    String korrekteLoesung;
    int punktzahl;

    FrageFT(String frage, String korrekteLoesung, int punktzahl) {
        super(frage);
        this.korrekteLoesung = korrekteLoesung;
        this.punktzahl = punktzahl;
    }

    @Override
    int getMaxPunkte() {
        return punktzahl;
    }

    @Override
    int getPunktzahl(String teilnehmerLoesung) {
        return korrekteLoesung.equalsIgnoreCase(teilnehmerLoesung.trim()) ? punktzahl : 0;
    }
}
