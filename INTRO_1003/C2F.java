class C2F {

	public static void main (String[] args){
		String celsiusTxt = System.console().readLine("Enter a celsius temperature: ");
		//Conver String into Double
		double celsius = Double.parseDouble(celsiusTxt);
		//Convert to fahrenheit
		double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
		System.out.println(celsius + " celsius is equal to " + fahrenheit + " fahrenheit");
		
	}
	

}