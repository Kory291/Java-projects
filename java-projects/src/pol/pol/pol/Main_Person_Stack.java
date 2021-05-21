package pol;

class Person_Stack {
    private Person objects[];
    private int current;        //aktuelle Anzahl der Objekte im Stack == Position des nächsten Elements

    Person_Stack (int max) {
        objects = new Person[max];
        current = 0;
    }

    int size() {
        return current;
    }

    Person push(Person p) {
        return (current < objects.length) ? objects[current++] = p : null;
        /*
        if(current < objects.length) {
            return objects[current++] = p;
        }
        return null;
        */
    }

    Person pop() {
        Person p = (current > 0) ? objects[--current] : null;
        if(p != null) {
            System.out.println("Pop: " + p.getVorname());
        }
        return p;
    }

    @Override
    public String toString() {
        return String.format("Ich bin %s %s. Meine MatrNr ist %d.")
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

    static String getType() {
        return "Person";
    }

}

class Student extends Person {
    int matNr;

    Student(String vorname, String nachname, int matNr) {
        super(vorname, nachname);
        this.matNr = matNr;
    } 

    @Override
    String getVorname() {
        return "Student_" + super.getVorname();
    }
    
    static String getType() {
        return "Student";
    }

    int getMatNr() {
        return matNr;
    }
}

public class Main_Person_Stack {
    public static void main(String[] args) {
        /*Person p = new Person("Ada", "Lovelace");
        Student s = new Student("Grace", "Hopper", 1234);
        Object o = new Object();
        Person[] a = {new Person("Claude", "Shannon"), new Person("Konrad", "Zuse")};
        */

        Person x = new Student("Grace", "Hopper", 123);
        System.out.println(x.getType());
        System.out.println(x);
        System.out.println(x.getVorname());
        System.out.println(x.toString());

        x = new Person("Ada", "Lovelace");
        if(x instanceof Student) {
            System.out.println("Ich bin Student");
            System.out.println(((Student) x).getMatNr());
        }
        //System.out.println(x.getMatNr()); geht nicht, weil Variablentyp Person festlegt, welche Attribute und Methoden verfügbar sind
        
        //System.out.println(((Student) x).getMatNr());
        System.out.println(((Object)x).toString());

        /*
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
        */
    }
}