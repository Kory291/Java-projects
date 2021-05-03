package acc.extern;

import acc.Bank;
import acc.Konto;
import acc.Waehrung;

public class Geldautomat {
 
    static public void auszahlen (int betrag, Konto k) {
        auszahlen(betrag, k, Waehrung.EURO);
    }

    static public void auszahlen (int betrag, Konto k, Waehrung w) {
        double ausgezahlterBetrag = k.auszahlen(betrag, w);
        System.out.printf("%.0f Euro ausgezahlt von Konto %d\n", ausgezahlterBetrag, k.getNr());
    }

    static public void auszahlen1 (int betrag, Bank b, int nr) {
        Konto k = b.getKontoByNr(nr);
        double ausgezahlterBetrag = k.auszahlen(betrag);
        System.out.printf("%.0f Euro ausgezahlt von Konto %d\n", ausgezahlterBetrag, k.getNr());
    }

    static public void auszahlen2 (int betrag, Bank b, int nr) {
        double ausgezahlterBetrag = b.kontoAuszahlen(nr, betrag);
        System.out.printf("%.0f Euro ausgezahlt von Konto %d\n", ausgezahlterBetrag, -1);
    }
}