package dsa.two_pointer.sdte3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParity_Leetcode_905 {
	/*
	 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in
	 *  the array such that nums[i] == nums[j] and abs(i - j) <= k
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - integer array and int k
	 * What is the expected output? - boolean
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : {1,2,3,1}, 3 => true
	 *   
	 *  Edge     : {1,1,2,2}, 1 => true
	 *  
	 *  Negative : {1,2,3,4,1},2 => false
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
	 *  Approach 1: Using HashMap
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
		int[] input = {1,2,3,1};
		int k = 3;
		Assert.assertTrue(containsNearbyDuplicate(input,k));
	}

	@Test
	public void test2() {
		int[] input = {1,1,2,2};
		int k  = 1;
		Assert.assertTrue(containsNearbyDuplicate(input,k));
	}


	@Test
	public void test3() {
		int[] input = {4,3,5,2,6,7};
		int k = 3;
		Assert.assertFalse(containsNearbyDuplicate(input,k));
	}

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: HashMap
	 *  Declare a Map
	 *  Iterate the array till its length
	 *    check if current element exists in map and check if current index - get the element of the value from <=k
	 *     ----then return true
	 *    Add current number as key and index as value
	 *   if no match by default return false
	 *   
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	
	private boolean containsNearbyDuplicate(int[] input, int k) {
        Map<Integer,Integer> num = new HashMap<Integer,Integer>();
        for(int i=0;i<input.length;i++){
            if(num.containsKey(input[i]) && i-num.get(input[i]) <= k) return true;
            num.put(input[i],i);
        }
        return false;
	}

}

