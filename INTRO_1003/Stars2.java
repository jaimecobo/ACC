/*
	Write a Java program called Stars2 that displays the
	following pattern in the console:
	
	**********
	 *********
	  ********
	   *******
	    ******
		 *****
		  ****
		   ***
		    **
			 *
*/

public class Stars2 {
	public static void main (String[] args){
		for (int line = 1; line <= 10; line++) {
			for (int star = 10; star >= line; star--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}