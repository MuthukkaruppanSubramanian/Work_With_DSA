package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_18_Gas_Station {
	
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
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}

	@Test
	public void test2() {
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println(canCompleteCircuit(gas, cost));
	}

	@Test
	public void test3() {
		int[] gas = {5,1,2,3,4};
		int[] cost = {4,4,1,5,1};
		System.out.println(canCompleteCircuit(gas, cost));
		
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
            1. Decalre a start array with same size as gas
            2. Traverse the array and get all possible start index
               if (gas[i]-cost[i] > 0)
            3. Iterate the start array
                 in the first for loop traverse from start index to length of array.
                 In the next for loop traverse from 0 to start index
                 
                 If any values < 0 then break it.
        */
        int[] start = new int[gas.length];
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            if(gas[i]-cost[i] >= 0)
                start[index++] = i;
        }
        
        for(int i = 0; i < index; i++){
        	int sum = gas[start[i]];
            for(int j = start[i]+1; j < gas.length; j++){
                sum += -cost[j-1];
                if(sum < 0) break;
                sum += gas[j];
            }
            if(sum >= 0){
            	sum += gas[0] - cost[cost.length-1];
                for(int k = 1; k <= start[i]; k++){
                    sum += -cost[k-1];
                    if(sum < 0) break;
                    sum +=gas[k];
                }
                if(sum >=0) return start[i];
            }
        }
        return -1;
    }
}
