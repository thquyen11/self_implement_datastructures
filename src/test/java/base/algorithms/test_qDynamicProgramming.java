package base.algorithms;

import base.algorithms.qDynamicProgramming;

public class test_qDynamicProgramming {

	public static void main(String[] args) {
		qDynamicProgramming cal = new qDynamicProgramming();
		
		// Recursive test
//		cal.FibonaciR(20);
//		System.out.println(cal.getNumberOfCalculation);

		// Dynamic programming test
		cal.FibonaciD(10);
		System.out.println(cal.getNumberOfCalculation());
	}

}
