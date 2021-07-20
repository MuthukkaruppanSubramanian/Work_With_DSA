package leetcode.twopointer.dsa;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class FlippingAnImage {
	/*
	 * Given Input  data type:int[] of []
	 *       Output data type: int[] of []
	 * Sample Test Data 
			Input: image = [[1,1,0],[1,0,1],[0,0,0]]
			Output: [[1,0,0],[0,1,0],[1,1,1]]
	 *
	 * Approach 1: Two Pointer
	 *
	 * Pseudo code:
	 * Create left and right pointer as 0
	 * Traverse the array in for loop
	 * For each array using two pointer the swap the left and right pointer if they are different
	 * In the next while if left or right pointer value  = 1 change it 0 or 0 to 1
	 * return the array
	 * Time / Space Complexity: O(n^2) / O(1)
	 * 		
	 */

	//@Test
	public void test1() {
		int[][] nums = {{1,1,0},{1,0,1},{0,0,0}};
		Assert.assertEquals(true, Arrays.equals((flipTheImage(nums)), new int[][] {{1, 0, 0},{0, 1, 0},{1, 1, 1}}));
	}

	@Test
	public void test2() {
		int[][] nums = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		Assert.assertEquals(true, Arrays.equals((flipTheImage(nums)), new int[][] {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}}));
	}

	@Test
	public void test3() {

	}

	public int[][] flipTheImage(int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			int left = 0, right = nums[i].length-1;
			while(left < right) {
				if(nums[i][left]!=nums[i][right]) {
					int tmp = nums[i][left];
					nums[i][left++] = nums[i][right];
					nums[i][right--] = tmp;
				}else {
					left++;right--;
				}
			}
			left = 0; right = nums[i].length-1;
			while(left <= right) {
				if(left!= right)nums[i][left] = (nums[i][left++]==0)? 1 :  0;
				nums[i][right] = (nums[i][right--]==0)? 1 :  0;
			}
			System.out.println(Arrays.toString(nums[i]));
		}
		return nums;
	}
}
