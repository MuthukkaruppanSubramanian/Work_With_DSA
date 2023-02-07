package dsa.binary_search.algo;

import java.text.DecimalFormat;
import java.util.*;
import org.junit.*;

public class LC_2 {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {1,3,2};
		double hours = 6;
		Assert.assertTrue(trainArrvingSpeed(nums, hours)==1);
	}

	@Test
	public void test2() {
		int[] nums = {1,3,2};
		double hours = 2.7;
		Assert.assertTrue(trainArrvingSpeed(nums, hours)==3);
	}

	@Test
	public void test3() {

	}
	
	@Test
	public void test4() {

	}
	
	/*
	 * Pseudo Code: 
	 * Declare double low = 1 and high as 10^ 9
	 * Get the mid by getting avg of low and high
	 * In while loop until mid >= 1
	 * traverse the for loop 
	 * ---dived each value with mid and get the sum
	 * if(sum == hours) return mid
	 * else if hours > sum
	 * ---h = m
	 * ---m = l+h/2
	 * else
	 * ---l = m
	 * ---m = l+h/2
	 * 
	 * default return -1;
	 */
	
	public int trainArrvingSpeed(int[] distance, double hours) {
		double low = 1, high = 10;
		double sum = 0;
		while(low <= high) {
			int mid = (int) ((low+high)/2);
			for (int i = 0; i < distance.length; i++) {
				sum += distance[i]/(double) mid;
				if(i != distance.length-1)sum = Math.ceil(sum); 
			}
			DecimalFormat df_obj = new DecimalFormat("#.#");
			sum = Integer.valueOf(df_obj.format(1));
			if(hours == sum) return (int)mid;
			else if(hours > sum) high = mid-1;
			else low = mid+1;
			sum = 0;
		}
		return -1;
	}
}






















