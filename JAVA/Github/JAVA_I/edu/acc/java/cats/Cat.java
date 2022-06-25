package edu.acc.java.cats;
import edu.acc.java.Mammal;

/* Models a Cat */

public class Cat extends Mammal {

    private boolean spots;
    private String furColor;
    private int averageLitterSize;

    public Cat() {
        System.out.println("in Cat constructor");
    }

    public String hunt() {
        return "I hunt Cat food";
    }

    public boolean getSpots() { return this.spots; }
    public void setSpots(boolean spots) { this.spots = spots; }
    public String getFurColor() { return this.furColor; }
    public void setFurColor(String furColor) { this.furColor = furColor; }
    public int getAverageLitterSize() { return this.averageLitterSize; }
    public void setAverageLitterSize(int averageLitterSize) { this.averageLitterSize = averageLitterSize; }

    public String toString() {
        return "this.name=" + this.getName() +
                           " this.weight=" + this.getWeight() +
                           " this.age=" + this.getAge() +
                           " this.spots=" + this.spots +
                           " this.furColor=" + this.furColor +
                           " this.averageLitterSize=" + this.averageLitterSize;
    }


}