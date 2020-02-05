import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UF {
	
	private int[] sequence;
	private int count;
	
	public UF(int N) {
		
		sequence = new int[N];
		for(int i=0; i<N; i++) {
			sequence[i] = i;
		}
		count = N;
	}
	
	public void union(int p, int q) {
		sequence[get_root(p)] = get_root(q);
		count -= 1;
	}
	
	public int get_count() {
		return count;
	}
	
	public int get_root(int i) {
		
		while(i!= sequence[i]) {
			i = sequence[i];
		}
		sequence[i] = sequence[sequence[i]];
		return i;
	}
	
	public ArrayList<ArrayList> get_connected_components() {
		
		ArrayList<ArrayList> sets = new ArrayList<ArrayList>();
		ArrayList<Integer> visited_nums = new ArrayList<Integer>();
		
		for(int i=0; i<sequence.length; i++) {
			int root = get_root(i);
			if(visited_nums.contains(root)) {
				sets.get(visited_nums.indexOf(root)).add(i);
			
			}else {
				ArrayList<Integer> set_to_add = new ArrayList<Integer>();
				set_to_add.add(i);
				sets.add(set_to_add);
				visited_nums.add(root);
			}
		}
		
		return sets;
	}
	
	public boolean is_connected(int p, int q) {
		return get_root(p) == get_root(q);
	}
	
	public static void main(String[] args) {
		
		try {
			Scanner s = new Scanner(new File("test.txt"));
			int N = s.nextInt();
			UF uf = new UF(N);
			System.out.println("N = " + N);
			
			while(s.hasNext()) {
				
				int p = s.nextInt();
				int q = s.nextInt();
				System.out.println("Pair: [" + p + ", " + q + "]");
				if(!uf.is_connected(p, q)) {
					uf.union(p, q);
				}
			}
			
			System.out.println("there are " + uf.get_count() + " connected components in this graph.");
			System.out.println("components are: " + uf.get_connected_components());
			
		}catch(Exception e){
			System.out.println("File opening issue");
		}
	
	}
}
