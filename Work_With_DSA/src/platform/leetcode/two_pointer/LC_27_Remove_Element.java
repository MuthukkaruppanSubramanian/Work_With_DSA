package platform.leetcode.two_pointer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * 
 *
 * Sample Test Data 
 *    Input : 
 *    output: 
 *
 * Approach 1: 
 * 
 * Approach 2: 
 *
 * Pseudo code - Approach 1:
 *
 * Time / Space Complexity:
 * 		
 */

public class LC_27_Remove_Element {
	@Test
	public void example1() {
		int[] s = {1,2,3,4,6,2,1,2};
		removeElement(s,2);
	}

	@Test
	public void example2() {
		int[] s = {3,3};
		removeElement(s,3);
	}

    public int removeElement(int[] nums, int val) { 
        int left = 0, right = nums.length-1, count = 0;
        while(left <= right){
            if(nums[right] == val){
                right--;
                count++;
            }else if(nums[right] != val && nums[left] == val){
                int tmp = nums[right];
                nums[right--] = nums[left];
                nums[left++] = tmp;
                count++;
            }else left++;
        }
        return nums.length-count;
    }
}
