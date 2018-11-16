package base.algorithms;

import java.util.ArrayList;
import java.util.List;

import base.algorithms.qSorting;

public class test_qSorting {

	public static void main(String[] args) {
		
		// Bubble Sort
		Integer[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
//		qSorting.bubbleSort(array);
		
		// Selection Sort
//		qSorting.selectionSort(array);
//		System.out.println("Sorted");
		
		// Insertion Sort
//		qSorting.insertionSort(array);
//		System.out.println("Sorted");
		
		// Merge Sort
		List<Integer> arrayMergeSort = new ArrayList<>();
		arrayMergeSort.add(99);
		arrayMergeSort.add(44);
		arrayMergeSort.add(6);
		arrayMergeSort.add(2);
		arrayMergeSort.add(1);
		arrayMergeSort.add(5);
		arrayMergeSort.add(63);
		arrayMergeSort.add(87);
		arrayMergeSort.add(283);
		arrayMergeSort.add(4);
		arrayMergeSort.add(0);
		arrayMergeSort.add(99);
//		arrayMergeSort=qSorting.mergeSort(arrayMergeSort);
//		System.out.println("Sorted");
		
		// Quick Sort
		arrayMergeSort=qSorting.quickSort(arrayMergeSort, 0, arrayMergeSort.size()-1);
		System.out.println("Sorted");

	}

}
