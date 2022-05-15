/*
	Write a Java program that displays the longest string
	provided as a command-line argument and also
	displays the character count of that string.
	Example:
	c:/> java Longest Hello Goodbye "This rocks"
	This rocks
	10
*/
import java.util.Arrays;

public class Longest {
	public static void main(String[] args){
		if (args.length < 1)
			System.out.println ("ERROR : You have to declare at least one argument!");
		else {
			int y = 0;
			int z = 0;
			int t = args.length;
			String p = " ";
		for (String arg : args){
			int x = arg.length();
			if (x > z){
				z = x;
				p = arg;
				y = Arrays.asList(args).indexOf(p);
			}
		}
			System.out.println("\nYou declared " + t + " string arguments.");
			System.out.println("\nThe longest string is: " + p);
			System.out.println("\nIt has " + z + " characters.");
			System.out.println("\nIt is the argument located at index: " + y + ", that is the same as saying argument number: " + (++y));
		}
		}
}