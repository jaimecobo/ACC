public class Triangle {
	private static void error (){
        System.out.println("\nERROR!!! You must enter an odd number between 1 and 75.");
	}
	public static void main (String [] args){
		
		String tri = System.console().readLine("Enter an odd number between 1 and 75 to define the size of the triangle: ");
        int base = Integer.parseInt(tri);
        if (base == 0 || base > 75){
            error();
			return;
        }
        int odd = base % 2;
        if (odd == 0){
            error();
			return;
        }
        int high = (base - 1) / 2;
		int space = -1;
		for (int i = 0; i < high; i++) {
			for (int j = 0; j < high - i; j++) {
				System.out.print(' '); 
			}
            System.out.print('*');
			if (i > 1){
				for (int k = 0; k < space; k++) 
                    System.out.print(' ');
			}else
				System.out.print(' ');
			if (i > 0)
				System.out.println('*');
			else 
				System.out.println();
			space = space + 2;
		}
		for (int n = 0; n < base; n++)
			System.out.print('*');
	}			
}