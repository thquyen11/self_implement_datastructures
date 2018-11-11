package datastructure;

/**
 * @author thquy
 *
 */
public class qLinkedList {

	private Node firstNode;
	private Node lastNode;
	private int linkedListIndex;
	
	public qLinkedList() {
		firstNode = null;
		lastNode = null;
		linkedListIndex = -1;
	}
	
	public boolean add(String data) {
		if(firstNode == null) {
			firstNode = new Node(data, null);
			linkedListIndex++;
			lastNode = firstNode;
		} else {
			Node temp = new Node(data, null);
			lastNode.nextNode = temp;
			lastNode = temp;
			linkedListIndex++;
		}
		return true;
	}
	
	public boolean add(String data, int index) {
		if(index>linkedListIndex) {
			System.out.println("Index out of LinkedList's length");
			return false;
		}
		
		Node insertNode = new Node(data, null);
		Node currentNode = firstNode;
		for(int i=1; i<index; i++) {
			currentNode = currentNode.nextNode;
		}		
		insertNode.nextNode = currentNode.nextNode;
		currentNode.nextNode= insertNode;	
		linkedListIndex++;
		return true;
	}
	
	public boolean remove(int deleteIndex) {
		try {
			if(deleteIndex > linkedListIndex) {
				throw new IndexOutOfBoundsException();
			} else if (firstNode == null) {
				System.out.println("The linkedList is empty");
				return false;
			} else {
				Node findNode = firstNode;
				for(int i=0; i<=deleteIndex;i++) {
					if(i<deleteIndex-1) {
						findNode=findNode.nextNode;
					} else {
						if(deleteIndex==linkedListIndex) {
							findNode.nextNode=null;
							lastNode=findNode;
							linkedListIndex--;
						} else {
							findNode.nextNode = findNode.nextNode.nextNode;
							linkedListIndex--;
						}
						break;
					}
				}
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Input index is bigger than LinkedList size");
			return false;
		}
		
	}
	
	public void removeAll() {
		firstNode = null;
		linkedListIndex = -1;
		display();
	}
	
	public boolean isEmpty() {
		return firstNode == null ? true : false;
	}
	
	public int getSize() {
		return linkedListIndex+1;
	}
	
	public void display() {
		Node findNode = firstNode;
		for(int i=0; i<= linkedListIndex;i++) {
			System.out.printf("%s | ", findNode.data);
			if(findNode!=lastNode) {
				findNode = findNode.nextNode;
			} else {
				break;
			}
		}
		System.out.println();
	}
	
	
	/**
	 * @reverse the Linked List
	 * How-it-work: for example LinkedList structure is: Node1 -- Node2 -- Node3
	 * 1st: start with Node1, Node2: assign Node3 to a tempNode. Reverse the linkedlist direction by assign Node2.nextNode = Node1, Node1.nextNode = null.
	 * The reason we have to assig Node3 to tempNode in order to keep Node3's address, because the only link to Node3 is Node2.nextNode will be assigned to Node1.
	 * 2nd: repeat with Node2, Node3 and so on
	 */
	public Node reverse() {
		if(this.firstNode.nextNode==null) {
			return this.firstNode;
		}
		
		Node first = this.firstNode;
		Node second = this.firstNode.nextNode;
		this.lastNode=first;
		
		while(second!=null) {
			Node temp = second.nextNode;
			second.nextNode=first;
			first=second;
			second=temp;
		}
		
		this.firstNode.nextNode=null;
		this.firstNode=first;
		
		return this.firstNode;
	}
	
	private static class Node {
		private String data;
		private Node nextNode;

		public Node(String data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	
	}
}
