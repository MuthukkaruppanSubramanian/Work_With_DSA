package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_09_Maximum_Width_Ramp_LC_962 {
	
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
		int[] nums = {6,0,8,2,1,5};
		Assert.assertTrue(maxWidthRamp(nums)==4);
	}

	@Test
	public void test2() {
		int[] nums = {9,8,1,0,1,9,4,0,4,1};
		Assert.assertTrue(maxWidthRamp(nums)==7);
	}

	@Test
	public void test3() {
		int[] nums = {4,2,3,1};
		Assert.assertTrue(maxWidthRamp(nums)==1);
	}
	
	/*
	 * Pseudo Code
	 */
	
	public int maxWidthRamp(int[] nums) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(0);
		int maxLength = 0;
		for(int i = 1; i < nums.length; i++) {
			queue.offer(i);
			if(nums[queue.peekFirst()] <= nums[i]) {
				maxLength = Math.max(maxLength, i-queue.peekFirst());
			}
		}
		while(!queue.isEmpty()) {
			int first = queue.peekFirst();
			int last  = queue.peekLast();
			if(nums[first] <= nums[last]) {
				maxLength = Math.max(maxLength, last-first);
				queue.pollFirst();
				queue.pollLast();
			}else {
				queue.poll();
			}
		}
		return maxLength;
	}
}













