/*
Class to calculate and print a simple amortization table to the console.
Payment is accelerated at the one year mark (doubles payment)
*/

public class AmortizationSchedule01 {

    public static void main(String[] args) {
        // declare and initialize variables
        double balance = 90000.00;  // working balance
        float annualInterestRate = 11.0f;
        double monthlyPayment = 712.00;
        int month = 0;  // current month
        final int MONTHSPERYEAR = 12;
        final int MAXLOANTERM = 40;
    
        // print balance, annualInterestRate, monthlyPayment
        System.out.println("Initial Balance = " + balance);
        System.out.println("Annual Interest Rate = " + annualInterestRate + "%");
        // adjust int rate for calculations
        annualInterestRate = annualInterestRate/100;  
                                                      
        System.out.println("Monthly Payment (1st year, then doubles) = " + monthlyPayment);

        // print table header (month and balance)
        System.out.println("Month | Balance ");

        // print current month and balance then 
        //   re-calculate new month number and new balance
        //   new balance = old balance - monthly payment + 
        //                 old balance*interest rate/12 
  
        while (balance > 0 && month <= MONTHSPERYEAR * MAXLOANTERM) {
        //while (balance > 0 && month <=2) {
            System.out.printf("%3d %10.2f\n", month, balance);
            balance = balance - monthlyPayment + 
                     (balance*annualInterestRate/MONTHSPERYEAR);
            month++;
            if (month == 12) {  // accelerate the loan after a year
                monthlyPayment *= 2;
                }
            }

        // if balance > 0 then redo previous step
        // else stop
    }

}