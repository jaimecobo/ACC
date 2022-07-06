package edu.acc.java;
import java.util.Random;

/* Models a deck of 52 playing cards */

public class DeckSon extends Deck01 {
   
    /* deals a new hand of given number of cards */

    public PlayingCard[] deal(int numCards) {
       PlayingCard[] newHand = new PlayingCard[numCards];  // create new hand to return
       for (int i=0; i < numCards; i++) {
           // take the first numCards cards in deck
           newHand[i] = deck[i];
       } 
       return newHand;
    }


    public static void main(String[] args) {
        DeckSon myDeck = new DeckSon();
        myDeck.shuffle();
        PlayingCard[] myFiveCardPokerHand = myDeck.deal(5);
        for (PlayingCard card : myFiveCardPokerHand) {
            System.out.println(card);
        }
        myDeck.hi();
    }
}