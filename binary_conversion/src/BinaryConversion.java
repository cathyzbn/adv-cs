import java.util.Scanner;
import java.io.File;

public class BinaryConversion {

	public static void main(String[] args) {
		
//		System.out.println("enter a decimal: \n");
//		scanner = new Scanner( System. in);
//		String input = scanner.nextLine();
//		
		Scanner s = null;
		boolean opened = false;
		try {
			s = new Scanner(new File("input.txt"));
			System.out.println("It's open"); 
			opened = true;
		}catch(Exception e){
			System.out.println("It's not open. There is an issue opening your file.");
		}
		
		
		if(opened) {
			while(s != null && s.hasNextLine()) {
				String input = s.nextLine();
				
				if(!isNumber(input)){
					System.out.println(input + "is not a number");
				}else if(input.contains(".")) {
					try {
						double num = Double.parseDouble(input);
						System.out.println("Here is the binary of decimal "+ num + " :");
						System.out.println(IEEE754(num, "32"));
						System.out.println(IEEE754(num, "64")+"\n");
					}catch(NumberFormatException ne){
						System.out.println("Wrong style for decimal " + input+"\n");
					}
				}else {
					try {
						long num = Long.parseLong(input);
						System.out.println("Here is the binary of integer "+ num + " :");
						System.out.println(binConvert(num) + "\n");
					}catch(Exception e){
						System.out.println("Integer " + input + " is too big"+"\n");
					}
				}
			}
		}
		
//		System.out.println(rationalToBinary(340282300000000000000000000000000000000.0, 64));
	}
	
    public static boolean isNumber(String str) {
        boolean isNumber = true;
        String nonNums = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+= {[}]|\\:;\"'<,>?/";
        
        for(int i= 0; i < nonNums.length(); i++) {
            if(str.contains("" + nonNums.charAt(i))) {
                isNumber = false;
            }
        }
        return isNumber;
    }
	
	private static final int BYTE_NUM = 7;
	private static final int SHORT_NUM = 15;
	private static final int INT_NUM = 31;
	private static final int LONG_NUM = 63;
	private static final String LONG_STR = "-9223372036854775808";
		

	public static String toBinary(long num) {
		/* 
		 * inputs a long
		 * returns the binary representation of the long in String
		 */
		
		// special case:
		if(Long.toString(num) == LONG_STR) {return "1000000000000000000000000000000000000000000000000000000000000000";}
		else if(num == 0) {return "0";}
		
		String binString = "";
		while(num>0) {
			if(num%2 == 1) {
				binString = "1" + binString;
				num -= 1;
			}else {
				binString = "0" + binString;
			}
			num /= 2;
		}
		
		return binString;
	}
	
	
	private static String fillTo(String str, int num) {
		
	/*
	 * fills a String to particular number of digits with 0s in front
	 * returns the filled string
	 */
		
		int strLen = str.length();
		int numOfZero = num - strLen;
		
		for(int i=0; i<numOfZero; i++) {
			str = "0" + str;
		}
		
		return str;
	}
	
	
	public static String binConvert(long num) {
		
		String binString = "";
		boolean isNeg = false;
		if(num<0) {
			isNeg = true;
			num *= -1;
			num -= 1; // this is the same as adding 1 at the end of the negative complement step
		}
		
		binString = toBinary(num);
		if(binString.length() <= BYTE_NUM){binString = fillTo(binString, BYTE_NUM+1);}
		else if(binString.length() <= SHORT_NUM){binString = fillTo(binString, SHORT_NUM+1);}
		else if(binString.length() <= INT_NUM){binString = fillTo(binString, INT_NUM+1);}
		else if(binString.length() <= LONG_NUM){binString = fillTo(binString, LONG_NUM+1);}
		
		if(isNeg) {
			int strLen = binString.length();
			String output = "";
			for(int i=0; i<strLen; i++) {
				if(binString.charAt(i) == '0') {output += "1";}
				else{output += "0";}
			}
			return output;
		}else{return binString;}
	}
	
	
	public static String rationalToBinary(double num, int size) {
		/*
		 * turns a rational number to binary form, with precision of "size"
		 * returns binary in String
		 */
		
		long intPart = (long)(num);
		
		//special case
		String intPartBin = toBinary(intPart);
		
		int decSize = size - 1 - intPartBin.length(); // 1 is for the decimal point
		double decPart = num - intPart;
		long decPartLong = (long)(decPart * Math.pow(2, decSize));
		String decPartBin = toBinary(decPartLong);
		decPartBin = fillTo(decPartBin, decSize);
		
		return (intPartBin + "." + decPartBin);
	}	
	
	
	public static String IEEE754(double num, String precision){
		/*
		 * @param precision should be "32" or "64"
		 * inputs a rational number and returns it in IEEE 754 form with specified precision
		 * returns the IEEE representation in String
		 */
		
		String output = "";
		if(num == 0.0) {
			if(precision == "32") {
				for(int i=0; i<32; i++) {
					output += "0";
				}
			}
			if(precision == "64") {
				for(int i=0; i<64; i++) {
					output += "0";
				}
			}
		}
		
		// the sign bit
		boolean isNeg = false;
		if(num<0) {isNeg = true; num = -num;}
		if (isNeg) {output += "1";}
		else {output += "0";}
		
		//special case: very large
		int exponent = 0;
		int addedExponent = 0;
		if(num >= Math.pow(2, 63)) {
			exponent = 66;
			addedExponent = 66;
			num = num / Math.pow(2, 66);
		}
		
		// retrieving number
		String binary = rationalToBinary(num, 64); //get binary number
		
		// exponent bits
		if(binary.charAt(0)!= '0') {
			exponent += binary.indexOf(".")-binary.indexOf("1")-1; //get the exponent of scientific notation
			}else {
			exponent += binary.indexOf(".")-binary.indexOf("1");
		}
		
		
		
		num *= Math.pow(2, -(exponent-addedExponent));
		binary = rationalToBinary(num, 64); //reconfigure to adjust change in power
		
		if(precision == "32") {
			exponent += 127;
			String binExponent = toBinary((long)exponent);
			binExponent = fillTo(binExponent, 8);
			output += binExponent;
		}else if(precision == "64") {
			exponent += 1023;
			String binExponent = toBinary((long)exponent);
			binExponent = fillTo(binExponent, 11);
			output += binExponent;
		}
		
		// binary representation
		binary = binary.substring(2);
		output += binary;
		
		//precision
		if(precision == "32") {
			if(output.charAt(32) == '1') {
				int i = 31;
				while(i>8) {
					if(output.charAt(i)=='0') {
						output = output.substring(0, i) + "1" + output.substring(i+1);
						break;
					}
					i--;
				}
			}
			output = output.substring(0, 32);
		}
		else if(precision == "64") {
			if(output.charAt(64) == '1') {
				int i = 63;
				while(i>11) {
					if(output.charAt(i)==0) {
						output = output.substring(0, i) + "1" + output.substring(i+1);
						break;
					}
					i--;
				}
			}
			output = output.substring(0, 64);
		}
		
		return output;
	}
}
