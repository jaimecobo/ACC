/*
 *
 * Class to print "car" iff modulo 3 of index, 
 * else "buzz" if modulo 5
 * else "carbuzz" if both modulo 3 and modulo 5
 */

public class CarBuzzA {

    public static void main(String[] args) {
    
    for (int n=1; n <= 100; n++) {
        System.out.print("\n" + n + " ");
        if (n%3 == 0 && n%5 == 0) {
           System.out.print("carbuzz");
           }
        else if (n%3 == 0) {
           System.out.print("car");
           }
        else if (n%5 == 0) {
           System.out.print("buzz");
           }
        }
    }
    
}