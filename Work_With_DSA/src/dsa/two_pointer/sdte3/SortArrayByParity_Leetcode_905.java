package dsa.two_pointer.sdte3;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParity_Leetcode_905 {
	/*
	 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
	 * Return any array that satisfies this condition.
	 * Input: nums = [3,1,2,4]
	 * Output: [2,4,3,1]
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - integer array
	 * What is the expected output? - integer array
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : {3,1,2,4} => {4,2,1,3}
	 *   
	 *  Edge     : {0,1,2,4} => {0,4,2,1}
	 *  
	 *  Negative : {0} => {0}
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
	 *	Yes - What are those? Yes
	 *	No � That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Two Pointer
	 *  
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 *
	 */
	
	@Test
	public void test1() {
		int[] input = {3,1,2,4};
		System.out.println(Arrays.toString(sort_array_by_parity(input)));
		Assert.assertArrayEquals(sort_array_by_parity(input), new int[] {4,2,1,3});
	}

	@Test
	public void test2() {
		int[] input = {0,1,2,4};
		Assert.assertArrayEquals(sort_array_by_parity(input), new int[] { });
	}
	
	@Test
	public void test3() {
		int[] input = {4,3,5,2,6,7};
		Assert.assertArrayEquals(sort_array_by_parity(input), new int[] {4,6,2,5,3,7});
	}

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Two Pointer
	 * 
	 * 1. Declare two pointers left and right with value 0 and array length-1;
	 * 2. In While loop iterate the array until left < right
	 * 3. ----If right % 2 is equal to 0 and left % 2 not equal to 0
	 * 4. --------Swap the element position using third variable
	 * 5. --------Increment left and decrement right
	 * 6. ----else if left % 2 is equal to 0 then left ++
	 * 7. ----else do right --
	 * 8. Return the array 
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) - In Place memory
	 */
	

	public int[] sort_array_by_parity(int[] nums1) {
		int left = 0, right = nums1.length-1;
		while(left < right){
			if((nums1[right]%2 ==0) && (nums1[left]%2 != 0)) {
				int tmp = nums1[right];
				nums1[right] = nums1[left];
				nums1[left] = tmp;
			}else if (nums1[left]%2 == 0) left ++;
			else if (nums1[right]%2 != 0) right --;
		}
		return nums1;
	}
}

