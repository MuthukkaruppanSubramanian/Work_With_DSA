package dsa.sliding_window.algo;

import org.junit.Test;

public class MinSubArrayLen {
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
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		System.out.println(minSubArrayLen(target, nums)); 
	}
	
	//@Test
	public void test2() {
		int[] nums = {1,4,4};
		int target = 4;
		System.out.println(minSubArrayLen(target, nums)); 
	}
	
	@Test
	public void test3() {
		
	}
	
    public int minSubArrayLen(int target, int[] nums) {
        
//      Decalre two pointers start at 0, maxSum as Integer Max value, minIndicies
//      Traverse the array until right < array.len
//      while max < target check if left and right++ are at same position then add any one
//          else max +=array[left]+array[right++]
//      if sum >= target
//          then compare the indicies with Math.min if current min is equal the new min
//          then add the max value using Math.max.
//          max -=array[left++]
//              right--
         
     int left = 0; 
     int right = 0; 
     int max= 0; 
     int minIndex=Integer.MAX_VALUE;
     for(right =0; right < nums.length; right++){
         max +=nums[right];
         while(max >= target) {
             minIndex = Math.min(minIndex,right+1-left);
             max -=nums[left++];
         }
     }
     return minIndex;
 }
}
