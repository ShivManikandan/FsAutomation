package programs;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the factorial number : ");
		int a=scanner.nextInt();
		int num=1;
		 int fact = num;
		 
		 for (int count=a;count>0;count--)
		 {
			 fact= fact*count;
		 }
		 
		
		System.out.println("The factoria number is :" +fact);


	}

}
