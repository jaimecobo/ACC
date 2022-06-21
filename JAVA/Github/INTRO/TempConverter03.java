/* Converts an array of F temps to C temps and prints them */

public class TempConverter03 {

    // method to do F -> C conversion
    public static double f2c(double fTemp) {
        //System.out.println("in f2c -- received " + fTemp); // what was my input?
        return (fTemp - 32) * 5./9.;
        }

    // method to do C -> F conversion
    public static double c2f(double cTemp) {
        return cTemp * 9./5. + 32;
        }

    public static void main(String[] args) {

        double[] fTemps = {-41.95, 0., 32., 36., 212.};
        double[] cTemps = {0, 0, 0, 0, 0};  // initialize to zeros for now
  
        for (int index=0; index < fTemps.length; index++) { 
            double centigrade = f2c(fTemps[index]);  // convert F -> C
            cTemps[index] = centigrade;  // save into centigrade temps array
            double fahrenheit = c2f(centigrade);
            System.out.println("centigrade: " + centigrade + " fahrenheit: " + fahrenheit);
            }

        // 2nd loop: read each element of the faherheit array and print centigrade temp */
        for (int index=0; index < fTemps.length; index++) { // fun comment
            System.out.printf("%.2fF = %.2fC\n" , 
                              fTemps[index], cTemps[index]); 
        }
    }

}