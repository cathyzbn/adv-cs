import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private final double trialsNum;
	private final double mean;
	private final double stddev;
	private final double CONFIDANCE_95 = 1.96;

	public PercolationStats(int n, int trials) {
		trialsNum = (double) trials;
		if (n < 1 || trials < 1) throw new IllegalArgumentException();
	    double [] data = new double[trials];
	    for (int i = 0; i < trials; i++) {
		    Percolation p = new Percolation(n);
    	    while (!p.percolates()) p.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));
    		data[i] = (double) p.numberOfOpenSites() / (n*n);
//    		System.out.println(p.numberOfOpenSites());
    	}
    	mean = StdStats.mean(data);
    	stddev = StdStats.stddev(data);
    	
    }

    public double mean() {
    	return mean;
    }

    public double stddev() {
    	return stddev;
    }

    public double confidenceLo() {
    	return mean - CONFIDANCE_95 * stddev / Math.sqrt(trialsNum);
    }

    public double confidenceHi() {
    	return mean + CONFIDANCE_95 * stddev / Math.sqrt(trialsNum);
    }

    public static void main(String[] args) {
	   int n = Integer.parseInt(args[0]);
	   int trials = Integer.parseInt(args[1]);
//	   int n=10;
//	   int trials=10;
       PercolationStats p = new PercolationStats(n, trials);
       String confidence = p.confidenceLo() + ", " + p.confidenceHi();
       StdOut.println("mean                    = " + p.mean());
       StdOut.println("stddev                  = " + p.stddev());
       StdOut.println("95% confidence interval = " + confidence);
   }
   	
}