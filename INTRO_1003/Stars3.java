/*
	Write a Java program called Stars1 that prints the following
	pattern to the console:
	
	*
	**
	***
	****
	*****
	******
	*******
	********
	*********
	**********
*/
public class Stars3 {
	
	public static void main(String[] args) {
		// Using nested loops (tiny fixed memory footprint)
		for (int line = 1; line <= 10; line++) {
			for (int star = 1; star <= line; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// Using a character array (array may become large)
		char[] line = new char[10];
		for (int i = 0; i < line.length; i++)
			line[i] = ' ';
		for (int i = 0; i < line.length; i++) {
			line[i] = '*';
			System.out.println(line);
		}
		
		// Using String concatenation (creates and discards many)
		String line2 = "";
		for (int i = 1; i <= 10; i++) {
			line2 += "*";
			System.out.println(line2);
		}
		
		
	}
	
}