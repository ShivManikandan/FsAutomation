package programs;

import java.util.Arrays;

public class FindtheSecondMaximumNumberInArray {

	public static void main(String[] args) {
		int largest=0;
		int secondlargest=0;
		 int[] arr={20, 340, 21, 879, 92, 21,474,83647,-200};
		 for(int i=0;i<arr.length;i++)
		 {
		 if(arr[i]>largest)
		 {
			 secondlargest=largest;
			 largest=arr[i];
		 }
		 else if(arr[i]>secondlargest)
		 {
			 secondlargest =arr[i];
		 }
		 
		 System.out.println(Arrays.toString(arr));
		 System.out.println("The second largest number is :" +secondlargest);
		 
	}

}
}