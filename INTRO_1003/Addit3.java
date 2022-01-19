public class Addit3 {
	public static void main(String[] args) {
		double grandTotal = 0.0;
		for (String arg : args) {
			double theArg = Double.parseDouble(arg);
			grandTotal += theArg;
		}
		System.out.println("The grand total is " + grandTotal);
	}
}