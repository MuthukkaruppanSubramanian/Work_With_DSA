package platform.leetcode.two_pointer;
import org.junit.*;
import java.util.*;

public class LC_1464_Maximum_Product_of_Two_Elements_in_an_Array {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {3,4,5,2};
		Assert.assertTrue(maxProduct(nums) == 12);
	}

	@Test
	public void test2() {
		int[] nums = {1,5,4,5};
		Assert.assertTrue(maxProduct(nums) == 16);
	}

	@Test
	public void test3() {
		int[] nums = {3,7};
		Assert.assertTrue(maxProduct(nums) == 21);
	}
	
	/*
	 * Pseudo Code
	 */
	
    public int maxProduct(int[] nums) {
        int maxValue = 0;
         for(int i =0; i < nums.length; i++){
             for(int j = i+1; j < nums.length; j++){
                 int currentproduct = ((nums[i] -1) * (nums[j]-1));
                 maxValue = Math.max(maxValue, currentproduct);
             }
         }
         return maxValue;
    }
    
    public int maxProductSort(int[] nums) {        
         Arrays.sort(nums);
         return ((nums[nums.length-1] -1) * (nums[nums.length-2] -1));
    }
    
    public int maxProductOnePass(int[] nums) {

        int max = Math.max(nums[0], nums[1]);
        int secondMax = Math.min(nums[0], nums[1]);
        if(nums.length> 2){
            for(int i = 2; i < nums.length; i++){
                if(nums[i] > max){
                    secondMax = max;
                    max = nums[i];
                }else if (nums[i] > secondMax && nums[i] != max){
                    secondMax = nums[i];
                }
            }
            System.out.println(max+" "+secondMax);
            return ((max-1) * (secondMax-1));
        } else {
            return ((max-1) * (secondMax-1));
        }
    }
}
