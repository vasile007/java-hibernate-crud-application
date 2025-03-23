package entities;

import java.util.List;

public class Person {
    private int id;
    private String lastName;
    private int age;
    private String address;
    private double salary;


    public Person() {

    }


    public Person(String lastName, int age, String address, double salary) {
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}


