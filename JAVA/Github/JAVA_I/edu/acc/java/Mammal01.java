package edu.acc.java;

/* Models a Mammal */

public class Mammal01 {
    private int age; 
    private int weight; 
    private String name; 

    public Mammal() {
        System.out.println("in Mammal constructor");
    }

    public void eat() {
        System.out.println("I'm a mammal");
    }

    public String hunt() {
        return "I hunt mammal morsels";
    }

    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age;; }
    public int getWeight() { return this.weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    /* toString method knows how to print attributes of this object */
    public String toString() {
        // all mammals have name, age and weight
        return  "this.name=" + this.name +
                           " this.weight=" + this.weight +
                           " this.age=" + this.age;
    }

}