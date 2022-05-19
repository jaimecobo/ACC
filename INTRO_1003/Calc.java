public class Calc {

	public static void main (String[] args){
		if (args.length != 3){
			System.out.println ("Usage: java Calc <number> <operator> <number>");
		return;}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[2]);
		int result = 0;
		if (args[1].equals ("+")){
			result = num1 + num2;
			System.out.println(result);
		}else if (args[1].equals ("-")){
			result = num1 - num2;
			System.out.println(result);
		}else if (args[1].equals ("x")){
			result = num1 * num2;
			System.out.println(result);
		}else if (args[1].equals ("/")){
			result = num1 / num2;
			System.out.println(result);
		}
	}

}
		