/*
	Write a program called Addit that sums two numbers entered by the user and display that sum in the console!
	Example run:
	C:\> java Addit 27.1 5.18
	
	*/
/*
public class Addit {
	public static void main (String [] args){
		double num1 = Double.parseDouble(args[0]);
		double num2 = Double.parseDouble(args[1]);
		double sum = num1 + num2;
		System.out.println("The sum is " + sum);
	}
	
	
	
	/* Another example of the same program that prevent the program run if it doesn't has the correct arguments */
	
public class Addit {
	public static void main (String [] args){
		if (args.length != 2){
			System.out.println ("Usage: java Addit <number> <number>");
			return;
		}
		double num1 = Double.parseDouble(args[0]);
		double num2 = Double.parseDouble(args[1]);
		double sum = num1 + num2;
		System.out.println("The sum is " + sum);

	}
}