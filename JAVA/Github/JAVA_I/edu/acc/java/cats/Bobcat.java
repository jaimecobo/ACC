package edu.acc.java.cats;
import edu.acc.java.Mammal;

/* Models a Bobcat */

public class Bobcat extends Cat {
    
    public Bobcat() {
        System.out.println("in Bobcat constructor");
    }

    public Bobcat(int weight, int age) {
        this(); // invoke default constructor to print a message
        this.setWeight(weight); // initialize instance
        this.setAge(age);
        this.setName("Bobcat");
    }

    public void eat() {
        System.out.println("I eat like a Bobcat"); // correct the message from instructions :)
    } 

    /* do some testing */
    public static void main(String[] args) {
        System.out.println("\ncreate Mammal with default  constructor ---------------");
        //Bobcat m = new Mammal(); // can you cast a Mammal to Bobcat?
        Mammal m = new Mammal();
        m.setAge(1); // set age and weight on all instances
        m.setWeight(2200);
        System.out.println(m); // what's in this Mammal?
        m.eat(); // call eat() and hunt() on all instances
        System.out.println(m.hunt());

        System.out.println("\ncreate Cat with default  constructor ---------------");
        //Bobcat c = new Cat(); // can you cast a Cat to Bobcat?
        //Mammal c = new Cat(); // can you cast a Cat to Mammal?
        Cat c = new Cat(); 
        c.setAge(2); // set age and weight on all instances
        c.setWeight(2200);
        System.out.println(c); // what's in this Cat?
        c.eat(); // call eat() and hunt() on all instances
        System.out.println(c.hunt());

        System.out.println("\ncreate Bobcat with default constructor ---------------");
        Bobcat b = new Bobcat();
        //Mammal b = new Bobcat(); // can a Bobcat be a Mammal?
        b.setAge(3); // set age and weight on all instances
        b.setWeight(2200);
        System.out.println(b);// what's in this Bobcat?
        b.eat(); // call eat() and hunt() on all instances
        System.out.println(b.hunt());

        System.out.println("\ncreate Bobcat with age/weight  constructor and set other attributes for grins ---------------");
        Bobcat b1 = new Bobcat(99, 9);
        //Mammal b1 = new Bobcat(99, 9);
        //b1.setSpots(true); // not part of instructions
        //b1.setFurColor("purple"); // not part of instructions
        //b1.setAverageLitterSize(4); // not part of instructions
        System.out.println(b1);// what's in this Bobcat?
        b1.eat(); // call eat() and hunt() on all instances
        System.out.println(b1.hunt());

        System.out.println("\ncreate Siamese with default constructor ---------------");
        Siamese s = new Siamese(); 
        //Bobcat s = new Siamese(); // can a Siamese be a Bobcat?
        //Mammal s = new Siamese();
        s.setAge(4); // set age and weight on all instances
        s.setWeight(2200); // that's a big cat you got there Mrs. Parrot
        System.out.println(s);// what's in this Siamese?
        s.eat(); // call eat() and hunt() on all instances
        System.out.println(s.hunt());

        System.out.printf("\n%19s %12s %12s %12s %12s", 
                           "instance variable", "Mammal?", "Cat?", "Bobcat?", "Siamese?");
        System.out.printf("\n%19s %12s %12s %12s %12s", "m",
                                 m instanceof Mammal, 
                                 m instanceof Cat,
                                 m instanceof Bobcat,
                                 m instanceof Siamese
                           );
        System.out.printf("\n%19s %12s %12s %12s %12s", "c",
                                 c instanceof Mammal, 
                                 c instanceof Cat,
                                 c instanceof Bobcat,
                                 c instanceof Siamese
                           );
        System.out.printf("\n%19s %12s %12s %12s %12s", "b",
                                 b instanceof Mammal, 
                                 b instanceof Cat,
                                 b instanceof Bobcat,
                                 false               // can't even compile with impossible instanceof
                           );
        System.out.printf("\n%19s %12s %12s %12s %12s", "s",
                                 s instanceof Mammal, 
                                 s instanceof Cat,
                                 false,              // can't even compile with impossible instanceof 
                                 s instanceof Siamese
                           );
    }
        
    public String toString() {
        return "this.name=" + this.getName() +
                           " this.weight=" + this.getWeight() +
                           " this.age=" + this.getAge() +
                           " this.spots=" + this.getSpots() +
                           " this.furColor=" + this.getFurColor() +
                           " this.averageLitterSize=" + this.getAverageLitterSize();
    }
    
}