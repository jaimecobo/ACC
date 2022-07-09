package edu.acc.java;
import java.util.Scanner;

class FC {
     // instance vars
     Scanner console = new Scanner(System.in); // read from keyboard
     Double tempValue; // valid: any value
     String tempScale; //  valid: "F" and "C" upper or lower case

     
    public static void main(String... args) {
        FC myFC = new FC();

        // loop forever (could be changed to exit gracefully)
        while (true) {

            // get temp scale from console; allow recovery if invalid
            do {
                System.out.print("Enter temp scale (F or C): ");
                myFC.tempScale = myFC.console.nextLine();
               }
            while (!myFC.validTempScale());  // loop until they give us the goods

            // get temp value from console; allow recovery
            do {
                System.out.print("Enter temp value: ");
                try {
                    myFC.tempValue= Double.parseDouble(myFC.console.nextLine());
                    }
                catch (Exception ex) {
                    System.out.println("Invalid temp format..please retry");
                    myFC.tempValue = null;
                    }
                }
            while (myFC.tempValue == null);

            // do conversion and print
            switch (myFC.tempScale.toLowerCase()) {
                case "f": System.out.println("converting " + myFC.tempValue + 
                                                         myFC.tempScale + " to Cel");  // help me spell!
                          break;
                case "c": System.out.println("converting " + myFC.tempValue + 
                                                         myFC.tempScale + " to Fahr");  // help me spell!
                          break;
                default: System.out.println("Wrong temp scale");  // should have been checked in validTempScale()
            }

        }
         
    }

    /* validates temp scale for acceptable */
    private boolean validTempScale() {
        return true; // TODO
    }
}