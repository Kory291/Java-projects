import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Rechteck implements Comparable<Rechteck> {
    private final int hoehe;
    private final int breite;
    
    Rechteck(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getUmfang() {
        return 2*(breite + hoehe);
    }

    public int getFlaeche() {
        return hoehe * breite;
    }

    public boolean istQuadrat() {
        return breite == hoehe;
    }

    @Override
    public String toString() {
        return "Rechteck " + hoehe + " x " + breite;
    }

    @Override
    public int compareTo(Rechteck o) {
        return this.getFlaeche() - o.getFlaeche();
    }

    public static void main(String[] args) {
        Rechteck r = new Rechteck(3,4);
        System.out.println(r);

        // List<Rechteck> rechtecke = new ArrayList<>();
        // rechtecke.add(new Rechteck(2,5));

        List<Rechteck> rechtecke = Arrays.asList(
            new Rechteck(3, 10),
            new Rechteck(2,5),  
            new Rechteck(7,5),  
            new Rechteck(4, 11));
        
        // for(Rechteck x: rechtecke) {
        //     System.out.println(x);
        // }

        // Collections.sort(rechtecke);

        // for(Rechteck x: rechtecke) {
        //     System.out.println(x);
        // }

        // //eigene Klase + Instanz
        // rechtecke.sort(new Flaechenvergleicher());

        // //anonyme innere Klasse
        // Comparator<Rechteck> flVergleich = new Comparator<Rechteck> () {

        //     @Override
        //     public int compare(Rechteck o1, Rechteck o2) {
        //         return o1.getFlaeche() - o2.getFlaeche();
        //     }
        // };
        // rechtecke.sort(flVergleich);

        Comparator<Rechteck> sortByFlaeche = (o1, o2)  -> o1.getFlaeche() - o2.getFlaeche();
        Comparator<Rechteck> sortByUmfang = (o1, o2) -> o1.getUmfang() - o2.getUmfang();

        rechtecke.sort(sortByUmfang.reversed());
        for(Rechteck x: rechtecke) {
            System.out.println(x);
        }

        rechtecke.sort(sortByFlaeche.thenComparing(sortByUmfang));
        for(Rechteck x: rechtecke) {
            System.out.println(x);
        }

        BiFunction<Integer, Integer, String> thorHatSpaß = (x, y) -> "x=" + x + " y=" + y + " x+y=" + x +y;
        System.out.println(thorHatSpaß.apply(3, 2));

        BiFunction<Comparator<Rechteck>, Comparator<Rechteck>, Comparator<Rechteck>> sortConcat =
            (c1, c2) -> (o1, o2) -> c1.compare(o1, o2) != 0 ? c1.compare(o1, o2) : c2.compare(o1, o2);

        sortConcat.apply(sortByFlaeche, sortByUmfang);

        int q = rechtecke.stream()
            .map(a -> r.getFlaeche())
            .mapToInt(i -> i.intValue())
            .sum();

        List<Rechteck> w = rechtecke.stream() 
            //.filter(a -> a.getHoehe() == a.getBreite())
            //.filter(a -> a.istQuadrat())
            .filter(Rechteck::istQuadrat)
            .peek(System.out::println)
            .collect(Collectors.toList());
        System.out.println(w);
    }
}