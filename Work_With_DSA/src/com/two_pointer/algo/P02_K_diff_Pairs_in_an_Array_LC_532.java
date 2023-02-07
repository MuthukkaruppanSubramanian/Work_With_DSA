package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P02_K_diff_Pairs_in_an_Array_LC_532 {

	/*1:22 - 1:38 
	 * 
	 *
	 * Sample Test Data 
	 *    Input : {-1,-2,-3} k =1
	 *    output: 2
	 *
	 * Approach 1: Two Pointer
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,2,3,4,5};
		int k = 1;
		Assert.assertTrue(findPairs(nums,k)==4);
	}

	@Test
	public void test2() {
		int[] nums = {1,2,1,4,5};
		int k = 0;
		Assert.assertTrue(findPairs(nums,k)==1);
	}

	@Test
	public void test3() {
		int[] nums = {1,2,3,4,5};
		int k = 10;
		Assert.assertTrue(findPairs(nums,k)==0);
		if(true && true) k = 5;
	}

	/* 1:38 to 1:45
	 * Pseudo Code
	 * Declare a set of integers and pairs = 0
	 * Iterate the array and add the values to set
	 * --if set.add return false and k = 0 increment the pairs
	 * iterate the set till length
	 * --if set.contains value+k increment the pairs counter
	 * return the pairs
	 */

	//coding 15
	//Debugging 6
	public int findPairs(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> outputSet = new HashSet<Integer>();
		int pairs = 0;
		for(int i : nums){
			if((!set.add(i)) && (k == 0)){
				if (!outputSet.contains(i)){
					pairs++;
					outputSet.add(i);
				}
			} 	
		}
		if(k!=0) {
			for(int i : set){
				if(set.contains(i+k)) pairs++;
			}            
		}
		return pairs;
	}
}
