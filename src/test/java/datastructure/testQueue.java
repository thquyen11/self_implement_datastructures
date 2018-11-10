package datastructure;

import datastructure.qQueue;

public class testQueue {

	public static void main(String[] args) {
		qQueue testQueue = new qQueue(3);
		
		testQueue.insert("1");
		testQueue.insertPriority("priority");
		testQueue.insert("2");
//		testQueue.insert("3");
		
		testQueue.remove();
		testQueue.peek();
		

	}

}
