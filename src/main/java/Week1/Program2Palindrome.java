package Week1;

import java.util.Scanner;

public class Program2Palindrome {

	public static void main(String[] args) {

		Scanner inputnumber = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = inputnumber.nextInt();

		int remainder = 0;
		int sum = 0;
		int t;
		t = num;

		while (num != 0) {
			remainder = num % 10;
			sum = (sum * 10) + remainder;
			num = num / 10;

		}

		if (t == sum) {
			System.out.println("The number is palindrome : ");
		} else {
			System.out.println("The number is not a palindrome : ");
		}

		/*
		 * 1 START 2. Take input from the user . 3. Store the input in a new variable t.
		 * 4.Until number is not equal to zero, find the reminder of the num and store
		 * it in a variable (reverse). a.Find the modulo of the given input. b.Find the
		 * sum by multiplying *10 and add the remainder. c.Divide the number by 10
		 * repeat step 3 using a while loop.. 5. Check if the element is equal to
		 * reverse. 6.If it is equal, Print it is palindrome 7.Else print it is not
		 * palindrome. 8. END
		 */

	}

}
