package algorithms;

public class qArray {
	
	/**
	 * Merge 2 integer array into 1 integer array
	 */
	public static Integer[] merge(Integer[] array1, Integer[] array2) {
		Integer[] outputArray = new Integer[array1.length+array2.length];
		
		if(array1.length == 0) {
			return array2;
		}
		
		if(array2.length == 0) {
			return array1;
		}
		
		for(int i=0; i< outputArray.length; i++) {
			if(i< array1.length) {
				outputArray[i]=array1[i];
			} else {
				outputArray[i]=array2[i-array1.length];
			}
		}
		
		return outputArray;
	}
	
	/**
	 * Insertion sort array in ascending order
	 */
	public static Integer[] insertionSort(Integer[] inputArray) {
		
		if(inputArray.length == 0) {
			return inputArray;
		}
		
		for(int i=0; i< inputArray.length-1; i++) {
			for(int j=i+1; j<inputArray.length; j++) {
				if(inputArray[i]>inputArray[j]) {
					int temp = inputArray[i];
					inputArray[i]=inputArray[j];
					inputArray[j]=temp;
				}
			}
		}
		
		return inputArray;
	}

}
