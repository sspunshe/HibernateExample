package com.hibernate.example.HibernateExample.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee() {}
    public Employee(String fname, String lname, int salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }
}
