package hr.fer.oop.zad3;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Person implements Comparable<Person> {

    private String oib;
    private String firstName;
    private String lastName;
    private int age;
    private String status;

    public Person(String oib, String firstName, String lastName, int age, String status) {
        this.oib = oib;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
    }

    @Override
    public int hashCode() {
        return this.oib.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return this.oib.equals(other.oib);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" + "oib=" + oib + ", firstName=" + firstName + ", surname=" + lastName + ", age=" + age + ", status=" + status + '}';
    }

    //the commented method compareTo is wrong as it isn't consistent with equals     
//    @Override
//    public int compareTo(Person other) {
//        //lastname
//        int r = hrComparator.compare(this.lastName, other.lastName);
//        if (r != 0) {
//            return r;
//        }
//
//        //firstname
//        return hrComparator.compare(this.firstName, other.firstName);
//    }
    
    private static Comparator<Object> hrComparator = Collator.getInstance(Locale.forLanguageTag("hr"));

    @Override
    public int compareTo(Person other) {
        //lastname
        int r = hrComparator.compare(this.lastName, other.lastName);
        if (r != 0) {
            return r;
        }

        //firstname
        r = hrComparator.compare(this.firstName, other.firstName);
        if (r != 0) {
            return r;
        }

        //should be consistant with equals
        return this.oib.compareTo(other.oib);
    }
}
