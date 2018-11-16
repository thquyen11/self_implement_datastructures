package princeton.algorithms;

/**
 * @author QuyenH
 * @Implement: Flatten the graph to a 1-dimension array, with each vertex is an
 *             element of array Two vertexes are connected if their array's
 *             elements have the same value
 */
public class QuickFindUF {
	private int[] network;

	public QuickFindUF(int numberOfVertex) {
		network = new int[numberOfVertex];
		for (int i = 0; i < numberOfVertex; i++) {
			network[i] = i;
		}
	}

	/**
	 * Verify if 2 vertexes are connected or not?
	 */
	public boolean connected(int firstVertex, int secondVertex) {
		return network[firstVertex] == network[secondVertex];
	}

	/**
	 * connect 2 vertexes of the network
	 */
	public boolean union(int firstVertex, int secondVertex) {
		// modify all the value in firstVertex's network to secondVertex's value
		for (int i = 0; i < network.length; i++) {
			if (network[i] == firstVertex) {
				network[i] = network[secondVertex];
			}
		}
		return true;
	}
}
