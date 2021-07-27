package dsa.binary_search.algo;

import org.junit.Assert;
import org.junit.Test;

public class SecondMaxNumber {
	/* Given an int[] find the second max number
	 * 
	 * Given Input  data type: {1,2,3,4}
	 *       Output data type: 
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: Brute Force using one for loop
	 *
	 * Approach 2: 
	 * Pseudo code:
	 * 
	 * Declare a int var of maxVal = array[0] and secondMax array[1]
	 * Comapre the maxVal and secondMax then swap the val
	 * Then I have to iterate it over a for loop
	 * I have comapre the current value with the secondMax
	 * Then swap the current index as secondMax
	 * 
	 * 
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,2,3,4,4};
		Assert.assertTrue(findTheSecondMax(nums)==3);
	}

	@Test
	public void test2() {
		int[] nums = {5,4,2,3};
		Assert.assertTrue(findTheSecondMax(nums)==4);
	}
	
	@Test(expected = RuntimeException.class)
	public void test3() {
		int[] nums = {2,2,2,2};
		Assert.assertTrue(findTheSecondMax(nums)==1);
	}

	public int findTheSecondMax(int[] nums) {
		int maxval = Math.max(nums[0], nums[1]);
		int secondMax = Math.min(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			if(maxval < nums[i]) {
				secondMax = maxval;
				maxval = nums[i];
			}else if(secondMax < nums[i] && nums[i] != maxval) {
				secondMax = nums[i];
			}
		}
		if(maxval == secondMax) throw new RuntimeException("All the elements are same");
		return secondMax;
	}
}
