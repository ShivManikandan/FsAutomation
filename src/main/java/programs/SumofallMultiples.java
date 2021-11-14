package programs;

import java.util.Scanner;

public class SumofallMultiples {

	public static void main(String[] args) {
		
			int number1;
			int sum=0;
		
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the First Number:");
			number1 = scan.nextInt();
			for (int i = 1; i < number1; i++) {
				if ((i % 3 == 0) || (i % 5 == 0)) {
					sum=sum+i;
				} 
				
					
				}
			System.out.println("The sum of  divisible by 3 and 5 is : " + sum);

			}

}	

