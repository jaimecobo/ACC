/*
 * First try algorithm for Birthday Paradox
 * 
 */

package edu.acc.java;

public class BirthdayParadox {
    int[] loopCounts = new int[1000];  // keep track of a thousand samples
    java.util.Random randy = new java.util.Random();  // source of randoms

    public static void main(String[] args) {
    BirthdayParadox mb = new BirthdayParadox();  // so we can refer to instance variables
    final int DAYSINAYEAR = 366;  // good to put constants in final variables
    // loop for 1000 samples
    for (int i=0; i < mb.loopCounts.length; i++) {
        // loop picking birthdays until dup found; keep track of loop count
        // pick a random birthday to compare to
        int compareToBirthday = mb.randy.nextInt(DAYSINAYEAR);  // constrain to 366 days of year
        int loops = 1; // track number of times it takes to find this birthday 

        while (compareToBirthday != mb.randy.nextInt(DAYSINAYEAR)) {
           loops++;
        } 

        //   when dup found, save count in array element
        mb.loopCounts[i] = loops;  
    }
    // print average of loop counts from array (use enhanced for)
    int sum = 0;

    for (int element : mb.loopCounts) {
        System.out.println(element);
        sum += element;
        }

    System.out.println("Ave. loop count is " + sum/1000.);
    } 
}