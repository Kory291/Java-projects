package oo;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;

// Klasse = "Bauplan" für die konkreten Objekt-Instanzen (Objekte, Instanzen, Entitäten, ...)
class Modul {
    int modulNr;
    String titel;
    int SWS;
}

class Student {
    final int matNr;  // Instanz-Attribut 
    String name;
    LocalDate immaDatum;
    HashSet<Modul> belegteModule;   // HashSet = Menge
    int[] noten;
    
    // Klassenattribute: Wert für alle Instanzen gleich; Schlüsselwort static 
    static double semesterBeitrag = 237.6f;
    static int anzahl = 0;
    final static int ANZAHL_MONATE_PRO_SEMESTER = 6;


    int getMatNr() {
        return this.matNr;
    }

    int[] getNoten() {
        return this.noten;
    }

    @Override
    public boolean equals(Object obj) {
        Student andererStudent = (Student) obj;
        boolean matrNrgleich = this.matNr == andererStudent.matNr;
        // boolean nameGleich = this.name == andererStudent.name;
        boolean immaGleich = this.immaDatum.equals(andererStudent.immaDatum);
        return matrNrgleich  && immaGleich;
    }

    // Komstruktor
    Student (int matNr /*Parameter*/, String name, LocalDate d) {
        this.matNr = matNr; // this. = aktuelle Instanz
        this.name = name;
        this.immaDatum = d;
        this.belegteModule = new HashSet<Modul>();
        this.noten = new int[5];
        Student.anzahl++;
    }

    // 2. Konstruktor
    Student (int matNr, String name) {
        this(matNr, name, LocalDate.now());
    }

    // Copy-Konstruktor
    Student (Student andererStudent) {
        this (andererStudent.matNr, andererStudent.name, andererStudent.immaDatum);
    }

    // Instanz-Methode
    boolean einschreiben (Modul m) {
        return this.belegteModule.add(m);
    }

    int getSemester() {
        return this.getSemester(LocalDate.now());   // Aufruf von Instanzmethode
    }

    // Methode getSemester überladen, d.h. gleichnamige Methode mit anderer Signatur
    int getSemester(LocalDate d) {
        Period p = Period.between(this.immaDatum.plusDays(-1), d);
        int months = 12*p.getYears() + p.getMonths();   // Aufruf von Instanz-Methoden der Klasse Period
        return (months/ANZAHL_MONATE_PRO_SEMESTER)+1;
    }

    static int getAnzahl() {
        return Student.anzahl;
    }

}
// -> Kapitel Funktionale Programmierung
public class Hochschule {

    // varargs : den letzten Parameter mit .. 
    public static void main(String[] args) {
        
        Modul m = new Modul();  // Instanziierung, durch Aufruf des (Default-) Konstruktors
        // jedes Attribut von m hat Default-Wert
        
        m.modulNr = 1;  // Variable-Punkt-AttributName = Zugriff auf das Instanz-Attribut
        m.titel = "DBS";
        m.SWS = 4;
        Student maier = new Student(21, "Maier", LocalDate.of(2020, 10, 1));
        Student thor = new Student(34, "Thor");

        System.out.println(maier.matNr);
        maier.matNr = 87;

        System.out.println(Student.ANZAHL_MONATE_PRO_SEMESTER);
        
        Student.semesterBeitrag = 99;
        System.out.println(Student.getAnzahl());
        System.out.println(maier.einschreiben(m));
        System.out.println(maier.getSemester());

        System.out.println(maier.getSemester(LocalDate.of(2022, 12, 12)));

/*
        Modul m2 = new Modul();
        m2.modulNr = 2;

        Student thor = new Student(34, "Thor");

        Student georg = new Student (thor);

        System.out.println(m.titel);
        System.out.println(thor.name);
    */
    }
}