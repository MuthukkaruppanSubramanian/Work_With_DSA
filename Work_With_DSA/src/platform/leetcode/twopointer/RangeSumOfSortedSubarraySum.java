package platform.leetcode.twopointer;

import java.util.Arrays;

import org.junit.Test;

public class RangeSumOfSortedSubarraySum {
	/*
	 * You are given the array nums consisting of n positive integers. You computed
	 * the sum of all non-empty continuous subarrays from the array and then sorted
	 * them in non-decreasing order, creating a new array of n * (n + 1) / 2
	 * numbers.
	 * 
	 * Return the sum of the numbers from index left to index right (indexed from
	 * 1), inclusive, in the new array. Since the answer can be a huge number return
	 * it modulo 109 + 7.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 5 Output: 13 Explanation:
	 * All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in
	 * non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
	 * The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
	 */
	
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
		int[] nums = {1,2,3,4};
		int n = 4, left = 1, right =5;
		System.out.println(minSubArrayLen(nums, n, left, right));
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	public int minSubArrayLen(int[] nums, int n, int left, int right) {
		int[] newArray = new int[(n*(n+1))/2];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			int max_sum = 0;
			for (int j = i; j < nums.length; j++) {
				max_sum += nums[j];
				newArray[index++] = max_sum;
			}
		}
		n = 0;
		Arrays.sort(newArray);
		left--;right--;
		while(left <= right) {
			if(left==right) {
				n+=newArray[left];
				break;
			}
			n += newArray[left++]+newArray[right--];
		}
		return n;
	}
}
