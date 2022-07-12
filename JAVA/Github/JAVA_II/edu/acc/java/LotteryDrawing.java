package edu.acc.java;
import java.util.Random;
import static java.lang.System.*;

/* Does actual work of running lottery for Lotto class */

public class LotteryDrawing implements LotteryDrawingIntf {

    private int numLottoBalls;
    private int maxBallNum;
    private int simulateYears;
    private int[] results;
    private Random randy;
    private final int NUM_DRAWINGS_PER_YEAR = 104;

    public int[] getResults() { return results; }

    public LotteryDrawing(int nb, int mb, int sy) {
        numLottoBalls = nb;
        maxBallNum = mb;
        simulateYears = sy;
        results = new int[nb+1];
        randy = new Random(); 
    }

    /* main simulation loop */
    @Override
    public void run_simulation() {
        // run 104 drawing/year * number of years by calling pick_numbers()
        // to pick official numbers and user picks then compare for matches
        for (int i=0; i < simulateYears*NUM_DRAWINGS_PER_YEAR; i++) {
            int[] officialPicks = pick_numbers();
            //printPicks(officialPicks);  // for debug only
            int[] userPicks = pick_numbers();
            //printPicks(userPicks);
            // update the results array with number of matcjes
            results[numberOfMatches(officialPicks, userPicks)]++;
        }
    }

    /* debug print info for picks */
    private void printPicks(int[] array) {
        out.println();
        System.out.println();
        for (int next : array) {
            System.out.print(next+" ");
            }
        }

    /* picks a unique set of random numbers for simulation */
    @Override
    public int[] pick_numbers() {
        // using a random number generator fill a new local array of correct
        // size with unique numbers from 1 to maxBallNum
        int[] randomPicks = new int[numLottoBalls];
        for (int i=0; i < randomPicks.length; i++) {
            int randomCandidate;

            do {
                randomCandidate = randy.nextInt(maxBallNum)+1;
               }
            while (!unique(randomCandidate, randomPicks)) ;

            randomPicks[i] = randomCandidate;
        }
        return randomPicks;
    }

    /* returns true if n not in array, else false */
    private boolean unique(int n, int[] array) {
        for (int next : array) {
            if (n == next) return false;
            }
        return true;
        }

    /* compares arrays a and b and returns the number of elements of a in b */
    private int numberOfMatches(int[] a, int[] b) {
       int numMatches = 0;  // keep track of array elements that match
       for (int next_a : a) {
           for (int next_b : b) {
               if (next_a == next_b) numMatches++;
           }
       } 
       return numMatches;
    }
    
    @Override
    public String toString() {
        return "I'm a LotteryDrawing, see me roar";
    }

}