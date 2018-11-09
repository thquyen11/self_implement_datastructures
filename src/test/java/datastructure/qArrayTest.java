package datastructure;

import algorithms.qArray;

public class qArrayTest {

	public static void main(String[] args) {
		Integer[] array1 = {0,3,4,31};
		Integer[] array2 = {3,4,6,30};
		
		Integer[] output = qArray.merge(array1, array2);
//		for (Integer item : output) {
//			System.out.println(item);
//		}
//		
		output = qArray.insertionSort(output);		
		for (Integer item : output) {
			System.out.println(item);
		}
	}

}
