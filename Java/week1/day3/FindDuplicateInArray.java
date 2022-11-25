package week1.day3;

import java.util.Arrays;


public class FindDuplicateInArray {
	/*
	 * 1. Create a Class name as FindDuplicateInArray
	 * 2. Declare the Array and find its length
	 * 3. Sort the Array and print in Ascending order
	 * 4. Initialize nested for loop and check for duplicate values
	 * 5. If any Duplicate values then print the duplicate values.
	 */

	public static void main(String[] args) {
		
		int[] nums= {12,25,12,56,89,25};
		//Length of Array
		int length=nums.length;
		System.out.println("The length of the Array is :"+length);
		//To sort the Array
		Arrays.sort(nums);
		System.out.println("The sorted values are");
		for(int k=0; k<=length-1;k++)
		{
			System.out.println(nums[k]);
		}
		int count=0;
		//To find the Duplicate Values
		System.out.println("The Duplicate values are");
		
		for(int i=0;i<=length-1;i++)
		{
			for(int j=i+1;j<length;j++)
			{
				if(nums[i]==nums[j])
				{
					System.out.println(nums[j]);
					count++;
				}
				
			}
		}

	}

}
