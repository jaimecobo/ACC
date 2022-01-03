package edu.acc.java;

/*
 * Part of demo code during class 5/25/17 
 */
class Employee {
    
    int salary; // instance variable for employee salary
    String name; // instance variable for employee name

    // Constructor for Employee
    public Employee(int salary, String name) {
        System.out.println("created an Employee");
        this.salary = salary;  // save data in this instance
        this.name = name;
    }

}