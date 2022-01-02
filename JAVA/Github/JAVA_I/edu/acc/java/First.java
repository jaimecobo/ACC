package edu.acc.java;  // all of our work will be in this package

public class First {
    public static void main(String[] args) {
        byte myByte = 8;
        short myShort = 501;
        int myInt = 32000;  // this is a integer declaration
        /* block
         *       comment
         */
        long myLong = 70000000;
        float myFloat = 3.14f;
        double myDouble = 3.14159;
        boolean myBool = true;
        char myChar = 'a'; 
        //System.out.println("Hello " + myBool + (myByte + myShort) + " Dude" );
        System.out.println(myShort%2 == 0 && myByte == 8);
    }
}