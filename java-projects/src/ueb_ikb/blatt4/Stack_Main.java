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
        //if(current < (objects.length - 1)) {
           // current++;
            objects[current + 1] = s;
            return objects[current];
        }
        //else return null;
    //}

   String pop() {
        String save = objects[current];
        objects[current] = null;
        if(current > 1)current--;
        return save;
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