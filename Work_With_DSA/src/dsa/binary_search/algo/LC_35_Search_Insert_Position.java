package dsa.binary_search.algo;

import org.junit.Test;

/**
 * @author 60026865
 *
 */
public class LC_35_Search_Insert_Position {
	@Test
	public void test1() {
		int[] nums = {1,3,5,6};
		int target = 2;
		searchInsert(nums, target);
	}

	@Test
	public void test2() {
		int[] nums = {1,3,5,6};
		int target = 7;
		searchInsert(nums, target);
	}

	@Test
	public void test3() {
		int[] nums = {1,3,7,8,9};
		int target = 5;
		searchInsert(nums, target);
	}
	
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
	
    public int searchInsert(int[] nums, int target) {
        int high = nums.length-1, low = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(target == nums[mid]) return mid;
            else if(target < nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
