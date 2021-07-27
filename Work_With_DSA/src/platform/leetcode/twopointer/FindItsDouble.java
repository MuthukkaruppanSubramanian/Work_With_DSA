package platform.leetcode.twopointer;


import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FindItsDouble {
	
	/*
	 * Given an array arr of integers, check if there exists two integers N and M
	 * such that N is the double of M ( i.e. N = 2 * M).
	 * 
	 * More formally check if there exists two indices i and j such that :
	 * 
	 * i != j 0 <= i, j < arr.length arr[i] == 2 * arr[j]
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [10,2,5,3] Output: true Explanation: N = 10 is the double of M =
	 * 5,that is, 10 = 2 * 5.
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
	 * Declare left = 0 and right = array.length-1
	 * Then check which point hold the less value and multiply that by 2
	 * if that equals other point then return true
	 * else increase the lesser value index.
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {10,2,4,3};
		System.out.println(checkIfDoubleExists(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {7,1,14,11};
		System.out.println(checkIfDoubleExists(nums));
	}
	
	@Test
	public void test3() {
		
	}
	
    public boolean checkIfDoubleExists(int[] nums) {
    	int left = 0, right = nums.length-1;
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i =0; i<nums.length;i++) {
    		if(set.contains(nums[i]*2) || (nums[i]%2==0 && set.contains(nums[i]/2)))
    			return true;
    		else
    			set.add(nums[i]);
    	}
     return false;
 }
}
