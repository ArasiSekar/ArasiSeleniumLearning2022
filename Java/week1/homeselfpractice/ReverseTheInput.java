package week1.homeselfpractice;

import java.util.Scanner;

public class ReverseTheInput {
	/*
	 * 1. Created Class as ReverseTheInput
	 * 2. Got Input from Console using Scanner class and assigned to number var
	 * 3. Declared temp ,reverse and reminder
	 * 4. Assigned number to temp
	 * 5. Logic used :
	 *     - Find the modulus 10 of that number and save the reminder 
	 *       in reminder variable
	 *     - Reverse = reverse * 10 + reminder
	 *     - temp = temp /10 
	 *     
	 *   6. used While loop and loop will come out if the temp value reaches 0
	 *   
	 */
	
	public static void main(String[] args) {
		
		Scanner consoleInput = new Scanner(System.in);
		System.out.println("Enter the Value to be reversed: ");
		int number= consoleInput.nextInt();
		int temp=number;
		int reverse =0;
		int reminder=0;
		while(temp>0)
		{
			reminder =temp %10;
			reverse= reverse * 10 + reminder;
			temp = temp/10;
		}
		
		System.out.println("The reverse number is :"+reverse);
	}

}
