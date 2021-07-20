package binary_search;

import org.junit.Test;

public class FindChar {
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
		char[] input = {'k','l' };
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	@Test
	public void test4() {

	}

	public int findTheGivenTargetIndLex(int[] input, int target) {
		int low = 0, high = input.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(input[mid]==target && mid+1 < input.length) return input[mid+1];
			else if (input[mid] < target) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}
}
