package dsa.binary_search.algo;

import org.junit.Test;

public class FindPeakElement {
	/*
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: 
	 *
	 * Pseudo code:
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,2,3,1};
		System.out.println(findPeakElement(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,2,1,3,5,6,4};
		System.out.println(findPeakElement(nums));
	}

	
	@Test
	public void test3() {
		int[] nums = {1,3,3,1,4};
		System.out.println(findPeakElement(nums));
	}

	public int findPeakElement(int[] nums) {
		int low = 0, high = nums.length-1;
		while(low < high) {
			int mid = (low+high)/2;
			if(nums[mid-1] <= nums[mid] && nums[mid] >= nums[mid+1]) return mid;
			if(nums[mid] > nums[mid+1]) high = mid;
			else low = mid+1;
		}
		return 0;
	}
}
