package oo;

import java.time.LocalDate;
import java.util.Arrays;

public class Beispiele {
    

    public static void main(String[] args) {
        
        // int[] vek = new int[3];
        int[] vek = new int[]{1, 6, -2, 5};
        vek[0] = 4;

        vek = new int[5];
        vek[2] = 45;
        vek[4] = -5;

        Student maier = new Student(21, "Maier", LocalDate.of(2020, 10, 1));
        maier = new Student(21, "Maier", LocalDate.of(2020, 10, 1));

        // int[][] matrix = new int[2][3];
        int[][] matrix = new int[2][];
        for (int z = 0; z<2; z++) {
            matrix[z] = new int[3];
            for (int s=0; s<3; s++) {
                matrix[z][s] = 3*z+s;
            }
        }

        int[][] matrix2 = new int[][] { { 0, 1, 2} , {3, 4, 5}};


        int[][] matrix3 = new int[3][];
        matrix3[0] = new int[]{ 0, 1, 2};
        matrix3[2] = new int[]{3, 4};

        int[] x = { 4, 6, 7};
        int[][] y = { {1, 2, 3}, {4, 5}};
        int[][] z = new int[3][];

        // System.out.println(y[1][2]);

        y[1]=x;
        System.out.println(z[1]);
        z = new int[][]{{1,2},{3,4},{5,6}};

        System.out.println("--");
    }

}
