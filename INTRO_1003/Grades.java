/*
	Write a program called Grades that presents the average, mnimun, and maximun grade in Mr. Miyagi's class.
	His students GPAs were
	2.9 2.9 3.8 3.1 3.4 2.7 2.1 2.8 3.2 3.3 3.8 2.6
	
	*/
public class Grades {
	public static void main (String[] args){
		double [] grades = new double [] {2.9, 2.9, 3.8, 3.1, 3.4, 2.7, 2.1, 2.8, 3.2, 3.3, 3.8, 2.6};
		double ave = 0.0, min = grades[0], max = grades [0];
		
		for (double grade : grades) {
			ave += grade;
			if (grade < min)
				min= grade;
			if (grade > max)
				max = grade;		
		}
		ave /= grades.length;
		
		System.out.printf("the average GPA is: %.1f\n", ave);
		System.out.println("the minimun GPA is: " + min);
		System.out.println("the maximun GPS is: " + max);

	
	}

}