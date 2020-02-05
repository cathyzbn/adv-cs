import edu.princeton.cs.algs4.StdIn;

public class test_package {
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
//		UF uf = new UF(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			System.out.println(p + ", " + q);
		}
	}
}
