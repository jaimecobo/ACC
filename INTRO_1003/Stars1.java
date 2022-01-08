/*
	write a Java program called Stars1 that print the following pattern to the console
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
	
public class Stars1{
	public static void main(String[] args){
		String line = "";
		for (int i = 0; i <= 9; i++){
			line = line + "*";
			System.out.println(line);
		}
		char [] line1 = new char [] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		for (int i = 0; i <= 9; i++){
			line1 [i] = '*';
			System.out.println(line1);
		}
		for (int line2 = 1; line2 <= 10; line2++){
			for (int star = 1; star <= line2; star++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}