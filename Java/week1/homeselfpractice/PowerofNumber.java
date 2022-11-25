package week1.homeselfpractice;

import java.util.Scanner;

public class PowerofNumber {
	/*
	 * 1. Create a Class as PowerofNumber
	 * 2. Using Scanner get the Input from console for base and power variables
	 * 3. To find the power of one number to another number
	 *    base= (base^power)
	 * 4. Print the result.
	 */

	public static void main(String[] args) {
		
		Scanner consoleInput = new Scanner(System.in);
		int base, power;
		System.out.println("Enter the Base Value:");
		base=consoleInput.nextInt();
		System.out.println("Enter the Power Value:");
		power=consoleInput.nextInt();
		int result=1;
		for(int i=1;i<=power;i++)
		{
			result = result*base; 
		}
		System.out.println(result);
		

	}

}
