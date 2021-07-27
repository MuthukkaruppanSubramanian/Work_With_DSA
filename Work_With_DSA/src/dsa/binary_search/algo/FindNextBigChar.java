package dsa.binary_search.algo;

import org.junit.Assert;
import org.junit.Test;

public class FindNextBigChar {
	/*
	 * Given a sorted character array and a target character, find the next biggest character in the array.
		char[] cha = {‘b’, ‘d’ , ‘h’};
		char k = ‘e’
		Output ->  h
	 * 
	 * 
	 * Given Input  data type:int[] int k
	 *       Output data type: int
	 * Sample Test Data 
	 *    Input :
	 *    output:4
	 *
	 * Approach 1: 
	 * 
	 * Pseudo code:
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		char[] input = {'b','d','h'};
		char target = 'e';
		Assert.assertTrue(findTheGivenTargetIndLex(input, target)=='h');
	}

	@Test
	public void test2() {
		char[] input = {'b'};
		char target = 'c';
		Assert.assertTrue(findTheGivenTargetIndLex(input,target) == ' ');
	}

	@Test
	public void test3() {
		char[] input = {'b','d','h'};
		char target = 'd';
		Assert.assertTrue(findTheGivenTargetIndLex(input,target) == 'h');
	}
	
	@Test
	public void test4() {
		char[] input = {'b','d','h'};
		char target = 'a';
		Assert.assertTrue(findTheGivenTargetIndLex(input,target) == 'b');
	}

	public char findTheGivenTargetIndLex(char[] input, char target) {
		int low = 0, high = input.length-1;
		if(target < input[0]) return input[0];
		while(low<=high) {
			int mid = (low+high)/2;
			if(input[mid]==target && mid+1 < input.length) return input[mid+1];
			else if (input[mid] < target) low = mid+1;
			else return input[mid];
		}
		return ' ';
	}
}
