public class FrageMC extends Frage {
    String[] antwortOptionen;
    int[] punkteProOption;

    FrageMC(String frage, String[] antwortOptionen, int[] punkteProOption) {
        super(frage);
        this.antwortOptionen = antwortOptionen;
        this.punkteProOption = punkteProOption;
    }

    @Override
    int getMaxPunkte() {
        int summePositiv = 0;
        for (int i = 0; i <punkteProOption.length; i++) {
            if(punkteOption[i] > 0) {
                summePositiv += punkteOption[i];
            }
        }
    }

    @Override
    int getPunktzahl(Stirng teilnehmerLoesung) {
       int result = 0;
       for(int i = 0; i <punkteProOption.length; i++) {
            if(teilnehmerLoesung.contains(Character.toString('A'+ i ))) {
                result += punkteProOption[i];
            }
        }
        return result; 
    }

    @Override
    String getAnzeigeText() {
        String result = super.getAnzeigeText();
        for(int i = 0; i <antwortOptionen.length; i++) {
            result += String.format("\n[%s] %s", Character.toString('A' + i), antwortOptionen[i]);
        }
    }
}
