public class matrixOperationen {
    
    static int[][] transpose(int[][] matrix) {
        int[][] matrixT = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                matrixT[j][i] = matrix[i][j];
            }
        }
        return matrixT;
    }

    static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if(matrix1[0].length != matrix2.length) return null;
        int[][] matrixM = new int[matrix1[0].length][matrix2.length];
        for(int i = 0; i < matrixM[0].length; ++i) {
            for(int j = 0; j < matrixM.length; ++j) {
                for(int k = 0; k < matrix1.length; ++k) {
                    matrixM[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixM;
    }

    public static void main(String[] args) {
        int[][] matrixA = {{34, 1}, {17, 15}, {2, 98}};
        int[][] matrixB = transpose(matrixA);
        int[][] a = {{1, 5, 9}, {3, 6, 2}};
        int [][] b = {{2, 3, 7, -1}, {0, 2, 2, 1}, {5, -4, 4, 2}};
        int[][] matrixC = multiply(a, b);
        System.out.println("---");
    }
}
