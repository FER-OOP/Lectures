package hr.fer.oop.task1;

public class Driver {

    private String firstName;
    private String surname;
    private String address;
    private long pid;

    public Driver(String firstName, String surname, String address, long pid) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public long getPid() {
        return pid;
    }

    //metodu toString smo izgenerirali iz razvojne okoline NetBeans (Source -> Insert Code... -> toString()...)
    @Override
    public String toString() {
        return "Driver{" + "first name=" + firstName + ", surname=" + surname + ", address=" + address + ", pid=" + pid + '}';
    }
}
