package com.example.jspdemo02mvc2.entity;

public class Employee {
    private int id;
    private String fullName;
    private String address;
    private String birthday;
    private String Position;
    private String Department;

    public Employee() {}

    public Employee(String fullName, String address, String birthday, String Position, String Department) {
        super();
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.Position = Position;
        this.Department = Department;
    }

    public Employee(int id, String fullName, String address, String birthday, String Position, String Department) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.Position = Position;
        this.Department = Department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}