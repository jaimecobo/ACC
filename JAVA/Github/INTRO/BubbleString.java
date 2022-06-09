/* Implements bubble sort on an array based on length of elements
 * Adds stretch goal#2
 */

class BubbleString {
    public static void main(String[] args) {

        String[] items = {"bumblebee", "tree", "honey", "karst", "yellow", "black", "hive", "fly", "lava", "lamp", "venom", "nalgene"};

        boolean swapping = true;  // let the looping start

        while (swapping) {
            swapping = false;  //  reset the swap flag for each run thru the array

            for (int index = 0; index < items.length - 1; index++) {
                // iterate the array swapping adjacent pairs as necessary
                // display the two values to compare next
                System.out.print("\nitems[" + index + "]=" + items[index] +
                                 " items[" + (index+1) + "]=" + items[index+1]);
                if (items[index].length() > items[index+1].length()) {  // should they be swapped?
                    // need to swap elements
                    System.out.print(" swapped!");
                    String temp = items[index];
                    items[index] = items[index+1];
                    items[index+1] = temp; 
                    swapping = true;  // tell the while we swapped one
                }
            }
        } 

        System.out.println("\n");  // final array...
        for (int index=0; index < items.length; index++) {
            if (index%10 == 0) System.out.println();  // new line after 10 elements printed
            System.out.printf("%10s ", items[index]);
        }
    }
}