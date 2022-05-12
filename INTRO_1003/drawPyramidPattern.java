public class drawPyramidPattern {

	public static void main(String [] args) { 
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j < 5 - i; j++) { 
				System.out.print(" "); 
				} 
			for (int k = 0; k <= i; k++) { 
				System.out.print("* "); 
			} 
		System.out.println(); 
		}
System.out.println();
System.out.println();

		for (int i = 0; i < 7-1; i++) { 
			for (int j = 0; j < 7-1 - i; j++) { 
				System.out.print(" "); 
				}
				System.out.print("*");
			for (int k = 1; k <= i; k++) { 
				System.out.print(" ");
			} 
		System.out.println('*'); 
		}
		for (int n = 0; n < 8; n++)
			System.out.print("*");
	}
	 
	

}
