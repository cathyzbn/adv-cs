
import java.util.ArrayList;

public class Amicabilibus {
	
	public static final int upperbound = (int) Math.pow(10, 6);
	public static ArrayList<Integer> factorSums = new ArrayList<Integer>();
	public static ArrayList<Integer> checked = new ArrayList<Integer>();
	
//	public static int sumFactors(int n) {
//		int sum = 1;
//		for(int i=2;i <= (int)(Math.sqrt(n)); i++){
//	    	if(n%i == 0){
//	         	sum += i;
//	           	if(i != n/i){sum += n/i;}
//	       	}
//	   	}
//	    return sum;
//	}
	
	public static int sumFactors(int n) {
		if(n ==0) {
			return 0;
		}
		int sum = 1;
		int original = n;
		for(int i=2; i <= Math.sqrt(n); i++) {
			int product = 1;
			while(n%i == 0) {
				product=product*i+1;
				n/=i;
			}
			sum*=product;
		}
		if(n>1) {sum*=1+n;}
		sum -= original;
		return sum;
	}
	
	public static void main(String[] args) {
		
		for(int n=0; n<=upperbound; n++) {
			factorSums.add(sumFactors(n));
		}
		System.out.println("done");
		
		for(int i=0; i<=upperbound; i++) {
			int j = factorSums.get(i);
			if(j <= upperbound &&i == factorSums.get(j)&& !checked.contains(i) && j!=i) {
				checked.add(j);
				System.out.println("(" + i+ "," + factorSums.get(i) + ")");			
			}
		}
	}
}

