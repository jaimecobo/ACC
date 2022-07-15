package edu.acc.java;

/* Virtual Lottery Simulator 
 *
 * Use command line args (the args coming into main()) to obtain inputs for a virtual lottery:
 *    A flag -b followed by an integer number of lotto balls to use (default is 6)
 *    A flag -p followed by the maximum ball number i.e. from 1 to the max (default is 54)
 *    A flag -y followed by the number of years to simulate (default is 1)
 *
 * Define a new class called Lotto and a private method called calc_odds() that returns the odds of winning. Use the following algorithm to exercise your array skills:
 *    Create an array using the -p value as a length and fill the array with the ball numbers e.g. 1 - 54
 *    Multiply the last -b elements in the array together e.g. for 54 balls max and 6 balls in use: 54*53*52*51*50*49
 *
 * A second method in Lotto is called print_results() which reads the results[] array from LotteryDrawing, and prints a report of results as seen below. Each row should have the match count (0, 1, 2, ...) followed by the results for that match count, and percentage of the total for that match count (see picture at end).
 *
 * Define a new class called LotteryDrawing with the following instance methods:
 *    public void run_simulation()
 *        runs drawings at 104 per year (-y parameter gives number of years)
 *        obtains an int[] from pick_numbers() to be the winning lottery numbers for each drawing. Array length is -b
 *        obtains a second int[] from pick_numbers() to be the users quick picks
 *        compares the two int[] arrays counting matches: 0 (no matches) up to 6 (all matched)
 *        keeps track of the number of matches in a private LotteryDrawing array called results[]. Array length should cover all the match possibilites. Results[] should be available using a getter
 *
 *    public int[] pick_numbers() will:
 *        obtain and initialize a java.util.Random generator variable
 *        fill a local int[] with random numbers from 1 to the number of balls (-b parameter)
 *        verify unique numbers in the int[] (no duplicates)
 *
 *    Run a simulation by instantiating LotteryDrawing in Lotto and calling its run_simulation() method, then print_results() to get the report.
 *
 * (Stretch goal): Keep track of the simulation time and print that too. Hint: see the System class.
 */

public class Lotto01 implements LottoIntf {

    private int numLottoBalls;  // -b
    private int maxBallNum;     // -p
    private int simulateYears;  // -y

    public Lotto() {
        // sets the required defaults
        numLottoBalls = 6;
        maxBallNum = 54;
        simulateYears = 1;
    }

    public static void main(String[] args) {
    // process input parms
    Lotto lotto = new Lotto();  // get access to instance methods and variables
    lotto.processOptions(args, lotto);  // processes any input options (flags) from command line
    
    // invoke calc_odds() and print odds of winning message
    System.out.printf("The odds of winning are 1 in %,d", lotto.calc_odds());
    
    // instantiate LotteryDrawing and invoke run_simulation()
    LotteryDrawing drawing = new LotteryDrawing(lotto.numLottoBalls,
                                                lotto.maxBallNum,
                                                lotto.simulateYears);
    drawing.run_simulation();

    // print the results
    lotto.print_results(drawing.getResults());  
    }


    /**
     * See interface for doc 
     */
    @Override
    public void print_results(int[] results) {
        System.out.println("\n--Lottery Drawing Report--");
        int i = 0;  // match counter
        System.out.println("Matches   Count  Percent");

        for (int next_result : results) {  // print one line per result
            System.out.printf("%7s %7s %7.1f%%\n", i++, next_result,
                              (next_result/(simulateYears*104.))*100.);
            }
        }

    /**
     * See interface for doc 
     */
    @Override
    public long calc_odds() {  // made public to include in LottoIntf
        long the_odds = 1L;  // set to 1 initially because we're multiplying
        int[] temp = new int[maxBallNum];
        for (int i = 0; i < temp.length; i++) temp[i] = i+1;
        for (int i=1; i <= numLottoBalls; i++ ) {
            the_odds *= temp[maxBallNum - i];
        }

        return the_odds;
    }

    /**
     * Basic flags processor with bounds checking
     * Note: does not handle malformed input (how do we fix that?)
     * @param args is the command line args array
     * @param lotto is a Lotto instance
     *
     * Flags:
     * -b <integer number of lotto balls> (default 6)
     * -p <integer max ball number> (default 54)
     * -y <integer number of years to simulate> (default 1)
     */
    public static void processOptions(String[] parms, Lotto lotto) {
        for (int i=0; i < parms.length;) {
                switch (parms[i].trim()) {
                case "-b": lotto.numLottoBalls = Integer.parseInt(parms[++i]);
                           if (lotto.numLottoBalls > 13) die("max value for -b is 13");
                           if (lotto.numLottoBalls < 1) die("minimum value for-b is 1");
                           break;
                case "-p": lotto.maxBallNum = Integer.parseInt(parms[++i]);
                           if (lotto.maxBallNum <= lotto.numLottoBalls) die("-p must be greater than -b");
                           break;
                case "-y": lotto.simulateYears = Integer.parseInt(parms[++i]);
                           if (lotto.simulateYears <= 0) die("-y must be greater than 0");
                           if (lotto.simulateYears > 100000) die("-y must be less than 100,000");
                           break;
                default:   System.out.println("Invalid option detected...ignoring");
                }

                i ++;  // bump to next possible flag
        }
    }

    /**
     * Convenience method to print message and exit
     */
    private static void die(String msg) {
        System.out.println(msg);
        System.exit(127);
    }
}