package algorithms;

import java.util.ArrayList;
import java.util.List;

public class qSorting {
	
	
	/**
	 * @implement: https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/v4/t/lecture/12406452?start=0 
	 */
	public static List<Integer> mergeSort(List<Integer> array){
		
		// Split until left/right array only have 1 element
		// Then start merge-sort the result
		if(array.size()==1) {
			return array;
		}
		
		// Split Array in into right and left
		int middle = array.size()/2;
		List<Integer> left = array.subList(0, middle);
		List<Integer> right = array.subList(middle, array.size());				
				
		return mergeMergeSort(mergeSort(left), mergeSort(right));	
	}
	
	private static List<Integer> mergeMergeSort(List<Integer> left, List<Integer> right) {	
		int leftIndex = 0;
		int rightIndex=0;
		List<Integer> result = new ArrayList<>();
		
		// compare left/right arrays' element
		// sort the value in ASC before insert into result array
		while(leftIndex<left.size() && rightIndex<right.size()) {
			if(left.get(leftIndex)<right.get(rightIndex)) {
				result.add(left.get(leftIndex));
				leftIndex++;
			} else {
				result.add(right.get(rightIndex));
				rightIndex++;
			}
		}
		
		// concat the remaining elements in left/right array into result array
		if(leftIndex < left.size()) {
			result.addAll(left.subList(leftIndex, left.size()));
		}		
		if(rightIndex < right.size()) {
			result.addAll(right.subList(rightIndex, right.size()));
		}
		
		return result;
		
	}
	
	
	public static List<Integer> quickSort(List<Integer> array){
		
		if(array.isEmpty() || array.size()==1) {
			return array;
		} else if (array.size()==2) {
			if(array.get(0)> array.get(1)) {
				Integer temp = array.get(0);
				array.set(0, array.get(1));
				array.set(1, temp);
			}	
			return array;
		}
		
		int pivotIndex = array.size()-1;
		List<Integer> left;
		List<Integer> right;
		
		for(int i=0;i<pivotIndex;i++) {
			if(array.get(i)>array.get(pivotIndex)) {
				Integer temp = array.get(pivotIndex-1);
				array.set(pivotIndex-1, array.get(pivotIndex));
				array.set(pivotIndex, array.get(i));
				array.set(i, temp);
				pivotIndex=pivotIndex-1;
			}
		}
		
		left = array.subList(0, pivotIndex);
		right = array.subList(pivotIndex+1, array.size());
		
		return mergeQuickSort(array.get(pivotIndex),quickSort(left), quickSort(right));	
	}
	
	private static List<Integer> mergeQuickSort(Integer pivotValue, List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<>();
		
		if(left.isEmpty()) {
			result.add(pivotValue);
			result.addAll(right);
		} else if(right.isEmpty()) {
			result.addAll(left);
			result.add(pivotValue);
		} else {
			result.addAll(left);
			result.add(pivotValue);
			result.addAll(right);
		}
				
		return result;
	}


	public static Integer[] insertionSort(Integer[] array) {
		for(int i=1; i< array.length;i++) {			
			// move number to the first position
			if(array[i]< array[0]) {
				insertArray(array[i], array, 0, i);
			} else {
				// only sort number smaller than number on the left of it
				// Therefore, insertionSort very fast if the array is almost pre-sorted
				if(array[i]< array[i-1]) {
					// find where number should go
					for(int j=1; j<i; j++) {
						if(array[i]<array[j] && array[i]> array[j-1]) {
							insertArray(array[i], array, j, i);
						}
					}
				}				
				continue;
			}
		}		
		return array;
	}
		
	private static void insertArray(Integer insert, Integer[] array, int indexTo, int indexFrom) {
		for(int i= indexFrom; i> indexTo; i--) {
			array[i]=array[i-1];
		}		
		array[indexTo]=insert;		
	}


	/**
	 * @BubbleSort
	 * @implement: Worstcase O(n^2)
	 * Repeatedly loop through all array's elements. Compare each pair of elements, swap their position if previous element > next element
	 * Stop (array already sorted) when in 1 whole loop, there is no swap has to made
	 */
	public static Integer[] bubbleSort(Integer[] array) {
		boolean sorted;
		
		for(int i=0; i<array.length;i++) {
			// sorted = true in the beginning of each loop. 
			// If there is Swap, sorted = false
			// If there is no Swap in whole loop, sorted still = true => Bubble Sort stop
			sorted=true;
			for(int j=0; j<array.length-1; j++) {
				if(array[j]>array[j+1]) {
					Integer temp = array[j];
					array[j]=array[j+1];
					array[j+1]= temp;
					sorted=false;
					continue;
				}			
			}
			
			if(sorted) {
				break;
			}
		}
		return array;
	}
	
	
	/**
	 * @SelectionSort worstcase O(n^2)
	 * Repeatedly loop through all the array's elements.
	 * Each loop move the min value to the left of the array
	 */
	public static Integer[] selectionSort(Integer[] array) {
		int min=0;
		
		for(int i=0;i< array.length-1; i++) {
			min=i;
			for(int j=i+1; j< array.length; j++) {
				if(array[j]<array[min]) {
					min=j;
				}
			}
			Integer temp = array[i];
			array[i]=array[min];
			array[min]=temp;
		}
		
		return array;
	}
}
