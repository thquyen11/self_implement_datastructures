package princeton.algorithms;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int size;
	private int width;
	private int[] open;
	private WeightedQuickUnionUF uf;

	// create n-by-n grid, with all sites blocked
	// My approach is flatten the 2D sites to 1D array
	public Percolation(int N) {
		size = N * N;
		width = N;
		open = new int[size];
		uf = new WeightedQuickUnionUF(size + 2);
	}
	
	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		int index = ijTo1D(row, col);
		open[index]=1;
	}
	
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		int index  = ijTo1D(row, col);
		return open[index]==1;
	}
	
	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		return true;
	}
	
	// number of open sites
	public int numberOfOpenSites() {
		
	}
	
	// does the system percolate?
	public boolean percolates() {
		
	}
	
	// Convert open[i, j] 1-based to 1D array 0-based
	public int ijTo1D(int row, int col) {
		return (row-1)*width + (col-1);
	}
	
	public static void main(String[] args) {
		// test client (optional)

	}

}
