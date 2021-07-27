package dsa.two_pointer.algo;

import java.util.Arrays;

import org.junit.Test;

public class closestNumber {
	/*
Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
Example 2:
Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.
	 *
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int [], k
	 * What is the expected output? - int
	 * Do I have constraints to solve the problem? - i < j / two Pointer
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : [34,23,1,24,75,33,54,8]
	 *   
	 *  Edge     : [7]
	 *  
	 *  Negative : [10,20,30] => -1
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those?
	 *	No – That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *	Then, explain either both or the best (depends on the time)
	 *	Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 *
	 * 7) Start with Pseudo code
	 * 		a. Get int [] as arg and target k, sum = 0;
	 * 		b. Traverse the arr with for loop from 0 to length-1
	 * 		c. Traverse the arr with for loop from 0 to length-1
	 * 		d. if(i!=j)
	 * 		e. sum = arr[i]+arr[j]
	 * 		f. if(sum < k)
	 * 		g. if(arr[i]+arr[j] > sum)
	 * 		h. sum = arr[i]+arr[j]
	 * Time Com: O(n^2)
	 * Spac Com: O(1)
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */

	//@Test
	public void test1() {
		// TODO Auto-generated method stub
		int[] num = {34,23,1,24,75,33,54,8};
		int k = 60;
		System.out.println(closestNumberTwoPointer(num,60));
	}

	//@Test
	public void test2() {
		// TODO Auto-generated method stub
		int[] num = {10,20,-30};
		int k = -5;
		System.out.println(closestNumberTwoPointer(num,k));
	}
	
	@Test
	public void test3() {
		// TODO Auto-generated method stub
		int[] num = {10,5,2,7,3};
		int k = 13;
		System.out.println(closestNumberTwoPointer(num,k));
	}
	
	private int closestNumberBurteForce(int[] arr, int k) {
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i!=j && arr[i]+arr[j] < k) sum = Math.max(sum,(arr[i]+arr[j]));
			}
		}
		return sum;	
	}
	/*
	 * Two Pointer
	 * Int two pointers left=0 and right = 1;
	 * while(right < arr.length)
	 * if((arr[left]+arr[right]) < k) 
	 * sum = arr[left]+arr[right]
	 * then left++ and right++ 
	 */
	private int closestNumberTwoPointer(int[] arr, int k) {
		int sum = Integer.MIN_VALUE, left = 0, right = arr.length-1;
		Arrays.sort(arr);
		while(left < right) {
			int lastsum = arr[left]+arr[right];
			if(lastsum < k) {
				sum = Math.max(lastsum, sum);
				left++;
			}else right--;
		}
		return sum;	
	}
}
















