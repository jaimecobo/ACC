
public class TriangleP {
    
    private static void rightSide (int x){        
       //for (int i = 0; i < x; i++) { 
	   int space = 0;
		for (int j = 0; j < x - space; j++) { 
                    System.out.print(" "); 
		}
                //System.out.print("*");
		for (int k = 0; k <= i; k++) { 
                    System.out.print("*");
		} 
		//System.out.println('*'); 
		}
    }
    public static void main(String[] args) {
	String tri = System.console().readLine("Enter an odd number between 1 and 75 to define the size of the triangle: ");
        int num = Integer.parseInt(tri);
        if (num == 0 || num > 75){
            System.out.println("ERROR, You must enter an odd number between 1 and 75 ");
            return;
        }
        int odd = num % 2;
        if (odd == 0){
            System.out.println("ERROR, You must enter an odd number between 1 and 75 ");
        return;
        }
        int base = num;
        int high = (num + 1) / 2;
        int half = num / 2;
        int x = high;
        //int mid = med / 2 + 1;
        int right = 0;
        // System.out.println(base);
        // System.out.println(high);
        // System.out.println(midd);
        while(high > 1){
            for (int i = 1; i <= half; i++){
                System.out.print(" ");
            }
            System.out.print("*");
            if (right == high)
                rightSide(x);        
            high--;
            half--;
            right = high;
            System.out.println();
        }
        for (int n = 0; n < base; n++)
            System.out.print(("\033[0m * \033[0m\n"););
	}
}