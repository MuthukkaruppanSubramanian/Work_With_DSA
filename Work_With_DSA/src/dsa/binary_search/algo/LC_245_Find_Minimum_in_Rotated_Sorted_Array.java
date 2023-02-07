package dsa.binary_search.algo;
import org.junit.*;
import java.util.*;

public class LC_245_Find_Minimum_in_Rotated_Sorted_Array {
	
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
		int[] nums = {14,15,20,25,10};
		System.out.println(findMin(nums));
	}

	@Test
	public void test2() {//[3,4,5,1,2]
		int[] nums = {5,1,2,3,4};
		System.out.println(findMin(nums));
	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */
	
    public int findMin(int[] nums) {
        
        /*
        *   Declare high, low and mid
        *   while(left < right)
        *       if
        *       Check which end is lower
        *       move the low or high accordingly
        */
        
        int low = 0, high = nums.length-1;
        int mid = (low+high)/2;
        if((nums[low] < nums[high]) && (nums[low] < nums[mid])) return nums[low];
        if(nums[mid] < nums[high]) high = mid;
        else low = mid;
        while(low <= high){
            mid = (low+high)/2;
            if(high-low == 1) return Math.min(nums[high], nums[low]);
            if((nums[low] == nums[high]) && (nums[low] == nums[mid])) return nums[low];
            if(nums[mid] < nums[high]) high = mid;
            else low = mid;
        }
        return -1;
    }
    
    public int findMinOptimized(int[] nums) {
        
        /*
        *   Declare high, low and mid
        *   while(left < right)
        *       if
        *       Check which end is lower
        *       move the low or high accordingly
        */
        
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(high-low == 1) return Math.min(nums[high], nums[low]);
            if((nums[low] == nums[high]) && (nums[low] == nums[mid])) return nums[low];
            if(nums[mid] < nums[high]) high = mid;
            else low = mid;
        }
        return -1;
    }
}
