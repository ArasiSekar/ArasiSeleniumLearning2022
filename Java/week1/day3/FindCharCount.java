package week1.day3;

public class FindCharCount {
	/*
	 * 1. create a Class name as FindCharCount
	 * 2. Declare String Variable ,char and int variables
	 * 3. Convert the String to CharArray and print the result
	 * 4. Initialize  for loop and check the charArray with the Char occurrences
	 * 5. Print the number of occurrences.
	 */

	public static void main(String[] args) {
		
		String str="Cognizant";
		char ch='C';
		int count=0;
		//Convert String to CharArray	
		
		  char[] convertToChar=str.toCharArray();
		  System.out.println("After Converting to Char Array :");
		  for(int i=0;i<=convertToChar.length-1;i++)
		  {
			  System.out.print(convertToChar[i]);
		  }
		  for(int j=0;j<=convertToChar.length-1;j++)
		  {
			  if(convertToChar[j]==ch)
			  {
				  count++;
			  }
			  
		  }
		  System.out.println();
		  System.out.println("The number of occurances of given char "+ch+" is:"+count);
		
		
	}

}
