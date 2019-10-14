package Assignment5;

import java.util.InputMismatchException;
import java.util.Scanner;

//Question: 1
/*
 * Create a class called Number.
 * Write a method called count() which can calculate quotient of two integers
 * and use try...catch to deal with all possible exception. 
 */

public class Number {

	public static void main(String[] args) {
		count();
	}

	@SuppressWarnings("resource")
	public static void count() {
		int ip1, ip2, c;
		int retryCount = 5;
		while( retryCount != 0) {
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Enter Dividend : ");
				//ip1 = s.nextInt();
				ip1 = Integer.parseInt(s.next());
				System.out.println("Enter Divisor : ");
				//ip2 = s.nextInt();
				ip2 = Integer.parseInt(s.next());
				c = ip1/ip2;
				System.out.println("Quotient is " + c);
				break;
			} 
			catch(ArithmeticException exe){
				System.out.println("Error: " + "divide by 0");
				System.out.println("Enter only non-zero divisor");
				retryCount--;
			} 
			catch(NumberFormatException excep) {
				System.out.println("Error: " + "incorrect number format");
				System.out.println("Enter only integer value");
				retryCount--;
			}
			catch(InputMismatchException e) {
				System.out.println("Error: " + "input mismatch");
				System.out.println("Enter only integer value");
				retryCount--;
			}
		}
		if(retryCount == 0) {
			System.out.println("Exceeded maximum retry count");
		}
		System.out.println("End of program");
	}
}
