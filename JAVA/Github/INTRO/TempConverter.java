/* Converts an array of F temps to C temps and prints them */

public class TempConverter {
    public static void main(String[] args) {

        double[] fTemps = {-41.95, 0., 32., 36., 212.};
  
        // loop over each element of the faherheit array and compute centigrade temp */
        for (int index=0; index < fTemps.length; index++) { // fun comment
            // do the conversion
            double centigrade =  (fTemps[index] - 32) * 5./9.;
            System.out.printf("%.2fF = %.2fC\n" , 
                              fTemps[index], centigrade); 
        }
    }

}