
public class TriangleM {

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
                //int left = high;
               // System.out.println(base);
               // System.out.println(high);
               // System.out.println(midd);
                while(high > 1){
                    for (int i = 1; i <= half; i++){
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    //if (high == left -1 && high == 2){
                     //   for (int j = 0; j<= half/2; j++){
                       //     System.out.print(" ");
                       // }
                    //}
                    /*int k = 0;
                    int mid = half;
                    mid = mid * 2;
                    if(k > 0){
                        for(int j = 0; j <= mid; j++)*/
                            //System.out.println("*");
                    
                               
                    //k++;
                    high--;
                    half--;
                    System.out.println();

                }
                for (int n = 0; n < base; n++)
                    System.out.print("*");
    }
}
