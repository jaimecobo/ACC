package edu.acc.java;

/* Virtual Lottery Simulator */

public class Lotto implements LottoIntf {

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
    lotto.processOptions(args);  // processes any input options (flags) from command line
    
    // invoke calc_odds() and print odds of winning message
    System.out.println("The odds of winning are 1 in " + lotto.calc_odds());
    
    // instantiate LotteryDrawing and run_simulation()
    //LotteryDrawing drawing = new LotteryDrawing(numLottoBalls,  // don't have LotteryDrawing written yet TODO
    //                                            maxBallNum,
    //                                            simulateYears);
    //drawing.run_simulation();

    // print the results
    lotto.print_results(new int[lotto.numLottoBalls+1]);  // how can we get real results from LotteryDrawing? TODO
    }

    public void print_results(int[] results) {} // due for next class TODO

    public long calc_odds() {  // fill out body from demo code in classroom TODO
        return 1L; 
        }

    private void processOptions(String[] parms) {} //  fill out body from demo code in classroom TODO

}