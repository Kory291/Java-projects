package oo;

import java.time.LocalDate;
import java.util.Arrays;

public class Gleichheit {
  
    public static void main(String[] args) {
        
        Student maier = new Student(21, "Maier", LocalDate.of(2020, 10, 1));
        Student mueller = new Student(21, "Maier", LocalDate.of(2020, 10, 1));

        int w = maier.getMatNr();
        w = 8;

        int[] n = maier.getNoten();
        n[0] = 2;

        int[][] x = new int[][]{ { 0, 1, 2} , { 3, 4, 5}};
        int[][] y = new int[][]{ x[0], x[1] };
        
        System.out.println(x==y);
        System.out.println(x.equals(y));
        System.out.println(Arrays.deepEquals(x, y));


        String s1 = new String("abc");
        String s2 = new String("abc");

        String p1 = "abc";
        String p2 = "abc";

        // String q1 = "a";
        // char q2 = 'a';
        // q1 == q2;

    
        

        System.out.println(maier==mueller); // prüfen auf Referenzgleichheit
        System.out.println(maier.equals(mueller));  // prüfen auf Wertegleichheit
    }
}
