class BubbleSort {
    public static void main(String[] args) {
        // implement bubble sort on an array
        int[] items = {2, -4, 77, 11, 34, 55, 2, 89, 1, 3};
        boolean swapping = true;
        while (swapping) {
            swapping = false;  //  reset the swap flag for each run thru the array

            for (int index = 0; index < items.length - 1; index++) {
            // work thru array swapping adjacent pairs if not ascending
                // display the two values to compare next
                System.out.print("\nitems[" + index + "]=" + items[index] +
                                   " items[" + (index+1) + "]=" + items[index+1]);
                if (items[index] > items[index+1]) {
                    // need to swap elements
                    System.out.print(" swapped!");
                    int temp = items[index];
                    items[index] = items[index+1];
                    items[index+1] = temp; 
                    swapping = true;
                }
            }

        } 

    System.out.println();  // final array...
    for (int index=0; index < items.length; index++) {
        System.out.print(items[index] + " ");
        }
    }
}