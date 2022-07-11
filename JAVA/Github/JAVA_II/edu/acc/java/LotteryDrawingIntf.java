package edu.acc.java;

/* all LotteryDrawing objects must implement these methods */

public interface LotteryDrawingIntf {
    void run_simulation();  // run the simulation using given parameters
    int[] pick_numbers();  // returns an array of random integers to simulate number choices
}