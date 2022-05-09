public class TriangleZ {

	public static void main(String [] args) { 
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j < 5 - i; j++) { 
				System.out.print(" "); 
				}
			System.out.print("*");
			for (int k = 0; k <= i; k++) { 
				System.out.print(" ");
				int x = 1;
				if(x <= 2 )
				System.out.println("*");
				x++;
			} 
		System.out.println(); 
		} 
	}

}