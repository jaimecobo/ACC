/*Write a program called Addit2 that sums all its command-line arguments and prints the grant total. */

public class Addit2 {
	public static void main(String[] args){
	double grandTotal = 0.0;
	for (int i = 0; i < args.length; i++){
		double theArg = Double.parseDouble(args[i]);
		grandTotal = grandTotal + theArg;
	}
	System.out.println("The grand total is: " + grandTotal);
	
	for (String arg : args) {
			double theArg = Double.parseDouble(arg);
			grandTotal += theArg;
		}
	}
}