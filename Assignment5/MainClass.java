package Assignment5;

public class MainClass {

	public static void main(String[] args) {
		FullTime obj1 = new FullTime("john",500);
		Contractor obj2 = new Contractor("Adam",500,5);
		System.out.println("Fulltime employee salary is " + obj1.calculateSalary());
		System.out.println("Contractor employee salary is " + obj2.calculateSalary());
	}
}
