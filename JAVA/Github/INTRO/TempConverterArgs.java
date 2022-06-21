/* Converts F temps from args to C temps and prints them */

public class TempConverterArgs {
    public static void main(String[] args) {

        if (args.length == 0) System.out.println("No input temps given");
        // obtain each element of the args array and convert to centigrade temp */
        for (int index=0; index < args.length; index++) { 
            double fahrenheit = Double.parseDouble(args[index]);  // convert String to double
            double centigrade =  (fahrenheit - 32) * 5./9.;
            System.out.printf("%.2fF = %.2fC\n" , fahrenheit, centigrade); 
        }
    }

}