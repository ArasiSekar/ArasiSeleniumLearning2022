package week1.day2;

public class OddorEven {
	
	/*
	 * 1. Create a Class with Name OddorEven
	 * 2. Declare an input variable
	 * 3. To Check Odd or Even Logic to be used :value % 2==0 (reminder is 0)
	 *    then even else Odd
	 * 4. Print the result.
	 */
	
	public static void main(String[] args) {
		
		int val=9;
		if(val%2==0)
		{
			System.out.println("The given Value "+val+" is: Even");
		}else
		{
			System.out.println("The given Value "+val+" is: Odd");
		}
	}

}
