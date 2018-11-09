package datastructure;

import datastructure.Queue;

public class testQueue {

	public static void main(String[] args) {
		Queue testQueue = new Queue(3);
		
		testQueue.insert("1");
		testQueue.insertPriority("priority");
		testQueue.insert("2");
//		testQueue.insert("3");
		
		testQueue.remove();
		testQueue.peek();
		

	}

}
