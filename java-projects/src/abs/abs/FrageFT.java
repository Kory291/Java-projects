package abs;

class FrageFTManu extends Frage{

    String korrekteLoesung;
    int punktzahl;

    FrageFTManu(String frage, String korrekteLoesung, int punktzahl) {
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

class FrageFT extends Frage{

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

class FrageFTAuto extends FrageFTManu implements AutomatischeBewertung {

String korrekteLoesung;

FrageFTAuto(String frage, String korrekteLoesung, int punktZahl) {
    super(frage, punktZahl);
    this.korrekteLoesung = korrekteLoesung;
}

    @Override
    public int getPunktzahl(String teilnehmerLoesung) {
        return korrekteLoesung.equalsIgnoreCase(teilnehmerLoesung.trim()) ? punktzahl : 0;    
    }
}