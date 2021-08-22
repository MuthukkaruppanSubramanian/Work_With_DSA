import java.util.*;
import org.junit.*;

public class Apple_Increasing_SubArray {
	
//	Question 1: 
//		Count the number of strictly increasing subarray of a specified size k in an array of size N .
//		Example 1:
//		int[] nums = [5,3,5,7,8] and k=3 , 
//		The answer is 2 as [3,5,7] and [5,7,8] are the sub arrays.
//		Example 2:
//		int[] nums = [ 5,3,5,7,8] and k=2 , 
//		The answer is 3 as [3,5] and [5,7] and [7,8] are the sub arrays.
	
	/*
	 * Sample Test Data 
	 *    Input : int[] nums = [5,3,5,7,8] and k=3
	 *    output: 1
	 *
	 * Approach 1: Two Pointers
	 * 
	 * Approach 2: 
	 * 
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {5,3,5,7,8};
		int k = 3;
		Assert.assertTrue(findIncreasingSubArray(nums, k)==2);
	}

	@Test
	public void test2() {
		int[] nums = {5,3,5,7,8};
		int k = 2;
		Assert.assertTrue(findIncreasingSubArray(nums, k)==3);
	}

	@Test
	public void test3() {
		int[] nums = {5,4,3,2};
		int k = 2;
		Assert.assertTrue(findIncreasingSubArray(nums, k)==0);
	}

	
	/*12:35
	 * Pseudo code
	 * Declare two pointer left = 0 and right =1 and counter = 0
	 * Traverse the array in while loop until right < array.length
	 * if nums[right] < nums[left] do left++;
	 * if right-left+1 == k
	 * -----counter++
	 * -----left++ and right = left;
	 * right++
	 * return counter
	 * 12:38
	 */
	
	//12:38 - 12:40
	private int findIncreasingSubArray(int[] nums, int k) {
		int left = 0, right =1, counter = 0;
		while(right < nums.length) {
			if(nums[right] < nums[left]) left++;
			if(right-left+1 == k) {
				counter++;
				left++;
				right = left;
			}
			right++;
		}
		return counter;
	}
}
