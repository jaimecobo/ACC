/* Write a Java program called GuessingGame that picks a random number between 1 and 100 and prompts the user to guess the number.
When the user's guess is too low, prompt them to guess higher. When it's to high, prompt them to guess lower. Track how many guesses 
it takes the user to guess the number.
Example run:
C:/> java GuessingGame
I've picked a number between a and 100.
	Guess my number : 48
	Guess higher : 71
	Guess lower : 53
	You guessed my number in 3 tries!
	
*/
import java.util.*;

public class GuessingGame {
	
		
	
	public static int getRandomNumber(){
		Random rand = new Random();
		int number = rand.nextInt(100) + 1;
		return number;
  
	}
	
	
	public static int readFromConsole(){
		Scanner myObj = new Scanner(System.in);
		String input = myObj.nextLine();
		int inputNum = Integer.parseInt(input);
		return inputNum;
		
	}

	public static void tryIt(int theNumber, int tries){
			int input = readFromConsole();
			if(input == theNumber){
				tries++;
				if(tries != 1)
					System.out.println("You guessed my number in " + tries + " tries");
				else
					System.out.println("You guessed my number in " + tries + " try");
			}
			if(input > theNumber){
				tries++;
				System.out.println("The number is lower than: " + input + ", try it one more time");	
				tryIt(theNumber, tries);
			}
			if(input < theNumber){
				tries++;
				System.out.println("The number is higher than: " + input + ", try it one more time");	
				tryIt(theNumber, tries);
			}
		}
		
	public static void main (String [] args){
		System.out.println("I've picked a number between 1 and 100, try to guess it \nEnter a number:");
		int theNumber = getRandomNumber();
		tryIt(theNumber, 0);
		
		
		
		
	}
}

//javap java.lang.String