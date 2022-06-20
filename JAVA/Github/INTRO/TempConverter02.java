/* Converts an array of F temps to C temps and prints them */

public class TempConverter02 {

    // separate method from main (cannot be within main) to do F -> C conversion
    public static double f2c(double fTemp) {
        //System.out.println("in f2c -- received " + fTemp); // what was my input?
        return (fTemp - 32) * 5./9.;
        }

    public static void main(String[] args) {

        double[] fTemps = {-41.95, 0., 32., 36., 212.};
        double[] cTemps = {0, 0, 0, 0, 0};  // initialize to zeros for now
  
        // 1st loop: use each element of the faherheit array to compute centigrade temp */
        for (int index=0; index < fTemps.length; index++) { // fun comment
            // do the conversion
            //double centigrade =  (fTemps[index] - 32) * 5./9.; // old non-function way
            double centigrade = f2c(fTemps[index]);  // new function way
            // put the answer in the cTemps array
            cTemps[index] = centigrade;  // could centigrade be skipped and just put result of f2c
                                         // in cTemps[index] ?
            }

        // 2nd loop: read each element of the faherheit array and print centigrade temp */
        for (int index=0; index < fTemps.length; index++) { // fun comment
            System.out.printf("%.2fF = %.2fC\n" , 
                              fTemps[index], cTemps[index]); 
        }
    }

}