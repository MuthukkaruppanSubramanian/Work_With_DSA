package platform.leetcode.two_pointer;
import org.junit.*;
import java.util.*;

public class LC_11_Container_With_Most_Water {
	
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
		int[] height = {5,7,7,7,5};
		System.out.println(maxArea(height));
	}

	@Test
	public void test2() {
		int[] height = {1,2,3,4};
		System.out.println(maxAreaOptimized(height));
	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */
	
    public int maxArea(int[] height) {
        int maxStorage = 0;
        
        //Check the array is in ^ shape like decrease,increase,decrease [1,2,1]
        int left = 0, right = height.length-1;
        boolean leftside = false, rightside= false;
        while(left < height.length-1){
            int length = Math.min(height[left], height[right]);
            int breath = right-left;
            maxStorage = Math.max(maxStorage, (length*breath));
            right--;
            
            if(left==right){
                left++;
                right = height.length-1;
            }
        }
        return maxStorage;
    }
    
    public int maxAreaOptimized(int[] height) {
        int maxStorage = 0;
        int left = 0, right = height.length-1;
        while(left < right){
            int length = Math.min(height[left], height[right]);
            int breath = right-left;
            maxStorage = Math.max(maxStorage, (length*breath));
            if(length == height[left]) left++;
            else right--;
        }
        return maxStorage;
    }
}
