import java.util.ArrayList;

public class RemoveDuplicates {

	public static void removeDuplicates(ArrayList<String> list) {
		ArrayList<String> output = new ArrayList<String>();
		for(String item:list) {
			if(!output.contains(item)){output.add(item);}
		}
		list.clear();
		list.addAll(output);
	}
	
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("d");
		System.out.println(list);
		removeDuplicates(list);
		System.out.println(list);
	}
}
