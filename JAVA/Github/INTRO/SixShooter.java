/*
 * Randomly set elements of an array to true until entire array is true
 */

public class SixShooter {
    public static void main(String[] aaa) {
        boolean[] truthOrConsequences = new boolean[6]; // target array to set true
        boolean loading = true;  // remains true until loading is done, then false so while quits
        java.util.Random autoloader = new java.util.Random();  // source of randoms
        
        while (loading) {
            truthOrConsequences[autoloader.nextInt(6)] = true;  // set a single random element true

            for (int i=0; i < truthOrConsequences.length; i++) {  // see if all elements true yet
                if (truthOrConsequences[i]) {
                    System.out.println("loaded in chamber " + i);
                    if (i == truthOrConsequences.length - 1) loading = false;  // are we there yet?
                }
                else {
                    System.out.println("break");
                    break;
                    } 
            }
        }

    }
}