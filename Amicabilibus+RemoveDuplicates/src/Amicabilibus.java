import java.util.ArrayList;

public class Amicabilibus {
	
	public static final int upperbound = (int) Math.pow(10, 6);
	public static ArrayList<Integer> factorSums = new ArrayList<Integer>();
	public static boolean[] checked = new boolean[upperbound+1];
	
	public static int sumFactors(int n) {
	    
		int sum = 1;
		for(int i=2;i <= (int)(Math.sqrt(n)); i++){
	    	if(n%i == 0){
	         	sum += i;
	           	if(i != n/i){sum += n/i;}
	       	}
	   	}
	    return sum;
	}
	
	public static void main(String[] args) {
		
		for(int n=0; n<=upperbound; n++) {
			factorSums.add(sumFactors(n));
		}
		
		for(int i=0; i<=upperbound; i++) {
			int j = factorSums.get(i);
			if(j <= upperbound && checked[i] == false && checked[j] == false && j!=i) {
				checked[i] = true; 
				checked[j] = true;
				if(i == factorSums.get(j)) {
					System.out.println("(" + i+ "," + factorSums.get(i) + ")");
				}
			}
		}
	}
}

