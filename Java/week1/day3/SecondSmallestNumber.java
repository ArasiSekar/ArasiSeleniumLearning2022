package week1.day3;

import java.util.Arrays;

public class SecondSmallestNumber {
	/*
	 * 1. Create a Class Name as SecondSmallestNumber
	 * 2. Declare the array value in num
	 * 3. Find the length of Array
	 * 4. Sort the Array using the property
	 * 5. Print the Sorted value in ascending order
	 * 6. Find the second Largest by using num[1] and print that array.
	 */

	public static void main(String[] args) {
		int[] num= {23,45,67,32,89,22};
		//To find the length of Array
		int length = num.length;
		System.out.println("The length of Array is "+length);
		//Sorting the Array
		Arrays.sort(num);
		//To display in Ascending Order
		System.out.println("The Array in Ascending Order:");
		for(int i=0;i<=length-1;i++)
		{
			System.out.println(num[i]);
		}
		
		//To display the Second Smallest number
		
		System.out.println("The Second Smallest Number is :"+num[1]);
		
		

	}

}
