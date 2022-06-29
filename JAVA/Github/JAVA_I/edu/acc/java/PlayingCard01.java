package edu.acc.java;

/*
 * Models one playing card 
 */

public class PlayingCard01 {
    
    Suits suit;
    Ranks rank;

    public PlayingCard01() {
        // suit and rank not given so arbitrarily assign them (better: use Random)
        this.suit = Suits.SPADES;
        this.rank = Ranks.ACE;
    }

    public PlayingCard01(Suits suit, Ranks rank) {
        // suit and rank are given so use them
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        // what do we want the world to see when a PlayingCard inistance is stringified?
        return rank + " of " + suit;
    }
}