
class Casting{

	
	
	public static void main(String[] args){
		int numInt = 54321;
		float numFloat = 10.49f;
		float numFloat05 = 10.5f;
		long numLong = 1000L;
		double numDouble = 53.46;
		String str = "";
		
		str += numInt;
//		str = String.valueOf(numInt);
		System.out.println("First digit of " + numInt + " is: " + str.charAt(0));
		System.out.println("Math.ceil of " + numFloat + " is: " + Math.ceil(numFloat));
		System.out.println("Math.round of " + numFloat + " is: " + Math.round(numFloat));
		System.out.println("Math.round of " + numFloat05 + " is: " + Math.round(numFloat05));
		long doubleToLong = (long) numDouble;
		System.out.println("The result of casting double number = " + numDouble + " to long is: " + doubleToLong);
	}


}
