import java.util.ArrayList;

public class LineList {
	private ArrayList<String> list;
	
	public LineList() {
		list = new ArrayList <String>();
	}
	
	public int size() {
		return list.size();
	}
	
	public String get(int k) {
		return list.get(k);
	}
	
	public void add(String line) {
		list.add(line);
	}
	
	public String remove(int k) {
		String output = list.get(k);
		list.remove(k);
		return output;
	}
	
	public void move(int index, int newIndex) {
		String line = list.get(index);
		list.remove(index);
		list.add(newIndex, line);
	}
	
	public void shuffle() {
		int n = list.size();
		for(int i=n; i>=2; i--) {
			int rand = (int) (Math.random()*i);
			String temp = list.get(i-1);
			list.set(i-1, list.get(rand));
			list.set(rand, temp);
		}
	}

	public static void main(String[] args) {
		
		LineList test = new LineList();
		
		System.out.println("here's the initial size:" + test.size());
		
		test.add("line 1");
		System.out.println("here's the first addition:" + test.list.toString());
		
		test.add("line 2");
		test.add("line 3");
		test.add("line 4");
		test.add("line 5");
		test.add("line 6");
		test.add("line 7");
		System.out.println("here's the seven additions:" + test.list.toString());
		
		System.out.println("here's the size:" + test.size());
		
		System.out.println("here's the 1st line: " + test.get(0));
		System.out.println("here's the 3st line: " + test.get(2));
		System.out.println("here's the 7st line: " + test.get(6));
		
		test.remove(3);
		System.out.println("here's after removing line 4: " + test.list.toString());
		
		test.move(5, 3);
		System.out.println("here's moving line 7 to originally line 4: " +  test.list.toString());
		
		test.shuffle();
		System.out.println("here's after its shuffled: " + test.list.toString());
		
	}
	
}
