class Count{
	
	public static void main (String [] args){
		countUp (5);
	}
	public static void countUp (int n){
		if (n == 0){
			System.out.println("Blastoff");
		}
		else {
			countUp(n-1);
			System.out.println(n);
		}
	}
	
}
