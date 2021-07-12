package two_pointer;

import java.util.Arrays;

import org.junit.Test;

public class UniqueOccurance {
	
	/*
	 * Given a non-empty array of integers nums, every element appears twice except
	 * for one. Find that single one. You must implement a solution with a linear
	 * runtime complexity and use only constant extra space.
	 * 
	 * Example 1:Input: nums = [2,2,1] Output: 1
	 * 
	 * Example 2: Input: nums = [4,1,2,1,2] Output: 4
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
	 *  Positive : Input Array - [2,2,1] , O/P = 1
	 *   
	 *  Edge     : 
	 *  
	 *  Negative : Input Array - {2,2,1,1}, O/P = -1
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
	 *  Alog -> Two Pointer
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *	Then, explain either both or the best (depends on the time)
	 *	Approach 1: O(nlogn) / O(logn)
	 *  Approach 2: O(n) / O(logn) 
	 *
	 * 7) Start with Pseudo code
	 * 		a. Take give int array and sort
	 * 		b. int uniqueNum = -1, left = 0; right = 1; 
	 * 		c. Traverse using while loop with condition(right < arr.length)
	 * 		d. if(arr[left]!=arr[right]) return arr[left]
	 * 		e. else left+2, right+2
	 * 		Time / Space Complexity : O(n^2) / O(1)
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		int[] numSeq = {1,2,3,4};
		System.out.println(uniqueOccurrenceUsing2Pointer(numSeq));
	}

//	@Test
//	public void test2() {
//		int[] numSeq = {1,4,3,1,4};
//		System.out.println(uniqueOccurrenceUsing2PointerOpp(numSeq));
//	}
//
//	@Test
//	public void test3() {
//		int[] numSeq = {1,1,2,2,4};
//		System.out.println(uniqueOccurrenceUsing2PointerOpp(numSeq));
//	}
	
	private int uniqueOccurrenceUsing2Pointer(int[] numSeq) {
		int uniqueNum = -1, left = 0, right = 1;
		Arrays.sort(numSeq);
		while (right < numSeq.length) {
			if(numSeq[left] != numSeq[right]) return numSeq[left];
			left = left+2;
			right = right+2;
			if(right >= numSeq.length) return numSeq[right-1];
		}
		return uniqueNum;
	}
	
	//in prev problem - unique in constrain if(arr[right0 ! = arr[RIGHT-1]) but they have written right+1
	private int uniqueOccurrenceUsing2PointerOpp(int[] numSeq) {
		int uniqueNum = -1, left = 0, right = numSeq.length;
		Arrays.sort(numSeq);
		while (left <= right) {
			if(numSeq[left] != numSeq[left+1]) return numSeq[left];
			left+=2;
			if(numSeq[right] != numSeq[right-1]) return numSeq[right];
			right-=2;
		}
		return uniqueNum;
	}
}
