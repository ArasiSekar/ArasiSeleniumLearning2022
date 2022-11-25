package week1.day3;

public class FindIntersection {
	/*
	 * 1. Create Class name as FindIntersection
	 * 2. Declare two different arrays
	 * 3. Initialize nested for loop to compare both the arrays
	 * 4. If arr1 values matches with arr2 then print that matches value alone.
	 */

	public static void main(String[] args) {
		
		int[] arr1= {3,2,11,4,6,7};
		int[] arr2= {1,2,8,4,9,7};
		System.out.println("Printing the Common Array values from both Array List:");
		System.out.print("{");
		for(int i=0;i<=arr1.length-1;i++)
		{
			for(int j=0;j<=arr2.length-1;j++)
			{
				if(arr1[i]==arr2[j])
				{
					System.out.print(" "+arr1[i]);
				}
			}
		}
		System.out.print("}");

	}

}
