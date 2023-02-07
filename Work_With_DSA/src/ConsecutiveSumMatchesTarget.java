import java.util.*;
import org.junit.*;

public class ConsecutiveSumMatchesTarget {
	/*
	 * Problem 1) 
	 * Given an int array [1,4,20,3,10,5] and 
	 * target sum 33. If target
	 * subarray sum is found, return true else false 
	 * Time : 20 Minutes - Write
	 * another 2 test data (edge and neg) - 
	 * Pseudo Code for Optimised Solution -
	 * Code, Debug - 
	 * Time everything 
	 * - Do it yourself !!
	 */
	
	
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 *       
	 * Sample Test Data 
	 *    Input : int array [1,4,20,3,10,5], int sum 33
	 *    output:true
	 *
	 * Approach 1: Sliding Window
	 *
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,4,20,3,10,5};
		int target = 33;
		Assert.assertTrue(checkTargetMatches(nums,target));
	}

	@Test
	public void test2() {
		int[] nums = {-10,1,-4,20,3,30};
		int target = 33;
		Assert.assertTrue(checkTargetMatches(nums,target));
	}

	@Test
	public void test3() {
		int[] nums = {1,4,20,3,11,5};
		int target = 33;
		Assert.assertFalse(checkTargetMatches(nums,target));
	}
	
	@Test
	public void test4() {
		int[] nums = {3,10,10,10};
		int target = 33;
		Assert.assertTrue(checkTargetMatches(nums,target));
	}
	
	/*
	 * Pseudo Code:
	 * Declare two pointers starts left = 0 and right = 0 and currentSum = 0; 
	 * Traverse the array in while loop until right reaches array length
	 *  add the right value to current sum
	 *  check if matches the sum return true
	 *  else if currentSum greater than target
	 *  ------decreament left value from sum and do left++
	 *  do right++
	 *  retrun false
	 */
	
	//Time box
	//Psuedo Code: 8:06 - 8:10
	//Coding   :8:10 - 8:11
	//debugging:8:11 - 8:16
	private boolean checkTargetMatches(int[] nums, int target) {
		int left = 0, right = 0, currentSum = 0;
		while(right<nums.length) {
			currentSum +=nums[right];
			if(currentSum == target) return true;
			while (currentSum > target) {
				currentSum -=nums[left++];
			}
			if(currentSum == target) return true;
			right++;
		}
		return false;
	}
	
}






















