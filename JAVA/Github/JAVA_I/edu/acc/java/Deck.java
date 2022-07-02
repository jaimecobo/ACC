package edu.acc.java;
import java.util.Random;

/* Models a deck of 52 playing cards */

public class Deck {
   
    PlayingCard[] deck = new PlayingCard[52]; // standard card deck
    
    public Deck() {
        int i = 0;
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                deck[i] = new PlayingCard(suit, rank);  // create new card and save in deck
                i++;
            }
        }
    }

    /* deals a new hand of given number of cards */
    public PlayingCard[] deal(int numCards) {
       PlayingCard[] newHand = new PlayingCard[numCards];  // create new hand to return
       for (int i=0; i < numCards; i++) {
           // take the first numCards cards in deck
           newHand[i] = deck[i];
       } 
       return newHand;
    }

    /* shuffles the deck */
    public void shuffle() {
        Random randy = new Random(); // create a random number generator
        for (int i=0; i < 10000; i++) {
            // swap two random cards
            int index1 = randy.nextInt(deck.length); // limit randoms to length of deck
            int index2 = randy.nextInt(deck.length); 
            PlayingCard temp = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = temp;
        }
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.shuffle();
        PlayingCard[] myFiveCardPokerHand = myDeck.deal(5);
        for (PlayingCard card : myFiveCardPokerHand) {
            System.out.println(card);
        }
    }
}