package base.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import base.datastructure.qBinaryTree;
import base.datastructure.qBinaryTree.Node;

public class qSearch {
	
	/**
	 * @BreadFirstSearch
	 * @Implement:
	 * 		9
	 * 	4		20
	 * 1  6   15   170
	 * 
	 * result = [9, 4, 20, 1, 6, 15, 170]
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
	
	/**
	 * @traverseInOrder
	 * @Implement:
	 * 		9
	 * 	4		20
	 * 1  6   15   170
	 * 
	 * result = [1, 4, 6, 9, 15, 20, 170]
	 */
	public static List<Integer> traverseInOrder(Node node, List<Integer> result) {
		
		// traverse to the left
		if(node.getLeftNode()!=null) {
			traverseInOrder(node.getLeftNode(), result);
		}
		
		// add the node.value into result List
		result.add(node.getValue());
		
		// traverse to the right
		if(node.getRightNode()!=null) {
			traverseInOrder(node.getRightNode(), result);
		}
		
		return result;		
	}
	
	
	/**
	 * @traversePreOrder
	 * @Implementation
	 * 		9
	 * 	4		20
	 * 1  6   15   170
	 * 
	 * result = [9, 4, 1, 6, 20, 15, 170]
	 */
	public static List<Integer> traversePreOrder(Node node, List<Integer> result){
		
		result.add(node.getValue());
		
		if(node.getLeftNode()!=null) {
			traversePreOrder(node.getLeftNode(), result);
		}
		
		if(node.getRightNode()!=null) {
			traversePreOrder(node.getRightNode(), result);
		}
		
		return result;
	}
	
	/**
	 * @traversePostOrder
	 * @Implementation
	 * 		9
	 * 	4		20
	 * 1  6   15   170
	 * 
	 * result = [1, 6, 4, 15, 170, 20, 9]
	 */
	public static List<Integer> traversePostOrder(Node node, List<Integer> result){
		
		if(node.getLeftNode()!=null) {
			traversePostOrder(node.getLeftNode(), result);
		}
		
		if(node.getRightNode()!=null) {
			traversePostOrder(node.getRightNode(), result);
		}
		
		result.add(node.getValue());
		
		return result;
	}
	
}
