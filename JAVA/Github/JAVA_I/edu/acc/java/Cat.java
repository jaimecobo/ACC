package edu.acc.java;

/* Models a Cat */

public class Cat extends Mammal {

    public boolean spots;
    public String furColor;
    public int averageLitterSize;

    public Cat() {
        System.out.println("in Cat constructor");
    }

    public String hunt() {
        return "I hunt Cat food";
    }

    public String toString() {
        return "this.name=" + this.name +
                           " this.weight=" + this.weight +
                           " this.age=" + this.age +
                           " this.spots=" + this.spots +
                           " this.furColor=" + this.furColor +
                           " this.averageLitterSize=" + this.averageLitterSize;
    }


}