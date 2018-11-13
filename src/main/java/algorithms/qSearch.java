package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.qBinaryTree;
import datastructure.qBinaryTree.Node;

public class qSearch {

	
	/**
	 * @BreadFirstSearch
	 * @Implement:
	 * Traverse every nodes of Tree in horizontal direction, start from Root node
	 * Store node's child in the queue. Then loop through the queue to check each node's value
	 * If found search value => return true
	 */
	public static boolean breadFirstSearch(qBinaryTree tree, Integer search) {
		Queue<Node> queueOfNodes = new LinkedList<>();
//		List<Integer> listOfValues = new ArrayList<>();		
		Node currentNode;
		
		queueOfNodes.add(tree.getRoot());
		
		while(!queueOfNodes.isEmpty()) {
			currentNode = queueOfNodes.poll();
//			listOfValues.add(currentNode.getValue());
			if(currentNode.getValue()==search) {
				return true;
			}
			
			if(currentNode.getLeftNode()!=null) {
				queueOfNodes.add(currentNode.getLeftNode());
			}
			
			if(currentNode.getRightNode()!=null) {
				queueOfNodes.add(currentNode.getRightNode());
			}
		}
		
		return false;
	}
}
