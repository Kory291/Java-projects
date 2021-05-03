package acc;

public class BankingApp {
    static void ueberweisen (double betrag, Konto von, Konto nach) {
        double ueberwiesenerBetrag = nach.einzahlen (von.auszahlen(betrag));
        System.out.printf("%.2f Euro überweisen von Konto %d nach %d\n", ueberwiesenerBetrag, von.getNr(), nach.getNr());
    }

    static void kontoStandAnzeigen (Konto k) {
        System.out.printf("Konto %d von %s hat Kontostand %.2f\n", k.getNr(), k.getInhaber(), k.getKontoStand());
    }
}