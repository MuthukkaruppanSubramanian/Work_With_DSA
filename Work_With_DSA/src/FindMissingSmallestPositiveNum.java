import java.util.*;
import org.junit.*;

public class FindMissingSmallestPositiveNum {
	
	/*
	 * Given an unsorted integer array nums, return the smallest missing positive
	 * integer.
	 * 
	 * You must implement an algorithm that runs in O(n) time and uses constant
	 * extra space.
	 * 
	 * Given Input  data type: nums = [1,2,0]
	 *       Output data type: int 3
	 *
	 * Approach 1:
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,2,0};
		Assert.assertTrue(findSmallestMissingNum(nums)==3);
	}

	@Test
	public void test2() {
		int[] nums = {3,4,-1,1};
		Assert.assertTrue(findSmallestMissingNum(nums)==2);
	}

	@Test
	public void test3() {
		int[] nums = {7,8,9,11,12};
		Assert.assertTrue(findSmallestMissingNum(nums)==1);
	}
	
	/*
	 * Pseudo Code: Approach 1
	 * 
	 */
	
	private int findSmallestMissingNum(int[] nums) {
		int small = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if(set.first()>=2) return 1;
		for (Integer integer : set) {
			if(!set.contains(integer+1) && ((integer+1)!=0)) small = integer+1;
			if(small > 0) break;
		}
		if(small <=0) return 1;
		return set.last()+1;
	}
}
