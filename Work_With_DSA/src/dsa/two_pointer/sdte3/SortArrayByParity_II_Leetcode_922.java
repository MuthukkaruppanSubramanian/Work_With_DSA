package dsa.two_pointer.sdte3;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParity_II_Leetcode_922 {
	/*
		Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
		
		Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
		
		Return any answer array that satisfies this condition.
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - integer array
	 * What is the expected output? - integer array
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : [4,2,5,7] => [4,5,2,7]
	 *   
	 *  Edge     : {0,1,2,3} => {0,1,2,3}
	 *  
	 *  Negative : {} => {}
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
	 *	Yes - What are those? Yes
	 *	No � That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Two Pointer
	 *  
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 *
	 */
	
	@Test
	public void test1() {
		int[] input = {4,2,5,7};
		Assert.assertArrayEquals(sort_array_by_parity(input), new int[] {4,5,2,7});
	}

	@Test
	public void test2() {
		int[] input = {0,1,3,2};
		Assert.assertArrayEquals(sort_array_by_parity(input), new int[] {0,1,2,3});
	}
	
	@Test(expected = RuntimeException.class)
	public void test3() {
		int[] input = {};
		System.out.println(Arrays.toString(sort_array_by_parity(input)));
	}

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Two Pointer
	 * 
	 * 1. If given input array is empty throw runtime exceptionsort_array_by_parity(input)
	 * 2. Declare two pointers left and right with value 0 and 1;
	 * 3. In While loop iterate the array until right and left < array length
	 * 4. ----If right % 2 is equal to 0 and left % 2 not equal to 0
	 * 5. --------Swap the element position using third variable
	 * 6. --------Increment left and right value by 2
	 * 7. ----else if left % 2 is equal to 0 then left +=2
	 * 8. ----else do right +=2
	 * 9. Return the array 
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) - In Place memory
	 */
	

	public int[] sort_array_by_parity(int[] nums) {
		if(nums.length == 0) throw new RuntimeException("Empty Array is not a valid input");
		int left = 0, right = 1;
		while(right < nums.length && left < nums.length){
			if((nums[right]%2 ==0) && (nums[left]%2 != 0)) {
				int tmp = nums[right];
				nums[right] = nums[left];
				nums[left] = tmp;
				left +=2; right+=2;
			}else if (nums[left]%2 == 0) left +=2;
			else right +=2;
		}
		return nums;
	}
}

