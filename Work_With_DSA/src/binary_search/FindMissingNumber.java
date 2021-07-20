package binary_search;

import org.junit.Test;

public class FindMissingNumber {
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
	 * Declare the low = 0 and high = num.length-1;
	 * While low value <= high traverse the array
	 * if mid == target then return target
	 * else if low >= target and mid >= target high = mid-1
	 * else low = mid+1 
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {4,5,6,7,0,1,2};
		int k = 2;
		System.out.println(findGivenNumInArray(k, nums));
	}

	@Test
	public void test2() {
		int[] nums = {5,6,7,8,0,1,2,3,4};
		int k = 5;
		System.out.println(findGivenNumInArray(k, nums));
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3,4,5,6,0};
		int k = 0;
		System.out.println(findGivenNumInArray(k, nums));
	}

	@Test
	public void test4() {
		int[] nums = {6,7,1,2,3,4,5};
		int k = 4;
		System.out.println(findGivenNumInArray(k, nums));
	}

	@Test
	public void test5() {
		int[] nums = {1};
		int k = 1;
		System.out.println(findGivenNumInArray(k, nums));
	}

	public int findGivenNumInArray(int target, int[] nums) {
		int low = 0, high = nums.length-1;
		if(nums.length<=2) {
			if(target==nums[0]) return 0;
			else if(target==nums[1]) return 1;
			else return -1;
		}
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==target) return mid; 
			if(nums[low]<=nums[mid]) // Range is sorted
				if(nums[low] <= target  && nums[mid] > target ) high =mid-1;
				else low = mid+1;
			else
				if(nums[mid] < target && nums[high] >= target) low = mid +1;
				else high = mid-1;
		}
		return -1;
	}
}
