package platform.leetcode.twopointer;

import java.util.Arrays;

import org.junit.Test;

public class SortedArrayByParity {
	
	/*
	 * Given an array nums of non-negative integers, return an array consisting of
	 * all the even elements of nums, followed by all the odd elements of nums.
	 * 
	 * You may return any answer array that satisfies this condition.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3],
	 * and [4,2,1,3] would also be accepted.
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
	 * Declare left and right pointer as 0
	 * If right point to even number and right > left swap the right and left
	 * else move the right+1
	 * if left point to even number do left++
	 * repreat this until left <=right
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {3,1,2,4};
		System.out.println(Arrays.toString(sortArrayByParity(nums)));
	}
	
	@Test
	public void test2() {

	}
	
	@Test
	public void test3() {
		
	}
	
    public int[] sortArrayByParity(int[] nums) {
    	int left = 0, right = 0;
    	while(right < nums.length) {
    		if((nums[right] & 1) == 0 && right > left) {
    			int tmp = nums[right];
    			nums[right++] = nums[left];
    			nums[left++] = tmp;
    		}else right++;
    		
   			if((nums[left] & 1) == 0) left++;
    	}
     return nums;
 }
}
