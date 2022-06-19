/* Converts an array of F temps to C temps and prints them */

public class TempConverter01 {
    public static void main(String[] args) {

        double[] fTemps = {-41.95, 0., 32., 36., 212.};
        double[] cTemps = {0, 0, 0, 0, 0};  // initialize to zeros for now
  
        // 1st loop: use each element of the faherheit array to compute centigrade temp */
        for (int index=0; index < fTemps.length; index++) { // fun comment
            // do the conversion
            double centigrade =  (fTemps[index] - 32) * 5./9.;
            // put the answer in the cTemps array
            cTemps[index] = centigrade;
            }

        // 2nd loop: read each element of the faherheit array and print centigrade temp */
        for (int index=0; index < fTemps.length; index++) { // fun comment
            System.out.printf("%.2fF = %.2fC\n" , 
                              fTemps[index], cTemps[index]); 
        }
    }

}