import java.util.ArrayList;
import java.util.Arrays;

public class Activity3Questions {
	
	public static void main(String[] args) {
		
//		System.out.println(flip());
//		System.out.println(flip());
//		System.out.println(flip());
//		System.out.println(flip());
//		System.out.println(flip());
//		System.out.println(flip());
		
		int[] a1 = {1, 2, 3};
		int[] a2 = {3, 1, 2};
		int[] a3 = {2, 4, 1};
		System.out.println(arePermutations(a1, a2));
		System.out.println(arePermutations(a1, a3));
		
	}	
	
	public static String flip() {
		
		String[] choices = {"Head", "Head", "Tail"};
		int rand = (int)(Math.random() * 3);
		return choices[rand];
        
	}
	
	
	public static boolean arePermutations(int[] array1, int[] array2) {
		
		for(int element: array1) {
			
			boolean contains = false;
			
			for(int i=0; i<array2.length; i++) {
				if(element == array2[i]) {contains = true;}
			}
			
			if(contains == false) {return false;}
			
		}
		return true;
	}
	
}
