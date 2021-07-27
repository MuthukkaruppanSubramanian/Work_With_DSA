package dsa.two_pointer.algo;

import java.util.Arrays;

import org.junit.Test;

public class IncreaseSignificantNumbers {
	/*
	 * Given a non-empty array of decimal digits representing a non-negative
	 * integer, increment one to the integer.
	 * 
	 * The digits are stored such that the most significant digit is at the head of
	 * the list, and each element in the array contains a single digit.
	 * 
	 * You may assume the integer does not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * 
	 * Intput : int []
	 * Output : int []
	 * 
	 * Test Data:
	 * 
	 * Positive: [1,2,3,4] => [1,2,3,4,5]
	 * 
	 * Edge: [9], [9,9]
	 * 
	 * Approach: Brute force
	 * TimeComplexity : O(n)
	 * 
	 * Psuedo Code:
	 * 	a.On the give array traverse from that last element
	 *  b.if the last value is < 9 Increment the value by one and 
	 *    add it to the same index and return
	 *  c.else change the last value to 0 continue the same for other element
	 *  d.When the above if condition is not satisfied after for loop
	 *  e.Create a new arr with length+1 of the give array
	 *  f.on the first index add one and return the new array 
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,2,3};
		System.out.println(Arrays.toString(addOneToSigNumbers(nums)));
	}

	@Test
	public void test2() {
		int[] nums = {9};
		System.out.println(Arrays.toString(addOneToSigNumbers(nums)));
	}
	
	@Test
	public void test3() {
		int[] nums = {9,9};
		System.out.println(Arrays.toString(addOneToSigNumbers(nums)));
	}

	private int[] addOneToSigNumbers(int[] nums) {
		for (int i = nums.length-1; i >=0 ; i--) {
			if(nums[i] < 9) {
				nums[i] = nums[i]+1;
				return nums;
			}else nums[i] = 0;
		}
		int[] sigArray = new int[nums.length+1];
		sigArray[0] = 1;
		return sigArray;
	}
	
}
