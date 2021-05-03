package acc;

import java.util.ArrayList;
import java.util.List;

import acc.extern.Geldautomat;




public class Bank {
    
    // Sub-Objekt
    private List<Konto> konten;
    
    public void addKonto (String inhaber, int betrag) {
        int nächsteKontoNr = konten.size()+1;
        Konto k = new Konto (nächsteKontoNr, inhaber, betrag);
        konten.add(k);
    }

    public Konto getKontoByNr (int nr) {
        return konten.get(nr-1);
    }

    public Bank () {
        konten = new ArrayList<Konto>();
    }

    // Kapsel-Methode
    public double kontoAuszahlen (int nr, double betrag) {
        return this.getKontoByNr(nr).auszahlen(betrag);
    }

    public static void main(String[] args) {
        
        Bank b = new Bank();
        b.addKonto("Max Mustermann", 100);
        b.addKonto("Tina Teufel", 200);
        b.addKonto("Eva Eigensinn", 300);

        Geldautomat.auszahlen(20, b.getKontoByNr(1));    // einfache Delegation
        BankingApp.kontoStandAnzeigen(b.getKontoByNr(1));

        Geldautomat.auszahlen(20, b.getKontoByNr(1), Waehrung.DOLLAR);    // einfache Delegation
        BankingApp.kontoStandAnzeigen(b.getKontoByNr(1));

        // b.getKontoByNr(1).setDispo(1000);
        // System.out.println(b.getKontoByNr(1).getDispo());


        // Geldautomat.auszahlen(200, k[0]);
        // BankingApp.ueberweisen(40, k[1], k[2]);
        // BankingApp.ueberweisen(740, k[1], k[2]);
        // for (Konto x: k) {
        //     BankingApp.kontoStandAnzeigen(x);
        // }
    }
}
