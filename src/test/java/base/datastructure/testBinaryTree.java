package base.datastructure;

import base.datastructure.qBinaryTree;

public class testBinaryTree {

	public static void main(String[] args) {
		qBinaryTree tree = new qBinaryTree();
		
		tree.insert(22);
		tree.insert(23);
		tree.insert(24);
		tree.insert(25);
		tree.insert(26);
		tree.insert(27);
		tree.insert(30);
		tree.insert(28);
		tree.insert(31);
		
		tree.insert(30);
		
		System.out.println(tree.lookup(30));;
		System.out.println(tree.lookup(50));;
		
		System.out.println(tree.remove(24));
		System.out.println(tree.lookup(24));

	}

}
