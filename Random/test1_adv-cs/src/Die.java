
import java.util.Random;

public class Die extends Random{
	
	private final static int sides = 6;
	
	public int roll() {
		
		int number = this.nextInt(sides) + 1;
		return number;
		
	}
	
	public static void main(String[] args) {
	
		Die die1 = new Die(), die2 = new Die();
		int num1 = die1.roll(), num2 = die2.roll();
		System.out.println("Die 1 rolls " + num1);
		System.out.println("Die 2 rolls " + num2);
		System.out.println("the sum is " + (num1 + num2));
	
	}
	
}






