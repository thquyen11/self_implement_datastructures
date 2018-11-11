package datastructure;

import datastructure.qStack;

public class testStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qStack testStack = new qStack(5);
		
		testStack.pop();
		testStack.peek();
		
		testStack.push("1");
		testStack.push("2");
		testStack.push("3");
		testStack.push("4");
		testStack.push("5");
		
		testStack.peek();
		System.out.printf("Pop element %s\n", testStack.pop());
		testStack.displayStack();
		
		testStack.popAll();
		testStack.pop();
		
		

	}

}
