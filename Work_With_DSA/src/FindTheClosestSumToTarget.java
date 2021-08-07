import java.util.*;
import org.junit.*;

public class FindTheClosestSumToTarget {
	/* int[] sum of any two numbers less than than target value, 
	 * find the max or closest sum which is less than K
	 * 
	 * Given Input  data type: int[] {7,5,4,3,2} k =10 
	 *       Output data type: {0,4}
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: Nested For Loop
	 *
	 * 
	 * Time / Space Complexity: O(n^2) / O(1)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {7,5,4,3,2};
		int k = 10;
		Assert.assertTrue(Arrays.equals(getMinClosestSum(nums,  k), new int[] {1,2}));

	}

	@Test
	public void test2() {
		int[] nums = {6,4,5,3,5};
		int k = 9;
		Assert.assertTrue(Arrays.equals(getMinClosestSum(nums,  k), new int[] {3,4}));
	}

	@Test
	public void test3() {
		int[] nums = {7,7,7,7};
		int k = 10;
		Assert.assertTrue(Arrays.equals(getMinClosestSum(nums,  k), new int[] {-1,-1}));
	}
	
	/*
	 * Pseudo Code:
	 * Declare the min value to integer min value
	 * Traverse the array in nested for loop, outer start at i
	 * Inner loop starts at i+1 till length of array
	 * if the sum value is < target then check the min vlaue and store to min
	 * sum = 0
	 * return the min
	 */
	
	private int[] getMinClosestSum(int[] nums, int k) {
		int minSum = Integer.MIN_VALUE;
		int[] minSumIndex = {-1,-1};
		for (int i = 0; i < nums.length; i++) {
			for (int j =i+1; j < nums.length; j++) {
				int sum = nums[i]+nums[j];
				if(sum < k) {
					minSum = Math.max(minSum, sum);
					if(minSum == sum) {
						minSumIndex[0] = i;
						minSumIndex[1] = j;
					}
				}
				sum = 0;
			}
		}
		return minSumIndex;
	}
}






















