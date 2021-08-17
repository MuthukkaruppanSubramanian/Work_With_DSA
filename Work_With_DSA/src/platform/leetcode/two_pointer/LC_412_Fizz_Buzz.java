package platform.leetcode.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LC_412_Fizz_Buzz {
	
	/* Given an integer n, return a string array answer (1-indexed) where:
	 * 
	 * Given Input  data type: 3
	 *       Output data type: ["1","2","FIZZ"]
	 *       
	 * Sample Test Data 
	 *    Input : 5
	 *    output: ["1","2","Fizz","4","Buzz"]
	 *
	 *	Constrain: Hashmap and Two Pointer approach
	 *
	 * Approach 1: Two Pointer
	 *
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */
	
	@Test
	public void test1() {
		int n = 3;
		String[] s= {"1","2","Fizz"};
		List<String> list = Arrays.asList(s);
		//Assert.assertTrue(fizzBuzz(n).equals(list));
		System.out.println(fizzBuzz(n));

	}

	@Test
	public void test2() {
		int n = 15;
		System.out.println(fizzBuzz(n));
	}

	@Test
	public void test3() {

	}
	/*
	 * Declare the hash map with values as 3 -> Fizz, 5->Buzz and 15 -> FizzBuzz
	 * Convert the given integer to list from 1 to n(given integer)
	 * Declare left = 0 and right = list's last index
	 * Using while loop traverse the list with two pointers
	 * check if left index of left divisible by any of 3/5/15 
	 * 			based on that update the values in map and increment left
	 * else----convert the integer to string
	 * check if right index of left divisible by any of 3/5/15 
	 * 			based on that update the values in map and decrement right
	 * else----convert the integer to string
	 * 
	 */
	
	private List fizzBuzz(int n) {
	    HashMap<Integer,String> map = new HashMap<Integer,String>();
	    map.put(15, "FizzBuzz");
	    map.put(5, "Buzz");
	    map.put(3, "Fizz");
	    int left = 1, right = n;
	    List<String> output = Arrays.asList(new String[n]);
	    while(left <= right) {
	    	if (left % 15 == 0) output.set(left-1,map.get(15));
	    	else if(left % 3 == 0) output.set(left-1,map.get(3));
	    	else if(left % 5 == 0) output.set(left-1,map.get(5));
	    	else output.set(left-1,""+(left));
	    	if(left==right) break;
	    	if (right % 15 == 0) output.set(right-1,map.get(15));
	    	else if(right % 3 == 0) output.set(right-1,map.get(3));
	    	else if(right % 5 == 0) output.set(right-1,map.get(5));
	    	else output.set(right-1,""+(right));
	    	left++;
	    	right--;
	    }
		return output;
	}
}
