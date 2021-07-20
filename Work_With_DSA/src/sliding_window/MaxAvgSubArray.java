package sliding_window;

import org.junit.Assert;
import org.junit.Test;

public class MaxAvgSubArray {

	@Test
	public void test1() {
		int[] nums = {0,1,1,3,3};
		int e = 4;
		Assert.assertEquals(2.0, maxAvgSubArray(nums, e),0);
	}
	
	public double maxAvgSubArray(int[] nums, int k) {
		if(nums.length == 1) return nums[0];
		int currentSum = 0;
		for(int i=0; i < k;i++){
			currentSum +=nums[i]; 
		}
		double maxSum = currentSum;
		for(int i=1; i <= nums.length-k;i++){
			currentSum += nums[i+k-1]-nums[i-1];
			maxSum = Math.max(currentSum,maxSum);
		}
		System.out.println(maxSum/k);
		return maxSum/k;
	}

}
