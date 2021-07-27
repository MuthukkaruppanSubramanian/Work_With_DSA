package dsa.two_pointer.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ReArrangePositiveNegative {
	/* Given an int[] {100,101,102,-5,-10,-11} rearrange in positive and negative alternative nums
	 * 
	 * Given Input  data type: int[] {100,101,102,-5,-10,-11}
	 *       Output data type: int[] {100,-10,102,-5,101,-11}
	 * Sample Test Data 
	 *    Input : int[] {100,101,102,-5,-10,-11}
	 *    output: int[] {100,-10,102,-5,101,-11}
	 *
	 * Approach 1: Two Pointers
	 *
	 * Pseudo code:
	 * Declare left = 0 and right = 1
	 * Traverse array until right less than given array length
	 * if left > 0 and right < 0 move left and right +2
	 * if not then check left and right > 0 move left+2
	 * else check left < 0 and right > 0 swap left and right and each +2
	 * else move right +2
	 * return the array
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {100,101,102,-5,-10,-11};
		Assert.assertTrue(Arrays.equals(reArrangePositiveNegativeNums(nums), new int[] {100,-10,102,-5,101,-11}));
	}

	@Test
	public void test2() {
		int[] nums = {-100,-101,-200,10,20,30};
		Assert.assertTrue(Arrays.equals(reArrangePositiveNegativeNums(nums), new int[] {10,-101,30,-100,20,-200}));
	}

	@Test
	public void test3() {
		int[] nums = {-100,101,-200,10,-20,30};
		Assert.assertTrue(Arrays.equals(reArrangePositiveNegativeNums(nums), new int[] {101,-100,10,-200,30,-20}));
	}

	public int[] reArrangePositiveNegativeNums(int[] nums) {
		int left = 0, right = 1;
		while(right < nums.length && left < nums.length) {
			if(nums[left] > 0 && nums[right] < 0) {
				left +=2; right +=2;
			}else if (nums[left] > 0 && nums[right] > 0) {
				left +=2;
			}else if(nums[left] < 0 && nums[right] > 0) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left +=2; right +=2;
			}else right +=2;
		}
		return nums;
	}
}
