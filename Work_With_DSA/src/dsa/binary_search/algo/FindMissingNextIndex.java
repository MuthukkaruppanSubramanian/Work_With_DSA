package dsa.binary_search.algo;

import org.junit.Test;

public class FindMissingNextIndex {
	/*
	 * Given Input  data type:int[] int k
	 *       Output data type: int
	 * Sample Test Data 
	 *    Input :{1,3,5,6} , target = 7
	 *    output:4
	 *
	 * Approach 1: 
	 * Declare the low as 0 and high as arr.len-1
	 * traverse array in while loop until low<=high
	 * mid = low+high/2
	 * if array[mid] eql to target return mid
	 * else check low equal to high and array[mid] < target return mid+1
	 * else check low  equal to high and array[mid] > target return mid-1 
	 * then check array[mid]<target low = mid+1
	 * else high = mid-1
	 * Pseudo code:
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,3,5,6};
		int k = 7;
		System.out.println(findTheGivenTargetIndLex(nums,k));
	}

	@Test
	public void test2() {
		int[] nums = {1,3,5,6};
		int k = 0;
		System.out.println(findTheGivenTargetIndLex(nums,k));
	}

	@Test
	public void test3() {
		int[] nums = {1,3,5,6};
		int k = 2;
		System.out.println(findTheGivenTargetIndLex(nums,k));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,3,5,6};
		int k = 5;
		System.out.println(findTheGivenTargetIndLex(nums,k));
	}

	public int findTheGivenTargetIndLex(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]==target) return mid;
			else if(low==high) {
				if(nums[mid] < target ) return mid+1;
				if(mid==0) return 0;
				return mid-1;
			}
			if(nums[mid]<target) low = mid+1;
			else high = mid-1;
		}
		return -1;
	}
}
