package edu.acc.java.cats;

/* Models a Siamese cat */

public class Siamese extends Cat {
    
    public Siamese() {
        System.out.println("in Siamese constructor");
        this.setName("Siamese");
    }

    public void eat() {
        System.out.println("I am a Siamese if you please");
    }

    public String hunt() {
        return "I hunt for someone to feed me";
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