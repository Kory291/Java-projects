public class sortieren {
    static double[] v = {1.2, -5.2, 3.1, 4.0, 1.9};

    static void sortArray (double[] zahlen) {
        double save;
        for(int i = zahlen.length; i > 1; --i) {
            save = zahlen[i - 1];
            for(int k = i; k < i - 1; ++k) {
                if(zahlen[k] > zahlen[k +1]) {
                    save = zahlen[k];
                    zahlen[k] = zahlen[k + 1];
                    zahlen[k + 1] = save;
                }
            }
        }
    }

    public static void main(String[] args) {
        sortArray(v);
        System.out.println("--");
    }
}
