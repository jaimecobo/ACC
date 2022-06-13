/*
 *
 * Class to print "car" iff modulo 3 of index, 
 * else "buzz" if modulo 5
 * else "carbuzz" if modulo 3 and modulo 5
 */

public class CarBuzzC {

    public static void main(String[] args) {
    
    for (int n=1; n <= 100; n++) {
        String result = "\n" + n + " ";
        if (n%3 == 0) {
           result += "car";
           }
        if (n%5 == 0) {
           result += "buzz";
           }
        System.out.print(result);
        }
    }
    
}