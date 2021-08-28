
package platform.genric.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;



public class Find_Max_Increasing_order {

	@Test
	public void test1() {
		int[] nums = {4,1,2,5,6,7,8,15,10,11,16};
		Assert.assertTrue(Arrays.equals(getIncreasingOrder(nums), new int[] {1,2,5,6,7,8,10,11,16}));
	}

	@Test
	public void test2() {
		int[] nums = {4,1,5,6,16};
		Assert.assertTrue(Arrays.equals(getIncreasingOrder(nums), new int[] {1,5,6,16}));
	}

	@Test
	public void test3() {
		int[] nums = {4,3,2,1};
		Assert.assertTrue(Arrays.equals(getIncreasingOrder(nums), new int[] {1}));
	}
	
	/*
	 * Approach 1: Look in fordward and backward direction to compare all elements
	 * 
	 * Pseudo code - Approach 1:
	 * add first value to list //4
		travese the arr from index 1
		if num > list last add to list
		else
			int j = 0;
			Until num > list.get(j) increase j value
			when condition breaks check j == list size-1
				then relace last value of set with current num
		return list as array
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	private int[] getIncreasingOrder(int[] nums) {
		List<Integer> increaseList = new ArrayList<>();
		increaseList.add(nums[0]); // add first index value by default
		
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > increaseList.get(increaseList.size()-1)) {
				increaseList.add(nums[i]);
			}else {
				int j = 0;
				while(nums[i] > increaseList.get(j)) {
					j++;
				}
				if(j == increaseList.size()-1) {
					increaseList.set(j, nums[i]);
				}
			}
		}
		
		// To convert a Integer list to Integer array
		//Integer[] output = new Integer[increaseList.size()];
		//output = increaseList.toArray(output);
		
		// To convert a integer list to int [] in java 8 using stream
		System.out.println(increaseList);
		int[] output = increaseList.stream().mapToInt(i->i).toArray();
		return output;
	}
}























