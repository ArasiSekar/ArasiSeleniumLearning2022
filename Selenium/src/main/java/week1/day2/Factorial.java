package week1.day2;

public class Factorial {
	/*
	 * 1. Create a Class Name as Factorial without main
	 * 2. Create Main using Shortcut
	 * 3. Declare Class variable type int with value as input
	 * 4. Logic to Print Factorial
	 * 5. To find Factorial that needs to be multiplied with Previous number
	 * 6. Eg : Factorial of 6 is  6= 1*2*3*4*5*6
	 * 7. Print the value
	 */
	public static void main(String[] args) {
		
		int value=5;
		int fact=1;
		for(int i=1;i<=value;i++)
		{
			
			fact=fact*i;
			
		}
		System.out.println("Factorial of "+value +" is :"+fact);
	}

}
