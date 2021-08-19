import java.util.*;
import org.junit.*;

public class LC_42_Trapping_Rain_Water {
	
	/*
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: 
	 * 
	 * Approach 2: 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		Assert.assertTrue(getTrappingRainWater(nums)==6);
	}

	@Test
	public void test2() {
		int[] nums = {4,2,0,3,2,5};
		Assert.assertTrue(getTrappingRainWater(nums)==9);
	}

	@Test
	public void test3() {
		int[] nums = {3,2,1,0,0,0};
		Assert.assertTrue(getTrappingRainWater(nums)==0);
	}
	
	@Test
	public void test4() {
		int[] nums = {4,2,3};
		Assert.assertTrue(getTrappingRainWater(nums)==1);
	}
	
	/*
	 * Pseudo code
	 * Declare two variable one for actualCapacity and other is temp
	 * Declare two pointer to traverse the array
	 * Traverse the array till left pointer reaches array lenght-1
	 * Check if left > right
	 * ----add temp var with left-right and do right++
	 * else
	 * ----if tmp > 0
	 * -------- add count value to tmp and tmp = 0
	 * --------- left = right and right++
	 * ----else left++ and right++
	 * if right reaches array.length-1
	 * -----tmp = 0 and left++ and right = left+1
	 * return count
	 * 
	 */
	
	public int getTrappingRainWater(int[]nums) {
		int actualCapacity = 0, tmp = 0;
		int left = 0, right =1;
		while(left < nums.length-1 && right < nums.length) {
			if(nums[left] > nums[right]) {
				tmp += nums[left]-nums[right++];
			}else {
				if(tmp > 0) {
					actualCapacity += tmp;
					tmp = 0;
					left = right;
					right++;
				}else {
					left++;right++;
				}
			}
			if(right >= nums.length-1 && left == nums.length-1) return actualCapacity;
			if(right >= nums.length-1) {
				if(nums[left] > nums[right] && nums[right-1] >= nums[right]) {
					tmp = 0; left++; right = left+1;
				}
			}
		}
		return actualCapacity;
	}
}















