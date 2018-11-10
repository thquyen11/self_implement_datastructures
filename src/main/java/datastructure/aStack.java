package datastructure;

import java.util.Arrays;

/**
 * @author QuyenH
 * Basic Stack implementation based on String array
 */
public class aStack {

	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	
	aStack(int size){
		stackSize = size;
		stackArray = new String[size];
//		Assign value to control the stack's data, avoid garbage value from memory
		Arrays.fill(stackArray, "-1");
	}
	
	/**
	 * @param input
	 * @return 0: success ; 1: fail
	 */
	public int push(String input) {
		if(topOfStack + 1 >= stackSize) {
			System.out.println("FATAL: Stack is full");
			return 1;
		} else {
			stackArray[topOfStack+1] = input;
			topOfStack++;
			System.out.printf("INFO: %s added to Stack\n", input);
			return 0;
		}
	}
	
	
	/**
	 * @return stack's element
	 * Remove that element out of Stack by decrease stack size
	 * The underlying array's size is not changed
	 */
	public String pop() {
		if(topOfStack == -1) {
			System.out.println("FATAL: Can't pop, Stack is empty");
			return "1";
		} else {
			stackSize--;
			return stackArray[topOfStack--];
		}
	}
	
	public void popAll() {
		for(int i=topOfStack; i>=0; i--) {
			pop();
		}
	}
	
	/**
	 * @return stack's element
	 * Diff. to pop(): Not remove element out of Stack
	 */
	public String peek() {
		if(topOfStack == -1) {
			System.out.println("FATAL: Can't peek, Stack is empty");
			return "1";
		} else {
			return stackArray[topOfStack];
		}
	}
	
	public void displayStack() {
		if(topOfStack == -1) {
			System.out.println("FATAL: Stack is empty");
		} else {
			for (String item : stackArray) {
				System.out.printf("%s | ", item);
			}
			System.out.println();
		}
	}
	
	
	
}
