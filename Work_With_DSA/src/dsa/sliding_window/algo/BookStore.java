package dsa.sliding_window.algo;

import org.junit.Test;

public class BookStore {
	/*
	 * Today, the bookstore owner has a store open for customers.length minutes.
	 * Every minute, some number of customers (customers[i]) enter the store, and
	 * all those customers leave after the end of that minute. On some minutes, the
	 * bookstore owner is grumpy. If the bookstore owner is grumpy on the i-th
	 * minute, grumpy[i] = 1, otherwise grumpy[i] = 0. When the bookstore owner is
	 * grumpy, the customers of that minute are not satisfied, otherwise they are
	 * satisfied. The bookstore owner knows a secret technique to keep themselves
	 * not grumpy for X minutes straight, but can only use it once. Return the
	 * maximum number of customers that can be satisfied throughout the day.
	 * 
	 * Example 1: Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1],
	 * X = 3 Output: 16 Explanation: The bookstore owner keeps themselves not grumpy
	 * for the last 3 minutes. The maximum number of customers that can be satisfied
	 * = 1 + 1 + 1 + 1 + 7 + 5 = 16.
	 */
	
	/*
	 * Given Input  data type: int [] , int[] and int x
	 *       Output data type: output int
	 * Sample Test Data 
	 *    Input : customers = [1,0,1,2,1,1,7,5] grumpy = [0,1,0,1,0,1,0,1] X = 3
	 *    output: 16
	 *
	 * Approach 1: Sliding Window with 2 pointer
	 *
	 * Pseudo code:
	 * Find the max sum of consecutive x and store it.
	 * traverse the customer and grumpy array and use two pointer till the maxSum start index
	 * calculate the sum and add with maxSum and return it
	 * 
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int x = 3;
		System.out.println(maxNoOfCustomers(customers, grumpy, x));
	}
	
	@Test
	public void test2() {
		int[] customers = {1,7,5};
		int[] grumpy = {0,1,0};
		int x = 1;
		System.out.println(maxNoOfCustomers(customers, grumpy, x));
	}
	
	@Test
	public void test3() {
		int[] customers = {1,7,5,8};
		int[] grumpy = {0,1,1};
		int x = 2;
		System.out.println(maxNoOfCustomers(customers, grumpy, x));
	}
	
	private int maxNoOfCustomers(int[] customers, int[] grumpy, int x) {
		int max=0, left = 0, right = 0, lastSum=0, startindex=0;
		for(int i=0;i <x;i++) {
			lastSum +=customers[i];
		}
		max = Math.max(max, lastSum);
		for(int i=1;i<=customers.length-x;i++) {
			lastSum += customers[i+x-1]-customers[i-1];
			max = Math.max(max, lastSum);
			if(max == lastSum)startindex = i;
		}
		lastSum= startindex+x-1;
		while(right < grumpy.length) {
			if(left==startindex) {
				left++;
				right++;
				if(left <= lastSum) startindex++;;
			}else if(grumpy[right++]==0) {
				max +=customers[left++];
			}else left++;
		}
		
		return max;
	}
}
