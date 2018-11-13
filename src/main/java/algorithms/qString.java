package algorithms;

public class qString {
	
	public String reverse(String input) {
		char[] inputArray = input.toCharArray();
		
		int len = inputArray.length;
		for(int i=0; i< (int) len/2; i++) {
			char temp = inputArray[i];
			inputArray[i]=inputArray[len-1-i];
			inputArray[len-1-i]=temp;
		}
		
		return new String(inputArray);
		
	}
}
