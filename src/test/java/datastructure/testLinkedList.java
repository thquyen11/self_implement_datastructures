package datastructure;

import datastructure.qLinkedList;

public class testLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qLinkedList list = new qLinkedList();
		
		list.add("hello");
		list.add("world");
		list.add("Quyen");
		
//		System.out.printf("list size is: %d\n", list.getSize());
//		System.out.printf("Is Empty: %s\n", list.isEmpty());
//		
//		list.remove(2);
//		list.removeAll();
		
		list.reverse();
		list.display();
	}

}
