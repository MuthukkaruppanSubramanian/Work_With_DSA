package com.two_pointer.algo;
import java.util.*;
import org.junit.Test;

public class P_15_Relative_Sort_Array_LC_1122 {

	/*
	 * https://leetcode.com/problems/relative-sort-array/
	 *
	 * Approach 1: Hashing
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] nums2 = {2,1,4,3,9,6};
		System.out.println(relativeSortArray(nums1, nums2));
	}


	/*
	 * Pseudo Code
	 * 	Declare a TreeMap and index = 0
		Iterate the arr1 in for each loop and key as each element and its occurrence as values.
		Iterate the arr2 in for each loop
			a. Get the no.of occurrence of the element
			b. Iterate that no.of times and add the value to arr1 using index
			c. Then remove that element from tree map
		Iterate the tree map to add the remaning values to arr[1]
		Return the arr1
	 */

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer,Integer> array1 = new TreeMap<Integer,Integer>();
		for(int i : arr1){
			array1.put(i, array1.getOrDefault(i,0)+1);
		}
		int index = 0;
		for(int i : arr2){
			int itr = array1.get(i);
			while(itr > 0){
				arr1[index++] = i;
				itr--;
			}
			array1.remove(i);
		}

		for(Map.Entry<Integer,Integer> set : array1.entrySet()){
			int itr = set.getValue();
			while(itr > 0){
				arr1[index++] = set.getKey();
				itr--;
			}
		}
		return arr1;
	}
}
