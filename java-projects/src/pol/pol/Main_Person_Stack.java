package pol;

class Person_Stack {
    private Person objects[];
    private int current;

    Person_Stack (int max) {
        objects = new Person[max];
        current = 0;
    }

    int size() {
        return current;
    }

    Person push(Person p) {
        if(objects[current] == null ) {
            objects[current] = p;
            if(current < (objects.length - 1)) current++;
            return p;
        }
        return null;
    }

    Person pop() {
        if(objects[current] != null) {
            Person save = objects[current];
            objects[current] = null;
            if(current > 0)current--;
            return save;
        }
        return null;
    }
}

class Person {
    private String vorname;
    private String nachname;

    Person (String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    String getVorname() {
        return this.vorname;
    }

    String getNachname() {
        return this.nachname;
    }

}

public class Main_Person_Stack {
    public static void main(String[] args) {
        Person_Stack stack1 = new Person_Stack(5);
        stack1.push(new Person("Lukas", "Schäfer"));
        stack1.push(new Person("Hans", "Wilhelm"));
        System.out.println(stack1.size());
        stack1.push(new Person("Fritz", "Schmidt"));
        stack1.push(new Person("Helmut", "Marko"));
        System.out.println(stack1.size());
        stack1.push(new Person("Paul", "Horner"));
        System.out.println(stack1.size());
        stack1.push(new Person("Paul", "Horner2"));
        System.out.println(stack1.size());
        stack1.pop();
        stack1.pop();
        System.out.println("--");
        System.out.println("test");
    }
}