package edu.acc.java;

public interface DeckIntf {
   
    default public PlayingCard[] deal(int numCards) {
        System.out.println("Goober was here");
        return new PlayingCard[7];
    } 

    public void shuffle();

}