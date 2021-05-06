class Stack {
    private String objects[];
    private int current;

    Stack (int max) {
        objects = new String[max];
        current = 0;
    }

    int size() {
        return current;
    }

    String push(String s) {
        if(current < objects.length) {
            
            objects[current] = s;
            current++;
            return s;
        }
        return null;
    }

   String pop() {
        if(current > 0) {
            current--;
            return objects[current];
        }
       return null;
    }
}

public class Stack_Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack(3);
        System.out.println(stack1.push("Hello"));
        System.out.println(stack1.push("Hello2"));
        System.out.println(stack1.push("Hello3"));
        System.out.println(stack1.pop());
        System.out.println(stack1.push("World"));
        System.out.println(stack1.pop());
        System.out.println(stack1.push("Test"));
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }
}