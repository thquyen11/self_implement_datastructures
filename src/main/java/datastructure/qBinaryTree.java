package datastructure;

public class qBinaryTree {

	private static class Node {
		Integer value;
		Node leftNode;
		Node rightNode;

		Node(Integer value) {
			this.value = value;
			leftNode = null;
			rightNode = null;
		}
	}

	private Node root;

	public qBinaryTree() {
		root = null;
	}

	public boolean insert(Integer value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}

		Node findNode = root;

		while (true) {
			if (value > findNode.value) {
				if (findNode.rightNode == null) {
					Node insertNode = new Node(value);
					findNode.rightNode = insertNode;
					return true;
				} else {
					findNode = findNode.rightNode;
				}
			} else if (value < findNode.value) {
				if (findNode.leftNode == null) {
					Node insertNode = new Node(value);
					findNode.leftNode = insertNode;
					return true;
				} else {
					findNode = findNode.leftNode;
				}
			} else {
				System.out.println("Value exist in the BinaryTree");
				return false;
			}
		}

	}

	public boolean lookup(Integer lookupValue) {
		if (root == null)
			return false;

		Node findNode = root;
		while (findNode != null) {
			if (lookupValue > findNode.value) {
				findNode = findNode.rightNode;
				continue;
			} else if (lookupValue < findNode.value) {
				findNode = findNode.leftNode;
				continue;
			} else
				return true;
		}

		return false;
	}

	
	public boolean remove(Integer value) {
		
		// remove value is the root
		if (value == root.value) {
			root = null;
			return true;
		}

		Node currentNode = root;
		Node parrentNode = root;

		while (currentNode != null) {
			// search to the right of Node
			if (value > currentNode.value) {
				parrentNode = currentNode;
				currentNode = currentNode.rightNode;
				continue;
			} 
			// search to the left of Node
			else if (value < currentNode.value) {
				parrentNode = currentNode;
				currentNode = currentNode.leftNode;
				continue;
			} 
			// found the Node. Now we have 3 cases of removing Node
			else {
				// Case1: No right child. Attach directly the child of removed node to the parent node
				if (currentNode.rightNode == null) {
					// removed node is the right child of parent node
					if (parrentNode.rightNode.value == value) {
						parrentNode.rightNode = currentNode.leftNode;
					} 
					// removed node is the left child of parent node
					else {
						parrentNode.leftNode = currentNode.leftNode;
					}
				}

				// Case2: No left child. Attach directly the child of removed node to the parent node
				if (currentNode.leftNode == null) {
					// removed node is the right child of parent node
					if (parrentNode.rightNode.value == value) {
						parrentNode.rightNode = currentNode.rightNode;
					} 
					// removed node is the left child of parent node
					else {
						parrentNode.leftNode = currentNode.rightNode;
					}
				}

				// Case3: Have right + left child
				// Remove node by connect right child to parrentNode. Find the deepest left of
				// right child and connect it to th left child
				if (parrentNode.leftNode.value == value) {
					parrentNode.leftNode = currentNode.rightNode;

					// traverse right child sub-tree to find the deepest left node
					Node findNode = currentNode.rightNode;
					while (findNode.leftNode != null) {
						findNode = findNode.leftNode;
					}
					findNode.leftNode = currentNode.leftNode;
				} else {
					parrentNode.rightNode = currentNode.rightNode;

					// traverse right child sub-tree to find the deepest left node
					Node findNode = currentNode.rightNode;
					while (findNode.leftNode != null) {
						findNode = findNode.leftNode;
					}
					findNode.leftNode = currentNode.leftNode;
				}

				return true;
			}
		}

		return false;

	}

}
