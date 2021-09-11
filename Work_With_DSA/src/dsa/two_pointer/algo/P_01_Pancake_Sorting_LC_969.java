package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_01_Pancake_Sorting_LC_969 {
	
	/*
	  	Given an array of integers arr, sort the array by performing a 
	  	series of pancake flips.
		In one pancake flip we do the following steps:
		
		Choose an integer k where 1 <= k <= arr.length.
		Reverse the sub-array arr[0...k-1] (0-indexed).
		For example, if arr = [3,2,1,4] and we performed a pancake flip 
		choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] 
		after the pancake flip at k = 3.
		
		Return an array of the k-values corresponding to a sequence of pancake 
		flips that sort arr. Any valid answer that sorts the array within 10 * arr.length 
		flips will be judged as correct. 

	 * Approach 1: Two pointer
	 * 
	 *
	 * Time / Space Complexity:O(n*m) / O(n)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {2,1,3,4};
		Assert.assertTrue(pancakeSort(nums).equals(Arrays.asList(2,4,4)));
	}

	@Test
	public void test2() {
		int[] nums = {3,2,4,1};
		Assert.assertTrue(pancakeSort(nums).equals(Arrays.asList(2,3,4)));
	}

	@Test
	public void test3() {
		int[] nums = {5,3,1,2,4};
		Assert.assertTrue(pancakeSort(nums).equals(Arrays.asList(3, 5, 2, 4, 3, 2, 5)));
	}
	
	/*
	 * Pseudo Code
	 * Declare a output list and k =1
	 * while k <= arr.length run the loop
	 * ----call a function(getIndex) to get the index of k
	 * ----if index of k == arr.length-k increment k and continue
	 * ----else
	 * --------if index == 0 reverse the full array and add the arr.length-k+1
	 * --------else reverse the from 0 to till that index and add index+1 to list
	 * -------------then reverse the array from 0 to arr.length-k and add the arr.length-k+1
	 * return the list
	 */
	
    public int getTheKIndex(int k, int[] arr){
        int left = 0, right = arr.length-1;
        while(left <= right){
            if(arr[left] == k) return left;
            if(arr[right] == k) return right;
            left++;right--;
        }
        return 0;
    }
    
    public int[] reverseTheArray(int[] arr, int right){
        int left = 0;
        while(left < right){
            int tmp = arr[right];
            arr[right--] = arr[left];
            arr[left++] = tmp;
        }
        return arr;
    }
    
    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int k = 1, index = -1, right = 0;
        while(k <= arr.length){
            index = getTheKIndex(k, arr);
            if (!(index == arr.length-k)){
            	if(index == 0) {
                    arr = reverseTheArray(arr, arr.length-k);
            	}else {
                    list.add(index+1);
                    arr = reverseTheArray(arr, index);
                    arr = reverseTheArray(arr, arr.length-k);
            	}
            	list.add(arr.length-k+1);
            }
            k++;
        }
        list.add(arr.length);
        return list;
    }
}
