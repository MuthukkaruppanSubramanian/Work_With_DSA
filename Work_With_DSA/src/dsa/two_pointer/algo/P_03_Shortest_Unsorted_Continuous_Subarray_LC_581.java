package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_03_Shortest_Unsorted_Continuous_Subarray_LC_581 {
	
	/*
	 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
	 *
	 * Sample Test Data 
	 *    Input : {1,2,6,2,3,5}
	 *    output: 4
	 *
	 * Approach 1: Two Pointer
	 * 
	 * Time / Space Complexity: O(n) / O(1)
	 * 
	 * Approach 1: Stack
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,2,6,2,3,5};
		Assert.assertTrue(findUnsortedSubarray(nums)==4);
	}

	@Test
	public void test2() {
		int[] nums = {1,2,4,5,3};
		Assert.assertTrue(findUnsortedSubarray(nums)==3);
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3};
		Assert.assertTrue(findUnsortedSubarray(nums)==0);
	}
	
	/*
	 * Pseudo Code
	 * Declare a int var left, right as 0
	 * Declare min as Integer Max value and max as Interger Min Value
	 * 
	 * Traverse the for loop from 1 to length-1
	 * ---if i < i-1
	 * -----store the min of current min and nums[i]
	 * 
	 * Traverse the for loop from length-2 to 0
	 * --if i > i+1
	 * ----store the max value of current max and nums[i]
	 * 
	 * Traverse the left value from 0 to length of array
	 * ---if min < nums[left]
	 * -------break;
	 * 
	 * Traver the array from right = length-1 till 0
	 * ---if max > nums[right]
	 * ------break;
	 * 
	 * return right-left > 0 ? right-left+1 : 0
	 */
	
	public int findUnsortedSubarray(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int left = 0, right = 0;
		
		//Find the min value to get the start point index
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] < nums[i-1]) {
				min = Math.min(min, nums[i]);
			}
		}
		
		//Find the max value to get the end point index
		for(int i = nums.length-2; i >=0; i--) {
			if(nums[i]> nums[i+1]) {
				max = Math.max(max, nums[i]);
			}
		}
		
		//to get the start index from which array has to be sorted
		for(left = 0; left < nums.length; left++) {
			if(min < nums[left])
				break;
		}
		
		//to get the end index until which array has to be sorted
		for(right = nums.length-1; right >= 0;right--) {
			if(max > nums[right])
				break;
		}
		
		return right-left >= 0? right-left+1 : 0;
	}
}
