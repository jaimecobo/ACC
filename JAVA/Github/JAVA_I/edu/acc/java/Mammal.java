package edu.acc.java;

/* Models a Mammal */

public class Mammal {
    public int age; 
    public int weight; 
    public String name; 

    public Mammal() {
        System.out.println("in Mammal constructor");
    }

    public void eat() {
        System.out.println("I'm a mammal");
    }

    public String hunt() {
        return "I hunt mammal morsels";
    }

    /* toString method knows how to print attributes of this object */
    public String toString() {
        // all mammals have name, age and weight
        return  "this.name=" + this.name +
                           " this.weight=" + this.weight +
                           " this.age=" + this.age;
    }

}