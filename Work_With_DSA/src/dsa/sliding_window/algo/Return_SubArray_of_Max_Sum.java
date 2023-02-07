package dsa.sliding_window.algo;
import org.junit.*;
import java.util.*;

public class Return_SubArray_of_Max_Sum {
	
	/*
	 * Given an array of integers, return the minimum possible contiguous array with
	 * maximum sum value. 
	 * Examples: int[] nums = {2,4,-11,0,3,7} Output {3,7}
	 * 
	 * Explanation: Sum of 3+7 is the biggest sum of all elements in the array.
	 * Though 0+3+7 gives the same value, it is expected to return the min possible
	 * contiguous array, hence it is {3,7}
	 */
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Sliding Window
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {2,4,-11,0,3,7};
		Assert.assertTrue(getMaxSubArray(nums));
	}

	@Test
	public void test2() {
		int[] nums = {3,5,11,-12,24,6};
		Assert.assertTrue(getMaxSubArray(nums));
	}

	@Test
	public void test3() {
		int[] nums = {-1,-5,-3,-2,-10,-11};
		Assert.assertTrue(getMaxSubArray(nums));
	}

	
	/*8:54
	 * Pseudo Code
	 * Delcare currentSum, windowSum, maxSum, as nums [0] left and right = 0;
	 * Declare a int array to hold start and end index
	 * Traverse the array in for loop from index 1
	 * ----set the current sum = nums[i]
	 * ----add the current sum to the window sum
	 * ----find the maxsum of window sum and current sum
	 * ------if(maxsum == window sum)
	 * ----------output array[1] = i
	 * ------else(maxSum == currentSum)
	 * ----------outputarray[0] = i
	 * ----if(windowSum < 0)
	 * ---------r++
	 * ---------l = r
	 * 
	 * return output
	 */
	
	/**
	 * @param nums
	 * @return
	 */
	private boolean getMaxSubArray(int[] nums) {
		int windowSum = nums[0], currentSum = nums[0], maxSum = nums[0];
		int[] output = new int[2];
		int left = 0, right = 0;
		for (right = 1; right < nums.length; right++) {

			currentSum = nums[right];
			windowSum += currentSum;
			maxSum = Math.max(maxSum, Math.max(windowSum, currentSum));
			
			if (maxSum == currentSum) {
				output[1] = right;
				output[0] = right;
				left = right+1;
				windowSum = 0;
			}if(maxSum == windowSum) {
				output[0] = left;
				output[1] = right;
			}
			
			if(windowSum < 0) {
				windowSum = 0;
				left = right+1;
			}
		}
		
		System.out.println(Arrays.toString(output));
		return false;
	}
}
