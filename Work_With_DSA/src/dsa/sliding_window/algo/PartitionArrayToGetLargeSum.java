package dsa.sliding_window.algo;
import java.util.*;
import org.junit.*;

public class PartitionArrayToGetLargeSum {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * Pseudo code:
	 * 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,15,7,9,2,5,10};
		int k = 3;
		Assert.assertTrue(maxSumAfterPartitioning(nums, k)==84);
	}

	@Test
	public void test2() {
		int[] nums = {1,4,1,5,7,3,6,1,9,9,3};
		int k = 4;
		Assert.assertTrue(maxSumAfterPartitioning(nums, k)==83);
	}

	@Test
	public void test3() {

	}
	

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int i, j, n = arr.length, max;
        int[] dp = new int[n+1];
        System.out.println(Arrays.toString(arr));
        for(i = 1; i <= n; ++i)
        {
        	max = arr[i-1];
        	for(j = 1; ((j <= k) && (i-j>=0)); ++j)
        	{
        		max = Math.max(max, arr[i-j]);
        		dp[i] = Math.max(dp[i], dp[i-j]+j*max);
        	}
        }
        return dp[n];
    }
}
