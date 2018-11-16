package base.algorithms;

public class qRecrusion {
	
	public static Integer findFactorialR(Integer input) {
		if(input==0) return 1;
		
		return input*findFactorialR(input-1);
	}
}
