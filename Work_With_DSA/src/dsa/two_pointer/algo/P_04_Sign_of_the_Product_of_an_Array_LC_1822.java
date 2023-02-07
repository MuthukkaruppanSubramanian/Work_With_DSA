package dsa.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_04_Sign_of_the_Product_of_an_Array_LC_1822 {
	
	/*
	 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
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
		int[] nums = {1,1,-2,-2};
		Assert.assertTrue(arraySign(nums) == 1);
	}

	@Test
	public void test2() {
		int[] nums = {1,1,0,-2};
		Assert.assertTrue(arraySign(nums) == 0);
	}

	@Test
	public void test3() {
		int[] nums = {1,1,2,-2};
		Assert.assertTrue(arraySign(nums) == -1);
	}
	
	/*
	 * Pseudo Code
	 */
	
    public int arraySign(int[] nums) {
        int left = 0, right = nums.length-1;
        double product = 1;
        for(int i = 0; i < nums.length; i++){
            product *= (nums[i]);
        }
        
        if(product == 0) return 0;
        
        return product > 0? 1 : -1;
    }
}
