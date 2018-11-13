package datastructure;

public class testBinaryTree {

	public static void main(String[] args) {
		qBinaryTree tree = new qBinaryTree();
		
		tree.insert(22.0);
		tree.insert(23.0);
		tree.insert(24.0);
		tree.insert(25.0);
		tree.insert(26.0);
		tree.insert(27.0);
		tree.insert(30.0);
		tree.insert(28.0);
		tree.insert(31.0);
		
		tree.insert(30.0);
		
		System.out.println(tree.lookup(30.0));;
		System.out.println(tree.lookup(50.0));;
		
		System.out.println(tree.remove(24.0));
		System.out.println(tree.lookup(24.0));

	}

}
