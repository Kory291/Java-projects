

public class Immutable {

    static void changeIntegerValue(Integer z) {
        System.out.println("z=" + z);
        z = z + 1;
        System.out.println("z=" + z);
    }

    public static void main(String[] args) {
       Integer x = 7;
       System.out.println(x);
       changeIntegerValue(x);
       System.out.println(x);
       
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
