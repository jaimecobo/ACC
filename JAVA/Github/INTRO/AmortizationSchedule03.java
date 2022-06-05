/*
Class to calculate and print a simple amortization table to the console.
Payment is accelerated at the one year mark (doubles payment)
Uses a method for balance calculation
*/

public class AmortizationSchedule03 {

    public static void main(String[] args) {
        // declare and initialize variables
        double balance = 90000.00;  // working balance
        float annualInterestRate = 11.0f;
        double monthlyPayment = 712.00;
        double accumulatedInterest = 0.;
        double monthlyInterest = 0.;
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
        System.out.println("Month | Balance | Interest");

        // print current month and balance and interest for month then 
        //   re-calculate new month number and new balance
        //   new balance = old balance - monthly payment + 
        //                 old balance*interest rate/12 
        // accelerate payment at 1-year point
        // also accumulate the monthly interest and report at end of table
  
        while (balance > 0 && month <= MONTHSPERYEAR * MAXLOANTERM) {
            // Did the year change? If yes, print it
            if (month%MONTHSPERYEAR == 0) {
                System.out.println("Year " + (month/MONTHSPERYEAR + 1));
                }
            System.out.printf("%3d %10.2f %10.2f\n", month, balance, monthlyInterest);
            monthlyInterest = balance*annualInterestRate/MONTHSPERYEAR;
            accumulatedInterest = accumulatedInterest + monthlyInterest;
            balance = balanceRecalc(balance, monthlyPayment, monthlyInterest);
            month++;
            if (month == 12) {  // accelerate the loan after a year
                monthlyPayment *= 2;
                }
            }

        System.out.printf("\nAccum Interest Paid = $%,.2f", accumulatedInterest ); 

        // if balance > 0 then redo previous step
        // else stop
    }

    public static double balanceRecalc(double existingBalance, 
                                       double monthlyPayment, 
                                       double monthlyInterest) {
            return existingBalance - monthlyPayment + monthlyInterest;
    }

}