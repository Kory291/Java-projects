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

    //Person push (Person p) {}

    //Person pop () {}
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

class Main {

}

public class Person_Stack {
    
}
