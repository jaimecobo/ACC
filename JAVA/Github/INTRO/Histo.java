/**
 * Histograms with user selected labels and star counts.
 * 
 * Lab Description: write a class named Histo that includes a
 *  static method with following signature: 
 *      static void histogram(String[] labels, int[] stars)
 *  which allows a label and number of stars for each horizontal line.
 *  Validate inputs and give useful error messages. Start the stars
 *  at the same column without using printf() formatting.
 *    
 */

public class Histo {

	public static void main(String[] args) {
		// what is another way we could initialize the two arrays?

		histogram(new String[]{"butterflys","octopii",
				  "this_is___a____very_____long______label"}, 
				  new int[]{5,8,22});
	}
	
	static void histogram(String[] labels, int[] stars) {
            if (labels.length != stars.length) {
		    System.out.println("labels and stars must be same length");
		    return;
		}
            if (stars.length == 0) {
		    System.out.println("must have at least one label");
		    return;
        }
		
        // Ok, good to go. First find the longest label
        
        int maxLabelLength = 1;
        
        for (int i=0; i < labels.length; i++) {
        	if (labels[i].length() > maxLabelLength) {
        	    maxLabelLength = labels[i].length();	
        	}
        }

        // print the histogram        
        
        for (int i=0; i < labels.length; i++) {
        	// print the label and stay on same line
        	System.out.print(labels[i] + " ");

        	// add padding spaces if needed
        	int paddingSpaces = maxLabelLength - labels[i].length();
        	for (int j=0; j < paddingSpaces; j++) {
        		System.out.print(" ");
        	}

        	// print the stars
        	for (int j=0; j < stars[i]; j++) {
        		System.out.print("*");
        	}
        	
        	// new line
        	System.out.println();
        }
    }

}