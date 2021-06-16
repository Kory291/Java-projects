public class App {
    public static void main(String[] args) {
        number n1 = new number(2);
        number n2 = n1;
        System.out.println("--");
        n1.zahl = 5;
        System.out.println("--");
    }
}

class number {
    int zahl;
    number(int zahl) {
        this.zahl = zahl;
    }
}
