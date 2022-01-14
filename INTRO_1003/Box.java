/*
	Write a Java program called Box that displays a rectangle
	of the size chosen by the user in a command-line argument.
	Example:
	C:\> java Box 10
	
	**********
	*        *
	*        *
	*        *
	*        *
	*        *
	*        *
	*        *
	*        *
	**********
*/
public class Box {
	public static void main (String[] args){
		String size = System.console().readLine("Enter a number between 1 and 75 to define the size of the box: ");
		int num = Integer.parseInt(size);
		if (num == 0 || num > 75){
			System.out.println("\nERROR: Your number must be != 0 && <= 75");
			return;
		}
		int counter = 2;
		if (num == 1){
			System.out.println('*');
		}
			else if (num <= 75){
				for (int i = 1; i <= num; i++) {
					System.out.print('*');
				}
				while (counter != num){
					counter ++;
					System.out.print("\n*");
					for (int j = 2; j < num; j++) {
						System.out.print(" ");
					}		
					System.out.print("*");
					}
				System.out.println("");
				for (int i = 1; i <= num; i++) {
					System.out.print("*");
				}
			}
		
	}
}		
			
			/*char [][] draw = new char [num][num];
			
			for (int i = 0; i <= num; i++){
				for (int j = 0; j <= num; j++){
					draw [i][j] = '*';
					System.out.print(draw[i][j]);
				}
				//draw [i][i] = '*';
				//System.out.print(draw[i][i]);
				//System.out.println (draw[i][i]);
			}
			//System.out.print()
			
		}
}

		
			
			
			for (int line = 1; line <= 10; line++) {
			for (int star = 1; star <= line; star++) {
				System.out.print("*");
			}
			System.out.println();
		}

		*/