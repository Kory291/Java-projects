import java.util.Arrays;

public class Matrix {

    static int[][] transpose(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;

        int[][] result = new int[b][a];
        for(int x = 0; x < a; x++) {
            for(int y = 0; y < b; y++) {
                result[y][x] = matrix[x][y];
            }
        }
        return result;
    }

    static int[][] multiply(int[][] m1, int[][] m2) {
        int a = m1.length;      //m1 = a x b
        int b = m1[0].length;
        int c = m2[0].length;      //m2 = b x c
        
        if (b != m2.length) return null;

        int[][] result = new int[a][c];

        for(int x = 0; x < a; x++) {
            for (int y = 0; y < c; y++) {
                //jeder Result-Element: result[x][y] ist Summe der Produkte der Zeilen/Spalten-Paare
                for(int z = 0; z < b; z++) {
                    result[x][y] += m1[x][z] * m2[z][y];
                }

            }
        }
        return result;
    }

    static boolean matrixGleich(int[][] m1, int[][] m2) {

        //Test auf null
        if((m1 == null) || (m2 == null)) return false;

        //Test auf gleicher Länge in erster Dimension
        if((m1.length != m2.length) || (m1.length == 0)) return false;
       
        //Test auf gleiche Länge für jedes Element in zweiter Dimension
        for(int x = 0; x < m1.length; x++) {
            if(m1[x].length != m2[x].length) return false;
        }

        for(int x = 0; x < m1.length; x++) {
            for(int y = 0; y < m1[x].length; y++) {
                if(m1[x][y] != m2[x][y]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{34, 1}, {17, 15}, {7, 98}};
        int[][] b = transpose(a);
        
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));

        int[][] c = {{1, 5, 9}, {3, 6, 2}};
        int[][] d = {{2, 3, 7, -1}, {0, 2, 2, 1}, {5, -4, 4, 2}};

        int[][] e = multiply(c, d);
        System.out.println(Arrays.deepToString(e));
        
        int[][] f = {{1, 5, 9}, {3, 6, 2}};
        int[][] g = {{1, 5, 9}, {3, 6, 22}};
        System.out.println(matrixGleich(f, g));
    }
}
