/*
Day2 in-class code snippet. 
Calculate and print a simple amortization table to the console.
*/

public class AmortizationSchedule {

    public static void main(String[] args) {
        // declare and initialize variables
        double balance = 90000.00;  // working balance
        float annualInterestRate = 11.0f;
        double monthlyPayment = 712.00;
        float month = 0f;  // current month
    
        // print balance, annualInterestRate, monthlyPayment
        System.out.println("Initial Balance = " + balance);
        System.out.println("Annual Interest Rate = " + annualInterestRate + "%");
        // adjust int rate for calculations
        annualInterestRate = annualInterestRate/100;  
                                                      
        System.out.println("Monthly Payment = " + monthlyPayment);
        System.out.println();

        // print table header (month and balance)
        System.out.println("Month | Balance ");

        // print current month and balance then 
        //   re-calculate new month number and new balance
        //   new balance = old balance - monthly payment + 
        //                 old balance*interest rate/12
        System.out.println(month + "     " + balance);
        balance = balance - monthlyPayment + 
                 (balance*annualInterestRate/12);
        month++;
        System.out.println(month + "     " + balance);
        // if balance > 0 then redo previous step
        // else stop
    }

}