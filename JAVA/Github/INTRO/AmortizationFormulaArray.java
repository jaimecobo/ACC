/* Converts a loan formula into Java code and prints payment */

public class AmortizationFormulaArray {
    public static void main(String[] args) {
        double A = 0.;
        double P = 90000.;  // P is available as an args[0]
        
        double r = 0.; // monthly interest comes from interestRates array
        int n = 30*12;  // year term from args[1]

        double[] interestRates = {1.95, 17.99, 29.95, 36., 120.};
  
        if (args.length == 2) {
            P = Double.parseDouble(args[0]);
            n = Integer.parseInt(args[1]);
        }
        // loop over each element of the interestRates array and compute payment */
        for (int index=0; index < interestRates.length; index++) { // fun comment
            r = interestRates[index]/100/12;
            double rPlus1ToTheN = Math.pow(r+1,n);
            A = P*(r*rPlus1ToTheN/(rPlus1ToTheN-1));
            System.out.printf("A at interest rate %.2f = $%,.2f\n\n\n" , 
                              interestRates[index], A); 
        }
    }

}