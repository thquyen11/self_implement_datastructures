package base.algorithms;

import java.util.ArrayList;
import java.util.List;

import base.algorithms.qSearch;
import base.datastructure.qBinaryTree;

public class test_qSearch {

	public static void main(String[] args) {
		// BFS
		qBinaryTree tree = new qBinaryTree();
		tree.insert(9);
		tree.insert(4);
		tree.insert(6);
		tree.insert(20);
		tree.insert(170);
		tree.insert(15);
		tree.insert(1);
		
//		System.out.println(qSearch.breadFirstSearch(tree, 4));;
//		System.out.println(qSearch.breadFirstSearch(tree, 100));
		
		// InOrder
		List<Integer> result = new ArrayList<>();
//		qSearch.traverseInOrder(tree.getRoot(), result);
				
		// PreOrder
//		qSearch.traversePreOrder(tree.getRoot(), result);
		
		// PostOrder
		qSearch.traversePostOrder(tree.getRoot(), result);
		
		// print traverse result
		for (Integer element : result) {
			System.out.print(element+" ");		
		}
		System.out.println();
	}

}
