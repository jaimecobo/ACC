/*
Write a Java program called Craps that simulates one complete game of Craps per run.

In Craps, the player rolls two six-sided dice. When the first roll sums to 7 or 11,
the player wins. When the first roll sums to 2, 3 or 12, the player loses. Any other
roll becomes the players "point". A player with point rolls until one of two things
happens: a roll of 7 loses and rolling the point again wins. Any other roll for point is
ignored.

Example runs:
C:/> java Craps
You rolled 2 + 3 = 5
Your point is 5
You rolled 1 + 2 = 3
Your point is 5
You rolled 4 + 1 = 5
YOU WIN!

C:/> java Craps
You rolled 1 + 2 = 3
YOU LOSE!

C:/> java Craps
You rolled 2 + 5 = 7
YOU WIN!

C:/> java Craps
You rolled 4 + 4 = 8
Your point is 8
You rolled 6 + 6 = 12
Your point is 8
You rolled 1 + 6 = 7
YOU LOSE!

 */
//package edu.acc.java.intro;
import java.util.Scanner;
public class Craps {
    public static int rollDice() {
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        int sum = dice1 + dice2;
        System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
        return sum;
    }
    public static void main(String[] args) {
        int sum = rollDice();
        if (sum == 7 || sum == 11) {
            System.out.println("YOU WIN!");
            return;
        }
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("YOU LOSE!");
            return;
        }
        if (sum != 7 && sum != 11 && sum != 2 && sum != 3 && sum != 12) {
            int point = sum;
            System.out.println("YOUR POINT IS " + point);
            int sum2 = 0;
            while (sum2 != point) {
                Scanner keyIn = new Scanner(System.in);
                System.out.print("Press enter to continue");
                keyIn.nextLine();
                sum2 = rollDice();
                if (sum2 == 7) {
                    System.out.println("YOU LOSE");
                    return;
                }
                System.out.println("You rolled " + "dice1" + " + " + "dice2" + " = " + sum2);
            }
            System.out.println("YOU WIN");
        }
    }
}