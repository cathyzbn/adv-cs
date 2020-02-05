
public class Rounding {
	
	public static String round2Places(double x) {
		
		int intPart = (int)x;
		double decPart = x - intPart;
		
		decPart *= 100;
		decPart += 0.5;
		int dec = (int) decPart;
		
		return (intPart + "." + dec);
		
	}
	
	public static void main(String[] args) {
		
		double x = 76.8491;
		
		System.out.println(round2Places(x));
		
	}
	
}
