/*
	Write a Java program called Pattern that displays the
	same pattern as Stars2 but allows the user to select a
	different character than asterisk for the pattern. Any
	one-character symbol should be allowed.
*/
public class Pattern {
	public static void main(String[] args){
		if (args.length != 1 ){
			System.out.println("Usage: Please type one character as an argument to be printed, for characters like &, *, |, or ^, you must type them in between double quotes.");
			return;
		}
		char pattern = args[0].charAt(0);
		for (int line = 1; line <= 10; line++) {
			for (int i = 10; i >= line; i--) {
				System.out.print(pattern);
			}
			System.out.println();
		}
	}
}
