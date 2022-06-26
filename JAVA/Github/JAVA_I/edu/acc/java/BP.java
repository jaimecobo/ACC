/* Verifies Birthday Paradox assertion that in a room of 23 random 
 * people there is a 50% chance two of them have the same birthday
 */

package edu.acc.java;
import java.util.Random;

public class BP {
    int[] room = new int[23];
    Random randy = new Random();
    final int SAMPLES = 100000;
    
    public static void main(String... args) {
        BP bp = new BP();  // so we can access instance variables
        int duplCounter = 0;  // track dupl birthdays

        for (int samples = 0; samples < bp.SAMPLES; samples++) {
            // fill the room with 23 peeps
            for (int i=0; i < bp.room.length; i++) {
                bp.room[i] = bp.randy.nextInt(366);
            }
    
            if (bp.duplIntegers(bp.room)) {  // see if room has 2 with same b'day
               duplCounter++; 
                }
        }
        System.out.println("Probability = " + 
            duplCounter/(bp.SAMPLES*1.0));
    }

    /* return true if any integer elements are equal */
    public boolean duplIntegers(int[] array) {
        for (int i=0; i < array.length; i++) {
            for (int j=i+1; j < array.length; j++) {
                if (array[i] == array[j]) return true;
            }
        }
    return false;
    }
}