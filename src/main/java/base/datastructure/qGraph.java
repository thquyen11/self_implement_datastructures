package base.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Graph
 * @Implement:
 * Using a HashMap with
 * * Key: graph' vertex
 * * Value: List of other vertexs connect to it
 */
public class qGraph {
	private Map<String, List<String>> adjacentList;
	private int numberOfNodes;
	
	public qGraph() {
		adjacentList = new HashMap<>();
		numberOfNodes = 0;
	}
	
	public boolean addVertex(String node) {
		try {
			adjacentList.put(node, new ArrayList<>());
			numberOfNodes++;
		} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
		
		return true;		
	}
	
	public boolean addEdge(String node1, String node2) {
		// un-directed Graph
		try {
			adjacentList.get(node1).add(node2);
			adjacentList.get(node2).add(node1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Map<String, List<String>> getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(Map<String, List<String>> adjacentList) {
		this.adjacentList = adjacentList;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}
	
}
