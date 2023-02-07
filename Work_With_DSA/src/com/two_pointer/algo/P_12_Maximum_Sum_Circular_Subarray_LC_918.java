package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_12_Maximum_Sum_Circular_Subarray_LC_918 {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,-2,3,-2};
		System.out.println(maxSubarraySumCircular(nums));
	}

	@Test
	public void test2() {
		int[] nums = {5,-3,5};
		System.out.println(maxSubarraySumCircular(nums));
	}

	@Test
	public void test3() {
		int[] nums = {3,-1,2,-1};
		System.out.println(maxSubarraySumCircular(nums));
	}

	@Test
	public void test4() {
		int[] nums = {3,-2,2,-3};
		System.out.println(maxSubarraySumCircular(nums));
	}

	@Test
	public void test5() {
		int[] nums = {-2,-3,-1};
		System.out.println(maxSubarraySumCircular(nums));
	}
	
	/*
	 * Pseudo Code
	 * Declare maxSum as IntegerMin value
	 * In a for loop traverse the array till length
	 * ----check the current sum, window sum and get the max.
	 * while rotate an array till the last value became as first
	 * ----rotate from 1st index by calling function
	 * ----call check maxSum function to get the maxSum
	 * ----compare previous and current sum and update maxSum
	 * return max sum
	 */
	
	public int rotateArray(int[] nums, int position) {
		int index = 1;
		int maxSum = nums[position], windowSum = nums[position++];
		for (int i = position; i < nums.length; i++) {
			index++;
			windowSum += nums[i];
			maxSum = Math.max(maxSum, Math.max(windowSum, nums[i]));
		}
		int i = 0;
		while (index < nums.length) {
			index++;
			windowSum += nums[i];
			maxSum = Math.max(maxSum, Math.max(windowSum, nums[i++]));
		}
		return maxSum;
	}
	
	public int getMaxSum(int[] nums) {
		int maxSum = nums[0], windowSum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			windowSum += nums[i];
			maxSum = Math.max(maxSum, Math.max(windowSum, nums[i]));
		}
		return maxSum;
	}
	
	public int maxSubarraySumCircular(int[] nums) {
		int maxSum = getMaxSum(nums);
		int startPosition = 1;
		while(startPosition < nums.length) {
			int sum = rotateArray(nums, startPosition++);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
