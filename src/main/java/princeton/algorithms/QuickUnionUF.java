package princeton.algorithms;

/**
 * @author QuyenH
 * @Implement: https://www.coursera.org/learn/algorithms-part1/lecture/ZgecU/quick-union
 */
public class QuickUnionUF {
	private int[] network;
	
	public QuickUnionUF(int numberOfVertex) {
		network = new int[numberOfVertex];
		for (int i = 0; i < numberOfVertex; i++) {
			network[i] = i;
		}
	}
	
	/**
	 * Two vertex is connected if they have the same root
	 */
	public boolean connected(int firstVertex, int secondVertex) {
		return root(firstVertex) == root(secondVertex);
	}

	private int root(int vertex) {
		while(vertex != network[vertex]) {
			vertex = network[vertex];
		}
		return vertex;
	}
	
	/**
	 * assign secondVertex's root to be the root of firstVertex's root
	 */
	public boolean union(int firstVertex, int secondVertex) {
		network[root(firstVertex)] = root(secondVertex);
		return true;
	}	
}
