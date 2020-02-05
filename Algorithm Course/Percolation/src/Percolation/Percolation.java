import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int count;
    private final int num;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF uf2;
    private final int source;
    private final int sink;
    private boolean[] openArray;
    private final boolean percolates;

    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException();
    	num = n;
    	openArray = new boolean[num * num+2];
    	uf = new WeightedQuickUnionUF(num * num+2);
    	uf2 = new WeightedQuickUnionUF(num*num+1);
    	source = 0;
    	sink = num * num + 1;
    	count = 0;
    	percolates = false;
    }

    public void open(int row, int col) {
        if (row < 1 || row > num || col < 1 || col > num) throw new IllegalArgumentException();
        if (!isOpen(row, col)) {
            int index = index(row, col);
            openArray[index] = true;
            count += 1;
            if (row == 1) {
                uf.union(index, source);
                uf2.union(index, source);
            }
            if (row == num) uf.union(index, sink);
            if (row > 1 && isOpen(row - 1, col)) {
    		    uf.union(index, index(row-1, col));
    		    uf2.union(index, index(row-1, col));
    		}
        	if (row < num && isOpen(row + 1, col)) {
        	    uf.union(index, index(row+1, col));
        	    uf2.union(index, index(row+1, col));
        	}
        	if (col > 1 && isOpen(row, col - 1)) {
        	    uf.union(index, index(row, col-1));
        	    uf2.union(index, index(row, col-1));
        	}
        	if (col < num && isOpen(row, col + 1)) {
        	    uf.union(index, index(row, col+1));
        	    uf2.union(index, index(row, col+1));
        	}
    	}
    }

    public boolean isOpen(int row, int col) {
    	if (row < 1 || row > num || col < 1 || col > num) throw new IllegalArgumentException();
    	return openArray[index(row, col)];
    }

    public boolean isFull(int row, int col) {
    	if (row < 1 || row > num || col < 1 || col > num) throw new IllegalArgumentException();
    	return uf2.connected(index(row, col), source);
    }

    public int numberOfOpenSites() {
    	return count;
    }

    public boolean percolates() {
        if(percolates) return true;
        else return uf.connected(source, sink);
    }
    
    private int index(int row, int col) {
    	return (row-1)*num+col;
    }

    public static void main(String[] args) {
    	// comment
    }
    
}