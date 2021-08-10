package dsa.sliding_window.algo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindSubArrayOfGivenK {

	
	@Test
	public void test1() {
		int[] nums = {4,6,3,0,2};
		int k = 3;
		Assert.assertTrue(Arrays.equals(findSubArrayOfGivenK(nums, k), new int[] {3,0,2}));
	}

	@Test
	public void test2() {
		int[] nums = {4,6,3,0,2};
		int k = 1;
		Assert.assertTrue(Arrays.equals(findSubArrayOfGivenK(nums, k), new int[] {0}));
	}

	@Test
	public void test3() {
		int[] nums = {4,6,3,0,2};
		int k = 8;
		Assert.assertTrue(Arrays.equals(findSubArrayOfGivenK(nums, k), new int[] {}));
	}

	private int[] findSubArrayOfGivenK(int[] nums, int k) {
		if(k>nums.length-1) return new int[] {};
		int minSum = Integer.MAX_VALUE, endPos = 0;
		int currentSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];
			if(i>=k-1) {
				minSum = Math.min(currentSum, minSum);
				if(currentSum == minSum) {
					endPos = i; 
				}
				currentSum -=nums[i-(k-1)];
			}
		}
		if(k==1) {
			return new int[] {nums[endPos]};
		}else if(endPos == nums.length-1)
			return Arrays.copyOfRange(nums, Math.abs(endPos-(k-1)), endPos+1);
		else
			return Arrays.copyOfRange(nums, Math.abs(endPos-(k-1)), endPos);
	}
	

}
