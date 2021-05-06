import java.util.concurrent.atomic.AtomicInteger;

public class Immutable {

    static void changeIntegerValue(Integer z) {
        System.out.println("z=" + z);
        z = z +1;
        System.out.println("z=" + z);
    }

    static void changeStringValue(String s) {
        System.out.println(s);
        s = new String("B");
        System.out.println(s);
    }

    public static void main(String[] args) {
       Integer x = 7;
       System.out.println(x);
       changeIntegerValue(x);
       System.out.println(x);
       
       String y = new String("A");
       System.out.println(y);
       changeStringValue(y);
       System.out.println(y);
       
       AtomicInteger a = new AtomicInteger();
       a.set(7); 
       a.incrementAndGet();
       System.out.println(a.get());
    
       StringBuffer sb = new StringBuffer();
       sb.append("as");
       sb.append("a");
       System.out.println(sb.toString());
    }
}
