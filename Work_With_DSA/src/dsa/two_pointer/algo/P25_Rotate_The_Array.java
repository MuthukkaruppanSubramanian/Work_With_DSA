package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P25_Rotate_The_Array {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(rotateTheGivenArrayExtraSpace(nums,4)));
		System.out.println(Arrays.toString(roateArrayWithInPalce(nums,4)));
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */

	private int[] rotateTheGivenArrayExtraSpace(int[] nums, int k) {
        k %= nums.length;
        int[] output = new int[nums.length];
        int index = 0;
        for(int i = nums.length-k; i < nums.length; i++){
            output[index++] = nums[i];
        }
        for(int i = 0 ; i<nums.length-k;i++){
            output[index++] = nums[i];
        }
		return output;
	}

	
	private int[] roateArrayWithInPalce(int[] nums, int k) {
		k %= nums.length;
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
		return nums;
	}
	
	public int[] reverse(int[] nums, int left, int right) {
		while(left < right) {
			int tmp = nums[right];
			nums[right--] = nums[left];
			nums[left++] = tmp;
		}
		return nums;
	}





}
