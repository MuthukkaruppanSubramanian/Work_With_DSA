package dsa.two_pointer.algo;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;


public class MergeArray {

	/*
	 * P1) Merge Sorted Array
	 * 
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
	 * order, and two integers m and n, representing the number of elements in nums1
	 * and nums2 respectively.Merge nums1 and nums2 into a single array sorted in
	 * non-decreasing order.
	 * 
	 * The final sorted array should not be returned by the function, but instead be
	 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
	 * n, where the first m elements denote the elements that should be merged, and
	 * the last n elements are set to 0 and should be ignored. nums2 has a length of
	 * n.   Example 1:
	 * 
	 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output:
	 * [1,2,2,3,5,6] Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
	 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
	 * from nums1.
	 * 
	 * Pseudo Code:
	 * a.sort the given nums1 and nums1 start index should be nums.length
	 * c.Now compare the two arrays in a while loop until last value added to nums1
	 * e. if(left == right) then insert both the value at consecutive position and increment counter twice
	 * f.Compare left and right value place the min value at counter position and increase the pointer
	 * 
	 */
	
	@Test
	public void test1() {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		Assert.assertEquals(Arrays.equals(mergeArray(nums1, nums2), new int[] {1,2,2,3,5,6,}), true);
	}
	
	@Test
	public void test2() {
		int[] nums1 = {2,5,6,0,0,0};
		int[] nums2 = {2,5,6};
		Assert.assertEquals(Arrays.equals(mergeArray(nums1, nums2), new int[] {2,2,5,5,6,6}), true);
	}
	
	@Test
	public void test3() {
		int[] nums1 = {2,5,6,7,0,0};
		int[] nums2 = {1,2};
		Assert.assertEquals(Arrays.equals(mergeArray(nums1, nums2), new int[] {1,2,2,5,6,7}), true);
	}
	
	@Test
	public void test4() {
		int[] nums1 = {0};
		int[] nums2 = {1};
		Assert.assertEquals(Arrays.equals(mergeArray(nums1, nums2), new int[] {1}), true);
	}
	
	@Test
	public void test5() {
		int[] nums1 = {1,0};
		int[] nums2 = {0};
		Assert.assertEquals(Arrays.equals(mergeArray(nums1, nums2), new int[] {0,1}), true);
	}
	
	public int[] mergeArray(int[]nums1, int[]nums2) {
		int left = 0, right = 0, nums1StartIndex = nums2.length;
		if(nums1.length==1) {
			nums1[0] = nums2[0];
			return nums1;
		}
		Arrays.sort(nums1);
		while(left < nums1.length) {
			nums1[left++] = (nums1[nums1StartIndex] < nums2[right])? nums1[nums1StartIndex++] : nums2[right++];
			if(nums1StartIndex >= nums1.length) {
				nums1StartIndex--;
				nums1[nums1StartIndex] = nums2[nums2.length-1];
			}else if (right >= nums2.length) {
				right--;
				nums2[right] = nums1[nums1.length-1];
			}
		}
		System.out.println(Arrays.toString(nums1));
		return nums1;
	}
	
}
