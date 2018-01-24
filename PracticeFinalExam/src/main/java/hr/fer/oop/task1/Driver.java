package hr.fer.oop.task1;

public class Driver {

    private String firstName;
    private String surName;
    private String address;
    private long pid;

    public Driver(String firstName, String surName, String address, long pid) {
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
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
        return "Driver{" + "firstName=" + firstName + ", surName=" + surName + ", address=" + address + ", pid=" + pid + '}';
    }
}
