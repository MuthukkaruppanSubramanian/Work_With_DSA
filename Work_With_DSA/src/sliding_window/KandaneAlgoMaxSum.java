package sliding_window;

import org.junit.Test;

public class KandaneAlgoMaxSum {
	/*
	 * Given Input  data type: int []
	 *       Output data type: int
	 * Sample Test Data 
	 *    Input :{-1,-5,2,-3,7,1}
	 *    output: -7
	 *
	 * Approach 1: Kandane
	 *
	 * Pseudo code:
	 * Declare the windoSum as array[0] and maxSum as array[0]
	 * Traverse the array with for loop from i = 1 till array length
	 * Add the current value to windowSum and compare with current value
	 * Which ever is min assign that to windowSum
	 * Then assign the min value by comparing windowSum and minSum
	 * Return the minSum
	 * 
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {-1,-5,2,-3,7,1};
		System.out.println(minSubArrayLen( nums)); 
	}

	@Test
	public void test2() {
		int[] nums = {1,4,4};
		System.out.println(minSubArrayLen(nums)); 
	}

	@Test
	public void test3() {
		int[] nums = {-1,-4,-4};
		System.out.println(minSubArrayLen(nums)); 
	}
	
	@Test
	public void test4() {
		int[] nums = {-1,-5,2,-3,7,1};
		System.out.println(maxSubArray( nums)); 
	}

	public int minSubArrayLen(int[] nums) {
		int windowSum = nums[0], minSum=nums[0];
		for (int i = 1; i < nums.length; i++) {
			windowSum = Math.min(windowSum+nums[i], nums[i]);
			minSum = Math.min(minSum, windowSum);
		}
		return minSum;
	}
	
	public int maxSubArray(int[] nums) {
		int windowSum = nums[0], maxSum=nums[0];
		for (int i = 1; i < nums.length; i++) {
			windowSum = Math.max(windowSum+nums[i], nums[i]);
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}
}
