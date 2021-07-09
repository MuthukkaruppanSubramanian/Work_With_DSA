package problem_solving_genric;

import java.util.Arrays;
import org.junit.Test;

public class RemoveAnElementFromAnArray {
	/*
	 * // TODO Auto-generated method stub
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - String
	 * What is the expected output? - String
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : Input Array - {1,2,3,6,4,5} , target = 6
	 *   
	 *  Edge     : Input Array - {2,2,2,2,2}, sum = 3
	 *  		   Input Array - {2,1,4,2,2,2}, sum = 5
	 *  
	 *  Negative : Input Array - {22,32,12,12}, sum = 3
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those?
	 *	No – That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
		 *	Then, explain either both or the best (depends on the time)
	 *	Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 *
	 * 7) Start with Pseudo code
	 * 		a. Take int array and target int to be removed as args
	 * 		b. Traverse the array to find the occurrence of the target in the array and store it in count var
	 * 		c. Create a new array with the size of give int array - no.of.occurrence of target
	 * 		d. Reinitialize the count var to 0 .
	 * 		e. Traverse the array and push the element other than target to new array with the count as index.
	 * 		f. Return the o/p array
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		int[] array = {6,6,4,5,4,2};
		int target = 6;
		System.out.println(Arrays.toString(rmvElemInArraySinglePass(array, target)));
	}
	
	@Test
	public void test2() {
		int[] array = {2,3,4,5};
		int target = 3;
		System.out.println(Arrays.toString(rmvElemInArraySinglePass(array, target)));
	}
	
	@Test
	public void test3() {
		int[] array = {2,2,2,2,2};
		int target = 2;
		System.out.println(Arrays.toString(rmvElemInArraySinglePass(array, target)));
	}
	
	
	@Test
	public void test4() {
		int[] array = {22,32,12,12};
		int target = 2;
		System.out.println(Arrays.toString(rmvElemInArraySinglePass(array, target)));
	}
	
	public int [] removeElementFromArray(int [] array, int target) {
		int count = 0;
		
		//To get the occurrence of the target
		for(int i=0; i < array.length; i++) { 
			if(array[i]==target) count ++;
		}
		if(count==0) return new int[] {-1,-1};
		int[] newArray = new int[array.length-count];
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != target) {
				newArray[count++] = array[i]; 
			}
		}
		return newArray;
	}
	
	public int [] rmvElemInArraySinglePass(int [] array, int target) {
		int targetPos = -1;
		int tmp = 0;
		int lastTargetPos = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == target) {
				targetPos = (lastTargetPos <= i) ? lastTargetPos:i;
				continue;
			}
			if(targetPos >= 0 && i >0) {
				tmp = array[targetPos];
				array[targetPos++] = array[i];
				array[i] = tmp;
				lastTargetPos = targetPos;
			}
		}
		int[] newArray = Arrays.copyOfRange(array, 0, lastTargetPos);
		return newArray;
	}
}
