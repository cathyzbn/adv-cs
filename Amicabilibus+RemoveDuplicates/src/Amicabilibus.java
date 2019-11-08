
import java.util.ArrayList;

public class Amicabilibus {
	
	public static final int upperbound = 901425; //(int) Math.pow(10, 6);
	public static ArrayList<Integer> factorSums = new ArrayList<Integer>();
	public static boolean[] checked = new boolean[upperbound+1];
	
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
	
//this is Sarah's method, but apparently it runs really slow...
	public static int sumFactors(int n) {
		int sum = 1;
		int original = n;
		for(int i=2; i*i<=n; i++) {
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
			if(j <= upperbound && checked[i] == false && j!=i) {
				checked[i] = true; 
				if(i == factorSums.get(j)) {
					System.out.println("(" + i+ "," + factorSums.get(i) + ")");
				}
			}
		}
	}
}

