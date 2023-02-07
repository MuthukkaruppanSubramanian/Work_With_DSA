package dsa.binary_search.algo;

import org.junit.Assert;
import org.junit.Test;

public class CountOnes {
	/*
	 * Count all the ones in the sorted array
	 * 
	 * Given Change In Input  data type: int[] nums = {0,0,0,0,0,1};
	 *       Output data type: int 1
	 * Sample Test Data 
	 *    Input : int[] nums = {0,1,1,1,1,1};
	 *    output: int 5
	 *
	 * Approach 1: Binary Search / Two Pointer / one for loop
	 *
	 * Pseudo code:
	 * Declare low as 0 and high as length-1
	 * Traverse the array in loop till low<=high
	 * get the mid by avg of low and high
	 * Check if mid is eql to one and mid-1 >=0
	 * 		if mid-1< 1 then return array len-mid
	 * 		else high = mid-1
	 * then mid == 0 and mid+1 < array.length
	 * check if mid+1 > 0 then return array.length - (mid+1)
	 * else low = mid+1
	 *
	 * Time / Space Complexity: O(logn) / O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {0,0,0,0,0,1};
		System.out.println(countNoOfOne(nums));
		Assert.assertEquals(countNoOfOne(nums), 1);
	}

	@Test
	public void test2() {
		int[] nums = {0,1,1,1,1,1};
		System.out.println(countNoOfOne(nums));
		Assert.assertEquals(countNoOfOne(nums), 5);
	}

	@Test
	public void test3() {
		int[] nums = {1,1,1,1,1,1};
		System.out.println(countNoOfOne(nums));
		Assert.assertEquals(countNoOfOne(nums), 6);
	}

	@Test
	public void test4() {
		int[] nums = {0,0,0,0,0};
		System.out.println(countNoOfOne(nums));
		Assert.assertEquals(countNoOfOne(nums), -1);
	}

	public int countNoOfOne(int[] nums) {
		int low = 0, high = nums.length-1;
		while(low<high) {
			int mid = (low+high)/2;
			if(nums[mid]==1 && mid-1 >= 0) {
				if (nums[mid-1] < 1) return nums.length-mid;
				else high = mid-1;
			}else if(nums[mid]==1) return nums.length-mid;
			else if(nums[mid]==0 && mid+1 < nums.length) {
				if(nums[mid+1] == 1) return nums.length-(mid+1);
				else low = mid+1;
			}
		}

		return -1;
	}
}
