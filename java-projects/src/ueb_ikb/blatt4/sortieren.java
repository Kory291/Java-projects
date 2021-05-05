<<<<<<< HEAD
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
=======
//package ueb_ikb.blatt4;

public class sortieren {
    static void sortArray (double[] zahlen) {
        for(int i = zahlen.length; i > 1; --i) {
            for(int k = 0; k < i -1; ++k) {
                if(zahlen[k] > zahlen[k + 1]) {
                    double save = zahlen[k];
                    zahlen[k] = zahlen[k + 1];
                    zahlen[k + 1] = save; 
                }
            }
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        double[] v = {0.2, -2, 31, 0.3, 5};
        sortArray(v);
>>>>>>> 7ad13dab48c5a2472a4bbc1d62b03ab480fc31d3
    }
}
