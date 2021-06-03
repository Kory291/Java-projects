import java.util.Iterator;

class GenerischeKiste<T extends GenerischeFlasche<? extends Getraenk>> implements Iterable<T> {
    private Object[] dinge;
    private int current;
    
    GenerischeKiste(int max) {
        dinge = new Object[max];
        current = 0;
    }

    void push(T p) {  
        if (current < dinge.length) {
            dinge[current++] = p;
        }
    }

    T pop() {
        return (current > 0) ? (T) dinge[--current] : null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int iteratorPos = 0;

            @Override
            public boolean hasNext() {
                return iteratorPos < current;
            }

            @Override
            public T next() {
                return (T) dinge[iteratorPos++];
            }
        }
    }

    public static void main(String[] args) {
        GenerischeKiste<GenerischeFlasche<Bier>> bk = new GenerischecKiste<>(20);
        bk.push(new GenerischeFlasche<Bier>(500));
        bk.push(new GenerischeFlasche<Bier>(500));
        bk.push(new GenerischeFlasche<Bier>(500));

        for(GenerischeFlasche<Bier> bf: bk) {
            System.out.println(bf);
        }
    }
}