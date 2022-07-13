package edu.acc.java;

/* All Lotto objects must implement these */

public interface LottoIntf {
   long calc_odds();  // calculates the odds of winning for given parameters
   void print_results(int[] results);   // prints results table
}