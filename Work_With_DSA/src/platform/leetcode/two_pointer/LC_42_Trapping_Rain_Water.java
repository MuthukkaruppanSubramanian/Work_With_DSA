package platform.leetcode.two_pointer;

import java.util.*;
import org.junit.*;

public class LC_42_Trapping_Rain_Water {

	/*
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: 
	 * 
	 * Approach 2: 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		Assert.assertTrue(getTrappingRainWater(nums)==6);
	}

	@Test
	public void test2() {
		int[] nums = {4,2,0,3,2,5};
		Assert.assertTrue(getTrappingRainWater(nums)==9);
	}

	@Test
	public void test3() {
		int[] nums = {3,2,1,0,0,0};
		Assert.assertTrue(getTrappingRainWater(nums)==0);
	}

	@Test
	public void test4() {
		int[] nums = {4,2,3};
		Assert.assertTrue(getTrappingRainWater(nums)==1);
	}

	/*
	 * Pseudo code
	 * Declare left max = nums[0]
	 * from 2nd to last value get the maxnum
	 * Traverse the array in for loop 
	 * 
	 */

	public int getTrappingRainWater(int[]nums) {
		int[] leftMaxArray = new int[nums.length];
		int[] rightMaxArray = new int[nums.length];
		int trappedWater = 0;

		//Get the Left Max Array value for each element in nums
		int max = nums[0];
		for (int i = 1; i < nums.length-1; i++) {
			max = Math.max(max, nums[i]);
			leftMaxArray[i] = max;
		}

		//Get the Right Max Array value for each element in nums
		max = nums[nums.length-1];
		for (int i = nums.length-2; i >0 ; i--) {
			max = Math.max(max, nums[i]);
			rightMaxArray[i] = max;
		}
		// Get the min of left and right max and subtract with current nums[i]
		for (int i = 1; i < nums.length-1; i++) {
			trappedWater += Math.min(leftMaxArray[i], rightMaxArray[i]) - nums[i];
		}
		
		return trappedWater;
	}
	
	public int getTrappingRainWater2Pass(int[]nums) {
		int[] leftMaxArray = new int[nums.length];
		int[] rightMaxArray = new int[nums.length];
		int trappedWater = 0;

		//Get the Left Max Array value for each element in nums
		int max = nums[0];
		for (int i = 1; i < nums.length-1; i++) {
			max = Math.max(max, nums[i]);
			leftMaxArray[i] = max;
		}

		//Get the Left Max Array value for each element in nums
		max = nums[nums.length-1];
		for (int i = nums.length-2; i >0 ; i--) {
			max = Math.max(max, nums[i]);
			trappedWater += Math.min(leftMaxArray[i], max) - nums[i];
		}
		
		return trappedWater;
	}
}















