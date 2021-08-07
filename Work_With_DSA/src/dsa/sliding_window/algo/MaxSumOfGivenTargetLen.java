package dsa.sliding_window.algo;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumOfGivenTargetLen {

	@Test
	public void test1() {
		int[] nums = {4,2,1,7,8,1,2,8,1,0};
		int e = 3;
		Assert.assertEquals(16, maxAvgSubArraySinglePass(nums, e),0);
	}
	
	@Test
	public void test2() {
		int[] nums = {4,2,1,7,8,10,2,8,1,0};
		int e = 3;
		Assert.assertEquals(25, maxAvgSubArrayTwoPass(nums, e),0);
	}
	
	public double maxAvgSubArraySinglePass(int[] nums, int k) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for(int i=0;i<nums.length;i++) {
			currentSum +=nums[i];
			if(i >=k-1) { //Loop execute when first k elements added to current sum
				maxSum = Math.max(maxSum, currentSum);
				currentSum -=nums[i-(k-1)];// Subtract the 1st element in k length
			}
		}
		return maxSum;
	}

	public double maxAvgSubArrayTwoPass(int[] nums, int k) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for(int i=0; i<k; i++) {
			currentSum +=nums[i];
		}
		maxSum = Math.max(maxSum, currentSum);
		for (int i = 1; i < nums.length-k; i++) {
			currentSum +=nums[i+k-1]-nums[i-1];
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
}
