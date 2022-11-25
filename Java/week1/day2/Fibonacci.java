package week1.day2;

public class Fibonacci {
	
	/*
	 * 1. Create a Class Name with Fibonacci
	 * 2. Create main with shortcut
	 * 3. Declare values as value,firstValue,secondValue and temp
	 * 4. Logic of Fibonacci adding the val1 and secondValue and save that in temp
	 * 5. After printing the temp value, reassign firstValue=secondValue and vasecondValue =temp 
	 * 6. Iterate the loop till i reaches the count of value given.
	 */

	public static void main(String[] args) {
		
		int value=10;
		int temp, firstValue=0,secondValue=1;
		System.out.println("Printing Fibonacci series of : "+ value);
				System.out.println(firstValue);
				System.out.println(secondValue);
		
		for(int i=secondValue;i<=value;i++)
		{
			temp=firstValue+secondValue;
			System.out.println(temp);
			firstValue=secondValue;
			secondValue=temp;
		}
	}
}
