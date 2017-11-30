package com.wongel.test;

/**
 * Created by tseringwongelgurung on 11/23/17.
 */

public class Student {
    private int id;
    private String name;
    private int roll;
    private String address;

    public Student(String name, int roll, String address) {
        this.name = name;
        this.roll = roll;
        this.address = address;
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
