package ueb_ikb;

public class Palindrom {
    
    static boolean istPalindrom (long v) {

        // long --> String --> Array-char
        // for (int i=0; i<s.length; i++) { if (s[i]==s[length-i-1])}
        
        long v_original = v;
        long v_reverse = 0;

        // v%10 ... liefert letzte Stelle
        // v/10 ... entfernt letzte Stelle

        while (v > 0) {
            v_reverse = v_reverse*10 + v%10;    // letzte Stelle hinzufügen
            v = v/10; // äquivalent zu v /= 10;
        }

        return v_reverse == v_original;
    }



    public static void main(String[] args) {
     
        
        System.out.println(istPalindrom(18581));
        System.out.println(istPalindrom(45));
        System.out.println(istPalindrom(4));
    }
}
