package dsa.binary_search.algo;
import org.junit.*;
import java.util.*;

public class Search_Value_In_Rotated_Array {
	
	/*
	 * Search in a rotated array
	 * 
	 * 
	 * There is an integer array nums sorted in ascending order (with distinct
	 * values).
	 * 
	 * Prior to being passed to your function, nums is rotated at an unknown pivot
	 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
	 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
	 * example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become
	 * [4,5,6,7,0,1,2].
	 * 
	 * Given the array nums after the rotation and an integer target, return the
	 * index of target if it is in nums, or -1 if it is not in nums.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 *
	 * Sample Test Data 
	 * Input : Type array  [4,5,6,7,0,1,2], target = 0
	 * output: Type int index of given target
	 *
	 * Approach 1: Binary Search
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(1)
	 * 
	 */
	
	@Test
	public void test1() {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 6;
		Assert.assertTrue(getTargetIndex(nums, target)==2);
	}

	@Test
	public void test2() {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;
		Assert.assertTrue(getTargetIndex(nums, target)==-1);
	}

	@Test
	public void test3() {
		int[] nums = {3,1};
		int target = 1;
		Assert.assertTrue(getTargetIndex(nums, target)==1);
	}
	
	/*
	 * Pseudo Code
	 * Declare low = 0 and right = nums.length-1;
	 * tarverse the array in while till left < right
	 * ----int mid = avg of left+right
	 * ----if nums[mid] == target return mid;
	 * ---if(nums[low]< nums[mid])
	 * ------check if nums[low] <= target  and target <= nums[mid]
	 * -----------high = mid
	 * ----else low = mid
	 * 
	 * return -1
	 */
	
	private int getTargetIndex(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(nums[mid] == target) return mid;
			if(nums[low] <= nums[mid]) {
				if(nums[low] <= target && target < nums[mid])
					high = mid-1;
				else
					low = mid+1;
			}else {
				if(nums[mid] < target && target <= nums[high])
					low = mid+1;
				else
					high = mid-1;
			}
		}
		return -1;
	}
}
