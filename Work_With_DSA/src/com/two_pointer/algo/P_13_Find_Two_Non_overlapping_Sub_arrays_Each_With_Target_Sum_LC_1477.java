package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_13_Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum_LC_1477 {
	
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
		int[] nums = {3,2,2,4,3};
		int target = 3;
		System.out.println(minSumOfLengths(nums, target));
	}

	@Test
	public void test2() {
		int[] nums = {3,1,1,1,5,1,2,1};
		int target = 3;
		System.out.println(minSumOfLengths(nums, target));
	}

	@Test
	public void test3() {
		int[] nums = {1,1,1,2,2,2,4,4};
		int target = 6;
		System.out.println(minSumOfLengths(nums, target));
	}
	
	@Test
	public void test4() {
		int[] nums = {2,1,3,3,2,3,1};
		int target = 6;
		System.out.println(minSumOfLengths(nums, target));
	}
	
	/*
	 * Pseudo Code
	 */
	
    public List<List<Integer>> checkIndexExists(List<List<Integer>> list, int left, int right){
        boolean noDuplicate = true;
        for(List<Integer> set : list){
            if(left > set.get(0) && right >= set.get(1) ){
                if(!(set.get(1)-set.get(0) > right-left)) noDuplicate = false;
                break;                
            }
        }
        if(noDuplicate) {
        	if(list.size() < 2) list.add(Arrays.asList(left, right));
        	else {
        		if(list.get(0).get(1)-list.get(0).get(0) > right-left) {
        			list.remove(0);
        			list.add(Arrays.asList(left, right));
        		}else if (list.get(1).get(1)-list.get(1).get(0) > right-left) {
        			list.remove(1);
        			list.add(Arrays.asList(left, right));
        		}
        	}
        }  
       		List<Integer> list5 =new ArrayList<Integer>(); 


        		ArrayList<Integer> list2 =new ArrayList<Integer>(); 
        		 return list;
    }
    
    public int minSumOfLengths(int[] arr, int target) {
        int sum = 0, totalLength = 0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int left = 0, right = 0;
        while(right < arr.length){
            sum += arr[right];
            if(sum == target){
                list.add(Arrays.asList(left, right));
                sum -= arr[left++];
            }else{
                while(sum > target){
                    sum -=arr[left++];
                }
                if(sum == target){
                	list.add(Arrays.asList(left, right));
                    sum -= arr[left++];
                }
            }
            right++;
        }
        
        if(list.size() < 2) return -1;
        List<Integer> data = new ArrayList<Integer>();
        
        for(int i = 0; i < list.size(); i++){
            if((i+1 < list.size()) && (list.get(i+1).get(0) <= list.get(i).get(1) || list.get(i+1).get(1) <= list.get(i).get(1))){
                
            	if(i+2 < list.size() && list.get(i+1).get(1) >= list.get(i+2).get(0)) {
            		data.add(list.get(i).get(1)-list.get(i).get(0)+1);
            	}else if(list.get(i).get(1)-list.get(i).get(0) > list.get(i+1).get(1)-list.get(i+1).get(0)) {
                	data.add(list.get(i+1).get(1)-list.get(i+1).get(0)+1);
                	i++;
                }else {
                	data.add(list.get(i).get(1)-list.get(i).get(0)+1);
                }                
            }else data.add(list.get(i).get(1)-list.get(i).get(0)+1);
        }//1-4,3-5,5,6
        
        Collections.sort(data);

        return data.get(0)+data.get(1);
    }
    
    //Two Pointer Optimized solution
    public int minSumOfLengthsOptimized(int[] arr, int target) {
        int n = arr.length,res = Integer.MAX_VALUE;
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        int i = -1,j = -1,sum = 0;
        while(j < n){
            if(j < n-1 && sum < target) sum += arr[++j];
            else if(i < n-1 && sum > target) sum -= arr[++i];
            else if(sum == target){
                if(dp[i+1] < n)
                    res = Math.min(res,dp[i+1]+j-i);
                dp[j+1] = j-i; 
                sum -= arr[++i];
            }
            else break;
            dp[j+1] = Math.min(dp[j],dp[j+1]);
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}
