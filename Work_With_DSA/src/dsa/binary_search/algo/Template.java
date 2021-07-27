package dsa.binary_search.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Template {
	/* Move all the positive numbers to right
	 * 
	 * Given Input  data type: int [] {-4,1,3,-5,8} {-4,1,3,-5,8,0}
	 *       Output data type: int [] {-4,-5,3,1,8}
	 *       
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: Two pointers
	 *
	 * Pseudo code:
	 * Declare left pointer as 0 and right pointer as 1
	 * Traverse the array in while loop until right reaches the length of array
	 * If right points to a negative number and left points to positive number
	 * -------Then swap the var and increment both the pointers
	 * else if left points to a negative number > 0 then move the left pointer
	 * else do right ++
	 * Return the array
	 * 		
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {-3,-4,5,1,-2,-1};
		Assert.assertTrue(Arrays.equals(movePostiveIntToRight(nums), new int[] {-3,-4,-2,-1,5,1}));
	}

	@Test
	public void test2() {
		int[] nums = {5,6,5,1,-2,-1};
		Assert.assertTrue(Arrays.equals(movePostiveIntToRight(nums), new int[] {-2,-1,5,6,5,1}));
	}
	
	@Test
	public void test3() {
		int[] nums = {-2,-1};
		Assert.assertTrue(Arrays.equals(movePostiveIntToRight(nums), new int[] {-2,-1}));
	}

	private int[] movePostiveIntToLeft(int[] nums) {
		int left = 0, right = 0;
		while(right < nums.length) {
			if(nums[right] < 0) right++;
			else{
				int tmp = nums[right];
				nums[right++] = nums[left];
				nums[left++] = tmp;
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	private int[] movePostiveIntToRight(int[] nums) {
		int left = nums.length-1, right = nums.length-1;
		while(right >= 0) {
			if(nums[right] < 0) right--;
			else{
				int tmp = nums[right];
				nums[right--] = nums[left];
				nums[left--] = tmp;
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
