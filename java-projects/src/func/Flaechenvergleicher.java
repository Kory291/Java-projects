import java.util.Comparator;

public class Flaechenvergleicher implements Comparator<Rechteck> {

    @Override
    public int compare(Rechteck o1, Rechteck o2) {
        return o1.getFlaeche() - o2.getFlaeche();
    }
    
}
