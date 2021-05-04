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
    }
}
