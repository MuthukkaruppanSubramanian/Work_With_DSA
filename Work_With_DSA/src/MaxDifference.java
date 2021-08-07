import java.util.*;
import org.junit.*;

public class MaxDifference {
	/* Given an int[] not sorted....find the maximum distance between any 2 values
	 * 
	 * Given Input  data type:int[] [3,6,2,7,4,1]
	 *       Output data type:int
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: using two pass
	 *
	 * Pseudo code:
	 * 
	 * 
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {3,6,2,7,4,1};
		Assert.assertTrue(findtheMaxDifference(nums)==6);
	}

	@Test
	public void test2() {
		int[] nums = {7,7,7,7,7};
		Assert.assertTrue(findtheMaxDifference(nums)==0);
	}

	@Test
	public void test3() {
		int[] nums = {-7,-4,-6,-1};
		Assert.assertTrue(findtheMaxDifference(nums)==6);
	}
	
	/*
	 * Declare the maxNum and minNum.
	 * Get the maxNum as array[0] and minNum array[0]
	 * Traverse the array with for loop 
	 * ---Compare the element with the maxNum value using Math.max function
	 * ---compare the element with the minSum value using Math.min function
	 * After the for loop get the difference of maxNum-minNum and return the value.
	 * 
	 */

	private int findtheMaxDifference(int[] nums) {
		int maxNum = nums[0], minNum = nums[0];
		for(int i=1; i<nums.length;i++) {
			maxNum = Math.max(maxNum, nums[i]);
			minNum = Math.min(minNum, nums[i]);
		}
		int tmp = maxNum-minNum;
		return maxNum-minNum;
	}
}
