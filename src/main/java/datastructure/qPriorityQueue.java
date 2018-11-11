package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thquy
 * @implementation: based on Array, each elements contains 2 properties: values , priority
 * Highest priority is 1
 * Method enQueue() put high priority element to the left
 * Method deQueue() remove the highest priority element (very first left of the array)
 * Method rear() remove the lowest priority element
 */
public class qPriorityQueue {
	
	private static class Element{
		String value;
		int priority;
		
		Element(String value, int priority){
			this.value=value;
			this.priority=priority;
		}
	}
	
	private List<Element> queue;
	
	public qPriorityQueue() {
		this.queue = new ArrayList<>();
	}
	
	public boolean enQueue(String value, int priority) {
		Element insertElement = new Element(value, priority);
		
		if(queue.isEmpty()) {
			queue.add(insertElement);
			return true;
		}
		
		for(int i=0; i<queue.size(); i++) {
			// Because highest priority is 1
			// Insert new element into the left of element that has Priority value higher (less priority)
			if(queue.get(i).priority > insertElement.priority) {
				queue.add(i, insertElement);
				return true;
			}
		}
		queue.add(insertElement);
		
		return true;
	}
	
	public boolean deQueue() {
		if(queue.isEmpty()) {
			System.out.println("Empty PriorityQueue");
			return false;
		}
		
		queue.remove(0);
		return true;
	}
	
	public boolean rear() {
		if(queue.isEmpty()) {
			System.out.println("Empty PriorityQueue");
			return false;
		}
		
		queue.remove(queue.size()-1);
		return true;
	}

}
