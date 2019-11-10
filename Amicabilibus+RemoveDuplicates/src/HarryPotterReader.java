import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HarryPotterReader {
	
	public static void main(String[] args) {
		
		Map<String, Integer> counted = countDuplicates(readFile("harry_potter.txt"));
		LinkedHashMap<String, Integer> sorted = sort(counted);
		
		for(String key: sorted.keySet()) {
			System.out.println(key + " : " + sorted.get(key));
		}
	}
	
	public static ArrayList<String> readFile(String fileName) {
		
		ArrayList<String> keys= new ArrayList<String>();
		
		try {
			
			Scanner s = new Scanner(new File(fileName));
			System.out.println("File is open");
			
			while(s.hasNext()) {
				
				String newWord = s.next();
				newWord = trimIt(newWord);
				
				if(newWord != "") {
					keys.add(newWord);
				}
			}
			s.close();
			
		}catch(Exception e) {
			
			System.out.println("Problem...");
		}
		
		return keys;
		
	}
	
	public static HashMap<String, Integer> countDuplicates(ArrayList<String> keys){
		
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		
		for(String key:keys) {
			if(dictionary.containsKey(key)) {
				dictionary.put(key, dictionary.get(key) +1);
			}else {
				dictionary.put(key, 1);
			}
			
		}
		
		return dictionary;
		
	}
	
	
	public static String trimIt(String word) {
		
		word = word.toLowerCase();
		final int upperLimit = 122, lowerLimit = 97;
		
		int firstIndex = 0;
		int lastIndex = word.length()-1;
		
		boolean isWord = false;
		/*this is to solve a problem that comes up since 
		 *if there is no letters then the the firstIndex goes to length()
		 *and the lastIndex goes to 0 and it cannot be sliced.
		 */
		for(char ch : word.toCharArray()) {
			if(ch>=lowerLimit && ch<=upperLimit) {
				isWord = true;
			}
		}
		
		if(isWord) {
			while(word.charAt(firstIndex)<lowerLimit || word.charAt(firstIndex)>upperLimit) {
				firstIndex ++;
			}
			while(word.charAt(lastIndex)<lowerLimit || word.charAt(lastIndex)>upperLimit) {
				lastIndex --;
			}
			return word.substring(firstIndex, lastIndex+1);
		}else {
			return "";
		}
		
		
	}
	
	public static LinkedHashMap<String, Integer> sort(Map<String, Integer> unsorted) {
		//function adapted from https://howtodoinjava.com/sort/java-sort-map-by-values/
		LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
		unsorted.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
	    .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
		return sorted;
	}
}

