package programs;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		String original = "";
		String reverse = "";
		Scanner in = new Scanner(System.in);
		System.out.println("enter a string : ");
		original = in.nextLine();
		int length = original.length();
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		System.out.println(reverse);
		if (original.equalsIgnoreCase(reverse))
			System.out.println("Entered string " + original + " is a palindrome");
		else
			System.out.println("Entered string  " + original + " is not a palindrome");

	}
}