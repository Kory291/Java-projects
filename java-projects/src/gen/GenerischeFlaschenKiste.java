public class GenerischeFlaschenKiste<T extends Getraenk> {
    private Object[] dinge;
    private int current;

    GenerischeFlaschenKiste(int max) {
        dinge = new Object[max];
        current = 0;
    }

    void push(GenerischeFlasche<?> p) {     //"?" irgendein Typ, Wildcard
        if (current < dinge.length) {
            dinge[current++] = p;
        }
    }

    GenerischeFlasche<T> pop() {
        return (current > 0) ? (GenerischeFlasche<T>) dinge[--current] : null;
    }

    public static void main(String[] args) {
        GenerischeFlaschenKiste<Bier> bk = new GenerischeFlaschenKiste(16);
        bk.push(new GenerischeFlasche<Bier>(500));
        //bk.push(new GenerischeFlasche<Wein>(500));
    }

}

