/* Implements bubble sort on an array 
 * Adds stretch goal#3 and prints final array in groups of 10
 */

class BubbleSort01 {
    public static void main(String[] args) {

        final int RANDOM_CEILING = 1000;  // put a ceiling on returned random numbers
        final int ITEMCOUNT = 100;  // set the array length
        int[] items = new int[ITEMCOUNT];  // declare and allocate new array

        // load the randoms array
        java.util.Random rand = new java.util.Random();  // create a random number generator
        for (int i=0; i < items.length; i++) {
            items[i] = rand.nextInt(RANDOM_CEILING);
        }

        boolean swapping = true;  // let the looping start

        while (swapping) {
            swapping = false;  //  reset the swap flag for each run thru the array

            for (int index = 0; index < items.length - 1; index++) {
                // iterate the array swapping adjacent pairs as necessary
                // display the two values to compare next
                System.out.print("\nitems[" + index + "]=" + items[index] +
                                 " items[" + (index+1) + "]=" + items[index+1]);
                if (items[index] > items[index+1]) {  // should they be swapped?
                    // need to swap elements
                    System.out.print(" swapped!");
                    int temp = items[index];
                    items[index] = items[index+1];
                    items[index+1] = temp; 
                    swapping = true;  // tell the while we swapped one
                }
            }
        } 

        System.out.println("\n");  // final array...
        for (int index=0; index < items.length; index++) {
            if (index%10 == 0) System.out.println();  // new line after 10 elements printed
            System.out.printf("%6d ", items[index]);
        }
    }
}