import java.util.ArrayList;

public class RemoveDuplicates {

	public static void removeDuplicates(ArrayList<String> list) {
		
		ArrayList<String> visited = new ArrayList<String>();
		
		for(int i=0; i<list.size(); i++) {
			
			String current = list.get(i);
			if(visited.contains(current)){list.remove(i);i--;}
			else {visited.add(current);}
			
		}
	}
;	
	
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("e");
		list.add("d");
		System.out.println(list);
		removeDuplicates(list);
		System.out.println(list);
	}
}
