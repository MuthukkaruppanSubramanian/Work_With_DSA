package platform.leetcode.two_pointer;
import org.junit.*;
import java.util.*;

public class LC_1_Two_Sum {
	
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

	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */
	
    public int[] twoSumTwoPass(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        
        for(int i = 0; i< nums.length; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                if(map.get(rem) != i){
                    return new int[] {i, map.get(rem)};
                }
            }
        }
        return new int[] {-1,-1};
    }
    
    public int[] twoSumOnePass(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
            	return new int[] {i, map.get(rem)};
            }else {
            	map.put(nums[i],i);
            }
        }
        return new int[] {-1,-1};
    }
}
