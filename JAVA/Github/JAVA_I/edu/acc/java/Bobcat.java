package edu.acc.java;

/* Models a Bobcat */

public class Bobcat extends Cat {
    
    public Bobcat() {
        System.out.println("in Bobcat constructor");
    }

    public Bobcat(int weight, int age) {
        this(); // invoke default constructor to print a message
        this.weight = weight; // initialize instance
        this.age = age;
        this.name = "Bobcat";
    }

    public void eat() {
        System.out.println("I eat like a Bobcat"); // correct the message from instructions :)
    } 

    /* do some testing */
    public static void main(String[] args) {
        System.out.println("\ncreate Mammal with default  constructor ---------------");
        Mammal m = new Mammal();
        m.age = 1; // set age and weight on all instances
        m.weight = 2200;
        System.out.println(m); // what's in this Mammal?
        m.eat(); // call eat() and hunt() on all instances
        System.out.println(m.hunt());

        System.out.println("\ncreate Cat with default  constructor ---------------");
        Cat c = new Cat();
        c.age = 2; // set age and weight on all instances
        c.weight = 2200;
        System.out.println(c); // what's in this Cat?
        c.eat(); // call eat() and hunt() on all instances
        System.out.println(c.hunt());

        System.out.println("\ncreate Bobcat with default constructor ---------------");
        Bobcat b = new Bobcat();
        b.age = 3; // set age and weight on all instances
        b.weight = 2200;
        System.out.println(b);// what's in this Bobcat?
        b.eat(); // call eat() and hunt() on all instances
        System.out.println(b.hunt());

        System.out.println("\ncreate Bobcat with age/weight  constructor and set other attributes for grins ---------------");
        Bobcat b1 = new Bobcat(99, 9);
        b1.spots = true; // not part of instructions
        b1.furColor = "purple"; // not part of instructions
        b1.averageLitterSize = 4; // not part of instructions
        System.out.println(b1);// what's in this Bobcat?
        b1.eat(); // call eat() and hunt() on all instances
        System.out.println(b1.hunt());

        System.out.println("\ncreate Siamese with default constructor ---------------");
        Siamese s = new Siamese();
        s.age = 4; // set age and weight on all instances
        s.weight = 2200; // that's a big cat you got there Mrs. Parrot
        System.out.println(s);// what's in this Siamese?
        s.eat(); // call eat() and hunt() on all instances
        System.out.println(s.hunt());
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