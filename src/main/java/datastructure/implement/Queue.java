package datastructure.implement;

public class Queue {
	private String[] QueueArray;
	private int QueueSize, rear = 0;
	
	Queue(int size){
		QueueSize = size;
		rear = -1;
		QueueArray = new String[QueueSize];
	}
	
	public void insert(String input) {
		if((rear+1)<QueueSize) {
			QueueArray[++rear] = input;		
			displayQueue();
		} else {
			System.out.println("FATAL: Can't insert, Queue is full");
		}				
	}
	
	public void insertPriority(String input) {
		System.out.printf("INFO: Queue size %d\n", QueueSize);
		System.out.printf("INFO: Queue rear %d\n", rear);
		if((rear+1)<QueueSize) {
			for(int i=rear; i>=0; i--) {
				QueueArray[i+1]=QueueArray[i];
				rear++;
			}
			QueueArray[0]=input;
			displayQueue();
		} else {
			System.out.println("FATAL: Can't insert, Queue is full");
		}	
	}
	
	public String remove() {
		if(rear >0) {
			String removeItem = QueueArray[0];
			
//			Shift the queue to the left 1 element
			for(int i=0; i<rear; i++) {
				QueueArray[i] = QueueArray[i+1];
			}			
			QueueSize--;
			rear--;	
			displayQueue();
			return removeItem;
		} else if (rear == 0) {
			rear = -1;
			QueueSize=0;
			return QueueArray[rear+1];
		} else {
			System.out.println("FATAL: Can't remove, Queue is empty");
			return "-1";
		}
	}
	

	public String peek() {
		if(rear > -1) {
			System.out.printf("INFO: Peek value is %s\n", QueueArray[rear]);
			return QueueArray[rear];
		} else {
			System.out.println("FATAL: Can't peek, Queue is empty");
			return "-1";
		}
	}
	
	private void displayQueue() {
		System.out.println("Queue elements are: ");
		for(int i=0; i<=rear; i++) {
			System.out.printf("%s | ", QueueArray[i]);
		}
		System.out.println();
		
	}
}
