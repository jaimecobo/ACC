/*Write a program called Reverse that prints all of its command-line arguments in reverse order, one per line
Example run:
C:/>java Reverse 8 Magic "this is an argument"
*/

public class Reverse {
	public static void main(String[] args){
		String theArg = args[0];
		for (int i = theArg.length() - 1; i >= 0; i--){
			char charac = theArg.charAt(i);
			System.out.print(charac);
		}
	}
}