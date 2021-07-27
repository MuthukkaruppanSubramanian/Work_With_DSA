package dsa.sliding_window.algo;

import org.junit.Test;

public class MaxSumInConsecutiveSeq {
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
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] num = {1,-5,2,-3,7,1};
		System.out.println(maxSum(num));
	}
	
	@Test
	public void test2() {
		int[] num = {1,2,3,4};
		System.out.println(maxSum(num));
	}
	
	@Test
	public void test3() {
		int[] num = {-50,50};
		System.out.println(maxSum(num));
	}
	
	@Test
	public void test4() {
		int[] num = {-50,-10,-20};
		System.out.println(maxSum(num));
	}
	
	//{1,-5,2,-3,7,1}
	private int maxSum(int[] num) {
		int max = Integer.MIN_VALUE, lastsum=0;
		for (int i = 0; i < num.length; i++) {
			lastsum=0;
			for (int j = i; j < num.length; j++) {
				lastsum += num[j];
				max = Math.max(max, lastsum);
			}
		}
		return max;
	}
}
