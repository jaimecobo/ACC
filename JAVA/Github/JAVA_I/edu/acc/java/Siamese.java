package edu.acc.java;

/* Models a Siamese cat */

public class Siamese extends Cat {
    
    public Siamese() {
        System.out.println("in Siamese constructor");
        this.name = "Siamese";
    }

    public void eat() {
        System.out.println("I am a Siamese if you please");
    }

    public String hunt() {
        return "I hunt for someone to feed me";
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