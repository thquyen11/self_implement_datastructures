package datastructure;

public class qLinkedList {

	private Node firstNode;
	private Node lastNode;
	private int linkedListIndex;
	
	public qLinkedList() {
		firstNode = null;
		lastNode = null;
		linkedListIndex = -1;
	}
	
	public void add(String data) {
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
		
		display();
	}
	
	public void remove(int deleteIndex) {
		try {
			if(deleteIndex > linkedListIndex) {
				throw new IndexOutOfBoundsException();
			} else if (firstNode == null) {
				System.out.println("The linkedList is empty");
				return;
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
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Input index is bigger than LinkedList size");
		}
		
		display();
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
	
	private static class Node {
		private String data;
		private Node nextNode;

		public Node(String data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	
	}
}
