package algorithms;

import datastructure.qBinaryTree;

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
		
		System.out.println(qSearch.breadFirstSearch(tree, 4));;
		System.out.println(qSearch.breadFirstSearch(tree, 100));

	}

}
