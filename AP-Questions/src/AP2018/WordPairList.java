package AP2018;

import java.util.ArrayList;

public class WordPairList {
	
	ArrayList<WordPair> allPairs = new ArrayList<WordPair>();
	
	public WordPairList(String[] word) {
		
		for(int i=0; i<word.length-1; i++) {
			for(int j=i+1; j<word.length; j++) {
				allPairs.add(new WordPair(word[i], word[j]));
			}
		}
	}
	
	public int numMatches() {
		
		int count = 0;
		for(WordPair pair:allPairs) {
			if(pair.getFirst()==pair.getSecond()) {count+=1;} 
		}
		return count;
	}
}
