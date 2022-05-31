/* Converts a loan formula into Java code and prints payment */

public class AmortizationFormula {
    public static void main(String[] args) {
        double A = 0.;
        double P = 90000.;
        double r = .11/12; // monthly interest
        int n = 10*12;  // 30 year term
  
        double rPlus1ToTheN = Math.pow(r+1,n);
        A = P*(r*rPlus1ToTheN/(rPlus1ToTheN-1));
        System.out.printf("A=$%,.2f\n\n\n" , A); 
    }

}