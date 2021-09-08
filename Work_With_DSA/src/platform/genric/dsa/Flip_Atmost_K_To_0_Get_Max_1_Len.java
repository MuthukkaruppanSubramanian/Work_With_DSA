package dsa.contest.algo;
import org.junit.*;
import java.util.*;

public class Flip_Atmost_K_To_0_Get_Max_1_Len {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Two Pointer and Sliding Window using Tree set
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		Assert.assertTrue(getMaxLength(nums,k)==6);
	}

	@Test
	public void test2() {
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		Assert.assertTrue(getMaxLength(nums,k)==10);
	}

	@Test
	public void test3() {
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,1};
		int k = 3;
		Assert.assertTrue(getMaxLength(nums,k)==12);
	}
	
	/*
	 * Pseudo Code
	 * Declare a Tree set to store the flipped index of 0
	 * Declare left and right as 0
	 * Traverse the array in for loop till right reaches length of array
	 * ----if nums[i] == 0 and tree set size < k
	 * -------add the i to tree set
	 * --- else
	 * -------int tmp = left+1;
	 * -------while left < tmp
	 * ----------left++
	 * -------add the i to tree set
	 * get the max length
	 * 
	 * return max length
	 */
	
	private int getMaxLength(int[] nums, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		int left = 0, right = 0, maxLength = 0;
		for(right = 0; right < nums.length; right++) {
			if((nums[right] == 0) && (set.size() < k)) {
				set.add(right);
			}else if (nums[right] == 0){
				int tmp = set.first()+1;
				set.remove(set.first());
				while(left < tmp) {
					left++;
				}
				set.add(right);
			}
			maxLength = Math.max(maxLength, (right-left)+1);
		}
		return maxLength;
	}
	
}
