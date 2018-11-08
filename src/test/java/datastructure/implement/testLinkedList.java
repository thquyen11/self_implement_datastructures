package datastructure.implement;

public class testLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		
		list.add("hello");
		list.add("world");
		list.add("Quyen");
		
		System.out.printf("list size is: %d\n", list.getSize());
		System.out.printf("Is Empty: %s\n", list.isEmpty());
		
		list.remove(2);
//		list.remove(2);
		list.removeAll();
	}

}
