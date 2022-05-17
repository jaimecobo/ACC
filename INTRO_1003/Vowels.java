/* 
	Write a Java program called Vowels that displays the total count of vowels (AEIOUaeiou) in the user's inputfrom the command-line.
	Example:
	C:/> java vowels "She sells seashells by the seashore"
	10 vowels
	*/
	
	public class Vowels{
	public static void main (String[] args){
		if (args.length != 1){
			System.out.println("Usade: java vowels <text>.");
			return;
		}
	int vowelCounter = 0;
	int stringLength = args[0].length();
	
	for (int pos = 0; pos < stringLength; pos++){
		char theChar = args[0].charAt(pos);
		switch (theChar){
			
			case 'A': case 'a':
			case 'E': case 'e':
			case 'I': case 'i':
			case 'O': case 'o':
			case 'U': case 'u':vowelCounter++; break;
			
		}
		//if (theChar == a || e || i || o || u || A || E || I || O || U)
			//vowelCounter++;
		}
		System.out.print(vowelCounter + " vowel");
		if (vowelCounter != 1)
			System.out.print("s");
		System.out.println();
}
	
	
	
	
	
	/*
public class Vowel{
	public static void main (String[] args){
	int vowelCounter = 0;
	for (int i = args.length - 1; i >= 0; i--){
		char charx = a;
		if (charx == a || e || i || o || u || A || E || I || O || U)
			vowelCounter++;
		}
		System.out.println(vowelCounter + " vowels.");
	}
*/	
}