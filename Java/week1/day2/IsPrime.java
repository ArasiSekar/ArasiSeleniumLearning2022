package week1.day2;

public class IsPrime {
	/*
	 * 1. Create a class name as IsPrime
	 * 2. Create main method using shortcut
	 * 3. Declare Variables
	 * 4. To Find given number is Prime or not Logic to be used
	 *    if the given number % i gives 0 then its not a prime number
	 *    else its a prime number
	 * 5. Print the result.
	 */
	
	public static void main(String[] args) {
		
		int num=11;
		int count = 0;
		
		for(int i=2;i<=num-1;i++)
		{
			if(num%i==0)
			{
				count++;				
				break;
			}
					
		}
		if(count==0)
		{
			System.out.println("The given number is Prime");
		}
		
		else
		{
			System.out.println("The given number is not prime");
		}
	
	}
	

}
