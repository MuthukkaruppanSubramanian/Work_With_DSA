package platform.leetcode.two_pointer;
import java.util.*;
import org.junit.*;

public class SquareAndReturnArrayInSorted {
	/*
	 * Given an integer array nums sorted in non-decreasing order, return an array
	 * of the squares of each number sorted in non-decreasing order.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100] Explanation: After
	 * squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes
	 * [0,1,9,16,100]. Example 2:
	 * 
	 * Input: nums = [-7,-3,2,3,11] Output: [4,9,9,49,121]
	 */
	
	/* 
	 * Given Input  data type:
	 *       Output data type:
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {-4,-1,0,3,10};
		System.out.println(Arrays.toString(getSortedSquareArray(nums)));
	}

	@Test
	public void test2() {
		int[] nums = {-7,-3,2,3,11};
		System.out.println(Arrays.toString(getSortedSquareArray(nums)));
	}

	@Test
	public void test3() {
		int[] nums = {4,2,5,7};
		System.out.println(Arrays.toString(sortArrayByParityII(nums)));
	}
	
	/*
	 * Pseudo Code:
	 * 
	 */
	
	private int[] getSortedSquareArray(int[] nums) {
		int left = 0, right = nums.length-1, i = nums.length-1;
		int[] result = new int[nums.length];
		while(left <= right) {
			int leftElement = nums[left] * nums[left];
			int rightElement = nums[right] * nums[right];
			if(leftElement > rightElement) {
				result[i] = leftElement;
				left++;
			}else {
				result[i] = rightElement;
				right--;
			}
			i--;
		}
		return result;
	}
	
    public int[] sortArrayByParityII(int[] nums) {
        int left = 0, right = 1;
        while(right < nums.length && left < nums.length) {
            if(nums[left] %2 ==0) {
                left+=2;
            }else if(nums[right]%2 != 0){
                right+=2;
            }else{
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left+=2;
                right+=2;
            }
        }
        return nums;
    }
}






















