package base.datastructure;

import base.datastructure.qPriorityQueue;

public class testPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qPriorityQueue priorityQueue = new qPriorityQueue();
		
		priorityQueue.enQueue("Sumit", 2); 
		priorityQueue.enQueue("Gourav", 1); 
		priorityQueue.enQueue("Piyush", 1); 
		priorityQueue.enQueue("Sunny", 2); 
		priorityQueue.enQueue("Sheru", 3); 
		
		System.out.println(priorityQueue.toString());
		
		// remove Gourav
		priorityQueue.deQueue();
		System.out.println(priorityQueue.toString());
		
		// remove Sheru
		priorityQueue.rear();
		System.out.println(priorityQueue.toString());

	}

}
