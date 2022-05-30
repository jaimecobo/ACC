// Code from Day 1 class with changes 
// We will study the code until it makes sense to all

public class A {

    // this is a line comment
    public static void main(String args) {
        String x = "8";
        int y = 8;
   
        /* This is a block comment
           that
           runs over 3 lines */

        System.out.println(

            // "Dude!\n   The secret i" + // OLD
            "Dude!\n   The secret " + x + // NEW

            //"s never using and " + args + " before it's time" // OLD
            "s never using a " + args + " before it's time" // NEW

            );
        // return "something"; // commented out
        }        

    public static void main(String[] args) {
        main("chicken sandwish");
    }
}