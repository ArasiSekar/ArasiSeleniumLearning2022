package week1.day1;

/*
 * 1. Create a class Name Car
 * 2. Create Methods - driveCar ,applyBrake, soundHorn, isPuncture 
 * 3. Print statements in all methods
 * 4. Create a Main method
 * 5. Create an Object
 * 6. Call all methods by using the object
 * 7. Run and Confirm
 */

public class Car {
	
	public void driveCar()
	{
		System.out.println("driveCar Method Calling");
	}

	public void applyBrake()
	{
		System.out.println("applyBrake Method Calling");
	}
	
	public void soundHorn()
	{
		System.out.println("soundHorn Method Calling");
	}
	public String isPuncture()
	{
		return "isPuncture Method Calling";
	}
	
	
	public static void main(String[] args) {
		
		Car carObj = new Car();
		carObj.driveCar();
		carObj.applyBrake();
		carObj.soundHorn();		
		String puncture = carObj.isPuncture();
		System.out.println(puncture);
		
		
		
	}
}
