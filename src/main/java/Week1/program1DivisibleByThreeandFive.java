package Week1;

import java.util.Scanner;

public class program1DivisibleByThreeandFive {

	public static void main(String[] args) {
		int number1;
		int number2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the First Number:");
		number1 = scan.nextInt();
		System.out.println("Enter the Second Number:");
		number2 = scan.nextInt();
		for (int i = number1; i <= number2; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz ");

			} else if (i % 5 == 0) {
				System.out.println("Buzz");

			} else {
				System.out.println("The Number is not divisible by 3 and 5 is : " + i);
			}

		}

	}

}
