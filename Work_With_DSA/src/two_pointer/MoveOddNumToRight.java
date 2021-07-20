package two_pointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MoveOddNumToRight {
	
	/*
	 * Move all the odd numbers to the right
	 * 
	 * Input: int[]
	 * Output: int[] - can be in any order
	 * 
	 * Test Data: 
	 * Positive: {2,5,7,8} => {2,8,5,7}
	 * 
	 * Edge: {4,6,3} => no change
	 *       {7}
	 * 
	 * Negative: {2,4,6} => {2,4,6}
	 * 
	 * Approach 1: Brute Force using Array list O(n) / O(n)
	 * Approach 2: Two Pointers o(n) / O(1)
	 * 
	 * Pseudo Code:
	 * 
	 * a. Start two pointers at the index 0
	 * b. Traverse the array until right reach end of the array
	 * c. if right is odd then right++
	 * d. else then swap the right and left and do left++, right++
	 * f. return the array 
	 * 
	 */
	
	//@Test
	public void test1() {
		int[] num = {4,5,8,7};
		Assert.assertTrue(Arrays.equals(moveOddToRightOpp(num), new int[] {4,8,5,7}));
	}

	//@Test
	public void test2() {
		int[] num = {4,8,5,7};
		Assert.assertTrue(Arrays.equals(moveOddToRightOpp(num), new int[] {4,8,5,7}));
	}
	
	@Test
	public void test3() {
		int[] num = {4,6,8,4};
		Assert.assertTrue(Arrays.equals(moveOddToRightEquiDir(num), new int[] {4,6,8,4}));
	}
	
	@Test
	public void test4() {
		int[] num = {4,6,8,4};
		Assert.assertTrue(Arrays.equals(moveOddToRightOpp(num), new int[] {4,8,6,4}));
	}
	
	private int[] moveOddToRightEquiDir(int[] num) {
		int left = 0, right=0;
		while(right < num.length) {
			if(num[right]%2==1) right++;
			else {
				int tmp = num[right];
				num[right++] = num[left];
				num[left++] = tmp;
			}
		}
		System.out.println(Arrays.toString(num));
		return num;
	}
	
	private int[] moveOddToRightOpp(int[] num) {
		int left = 0, right = num.length-1;
		while(left<=right) {
			if(num[left]%2==0 && num[right]%2==1) {
				left++; right--;
			}
			else {
					int tmp = num[right];
					num[right--] = num[left];
					num[left++] = tmp;
			}
		}
		return num;
	}
}
