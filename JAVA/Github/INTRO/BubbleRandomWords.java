/* Implements bubble sort on an array based on length of elements
 * New and improved! Computes random words for the array
 */

class BubbleRandomWords {
 
    public static String[] buildItemsArray(int arrayLength) {
        final String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                                   "n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] words = new String[arrayLength];  // build array of requested length
        java.util.Random randy = new java.util.Random();  // create an object to give us random numbers
        
        for (int i=0; i < words.length; i++) {  // loads the words array
            String word = "";  // create an new empty word which will be added to letter by letter
            int wordLength = randy.nextInt(words.length) + 2;  // get a random word length (minimum 2 letters)
            
            for (int j=0; j < wordLength; j++) {  // builds one word
               int letterIndex = randy.nextInt(words.length);  // get a random letter index
               String letter = alphabet[letterIndex];  // get corresponding letter
               word += letter;  // concatenate the letter to our word 
            }
      
        words[i] = word;  // add completed word to array
        }

        return words;  // return completed array to caller
    }

    public static void main(String[] args) {
        String[] items = buildItemsArray(10);  // extract array building to a separate function as developed in classroom
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