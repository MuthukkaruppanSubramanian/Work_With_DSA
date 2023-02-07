package dsa.two_pointer.sdte3;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

public class Longest_Sub_Arr_Remove_one_0_LC_1493 {
	/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - integer array
	 * What is the expected output? - integer
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : [1,1,0,1] => 3
	 *   
	 *  Edge     : {1,1,1} => 2
	 *  
	 *  Negative : {0,0,0} => 0
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those? Yes
	 *	No � That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Sliding Window / Two Pointer
	 *  
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 *
	 */

	@Test
	public void test1() {
		int[] input = {1,1,0,1};
		Assert.assertTrue(longestSubarray(input)==3);
	}

	@Test
	public void test2() {
		int[] input = {0,1,1,1,0,1,1,0,1};
		Assert.assertTrue(longestSubarray(input)==5);
	}

	@Test
	public void test3() {
		int[] input = {0,0,0};
		System.out.println(longestSubarray(input));
	}

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Two Pointer
	 * 
	 * Declare left = 0, right = 0, lastZeroPos = 0, currentZeroPos = 0, max = 0, boolean foundZero as true;
	 * Iterate the nums in while loop till right reaches the length of array
	 * 	----if nums of right == 0 
	 * 		----Then check if foundzero then assign lastZeroPos = right, currentZeroPos = right and foundZero = false; 
	 * 		----else lastZeroPos = currentZeroPos, currentZeroPos = right and left = lastZeroPos+1;
	 * 	find the max bwt taking absolute of (left-right)-1 and max
	 * 	increment right
	 * return max
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */


    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, max = 0, lastZeroPos=0, currentZeroPos=0;
        boolean foundZero = true;
        while(right < nums.length){
            
            if(nums[right] == 0){
                if(foundZero){
                    lastZeroPos = right;
                    currentZeroPos=right;
                    foundZero = false;
                }else{
                    lastZeroPos=currentZeroPos;
                    currentZeroPos=right;
                    left = lastZeroPos+1;
                }
            }
            max = Math.max(Math.abs(left-right),max);
            right++;
        }
        return max;
    }

}

