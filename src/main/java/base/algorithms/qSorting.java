package base.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class qSorting {
	
	
	/**
	 * @MergeSort
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
	
	
	/**
	 * @QuickSort
	 * @Implement: https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/v4/t/lecture/12406460?start=0
	 * int left - int right: is new array's window to check each time we divide the array in half
	 */
	public static List<Integer> quickSort(List<Integer> array, int left, int right){		
		int partitionIndex = right; // index to divide the array in half for next recursive loop
		int pivot = array.get(right);	// pivot value, normally take the last array's element	
		
		// if there is only 2 elements to check
		// this logic to avoid the malfunction swap() (below else if block) when there is only 2 arrays' elements
		if (left==right-1) {
			if(array.get(left) > array.get(right)) {
				int temp = array.get(left);
				array.set(left, array.get(right));
				array.set(right, temp);
			}
		} else if (left < right) {	
			// Move all the greater value than pivot value to it's right hand side
			for (int i = left; i < partitionIndex; i++) {
				if(array.get(i)>pivot) {
					if(i==partitionIndex-1) {
						swap(array, i, partitionIndex);
					}
					// array[i] move to pivot position
					// pivot move to array[pivot-1] position
					// array[pivot-1] move to array[i] position
					swap(array, partitionIndex, partitionIndex-1);
					swap(array, i, partitionIndex);
					
					// shift partition index to new pivot position
					partitionIndex--;
					// re-check the array[pivot-1] value after moving
					// there is a case that array[pivot-1] > array[pivot]
					// without this check we will miss this case
					i--;
				}
			}
			
			quickSort(array, left, partitionIndex-1);
			quickSort(array, partitionIndex+1, right);
		} 
		
		return array;	
	}
	
	private static void swap(List<Integer> array, int from, int to) {
		int temp = array.get(from);
		array.set(from, array.get(to));
		array.set(to, temp);	
	}

	/**
	 * @InsertionSort
	 * @Implement: repeatedly loop through the array
	 * If array[i]<array[i-1], move array[i] to the beginning of the array
	 * InsertionSort is very fast if the array is nearly-sorted
	 */
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
