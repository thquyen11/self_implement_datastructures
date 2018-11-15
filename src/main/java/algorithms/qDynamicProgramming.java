package algorithms;

import java.util.HashMap;
import java.util.Map;

// Use Fibonacci problem, I will demonstrate the pros of dynamic over recursive
// Case1: recursive, a lot of calculation O(2^n)
// Case2: dynamic programming, magically reduce the complexity to O(n)
public class qDynamicProgramming {
	private static int numberOfCalculation;
	private static Map<Integer, Integer> memo;
	
	public qDynamicProgramming() {
		numberOfCalculation=0;
		memo = new HashMap<>();
	}

	// Recursive, consume a lot of memory O(2^n)
	public static Integer FibonaciR(int n) {
		// 0-based array
		// recursive base case
		if (n < 2) {
			return n;
		}
		
		numberOfCalculation++;

		return FibonaciR(n - 1) + FibonaciR(n - 2);
	}

	// Dynamic programming O(n)
	public static Integer FibonaciD(int n) {
		if(memo.containsKey(n)) {
			return memo.get(n);
		} else {
			if (n < 2) {
				memo.put(n, n);
				return memo.get(n);
			}
			
			memo.put(n, FibonaciR(n - 1) + FibonaciR(n - 2));	
			return memo.get(n);
		}				
	}

	public static int getNumberOfCalculation() {
		return numberOfCalculation;
	}

	public static void setNumberOfCalculation(int numberOfCalculation) {
		qDynamicProgramming.numberOfCalculation = numberOfCalculation;
	}
	
	
}
