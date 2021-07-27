package platform.genric.dsa;

import java.util.Arrays;

import org.junit.Test;

public class FindXPlusoneElementInArray {
	/*
	 * Given an integer array arr, count how many elements x there are, 
	 * such that x + 1 is also in arr. If there are duplicates in arr, 
	 * count them separately.   
	 * 
	 * Example 1: Input: arr = [1,2,3]
	 * Output: 2
	 *
	 *
	 * // TODO Auto-generated method stub
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int []
	 * What is the expected output? - int
	 * Do I have constraints to solve the problem? - 
	 * 			If there are duplicates count them separately 	
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : [1,2,3] => 3
	 *   
	 *  Edge     :  [2,1,1] => 2
	 *  
	 *  Negative : [1,3,5,7] => 0
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it? => Yes
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those?
	 *	No – That is still fine, proceed to solve by what you know !!
	 *  Approach 1: Using nested for loop
	 *  Approach 2: Sort the array and with one pass 
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
		 *	Then, explain either both or the best (depends on the time)
	 *	Approach 1: O(n^2) / O(1)
	 *  Approach 2: O(n logn) / O(1)
	 *
	 * 7) Start with Pseudo code
	 * 		a. Get the arg as int [] and inti as int count var = 0;
	 * 		b. Traverse the array with for loop
	 * 		c. Have a inner for loop with compare and set the cout var
	 * 		d. If(arr[i]+1==arr[j]) count ++ then break the loop;
	 * 		e. return the count
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		int[] ar = {3,2,1};
		findXPlusOneElementInArray(ar);
	}
	
	@Test
	public void test2() {
		int[] ar = {1,1,3,3,5,5,7,7};
		findXPlusOneElementInArray(ar);
	}
	
	@Test
	public void test3() {
		int[] ar = {1,3,2,3,5,0};
		findXPlusOneElementInArray(ar);
	}
	
	@Test
	public void test4() {
		int[] ar = {1,1,2,2};
		findXPlusOneElementInArray(ar);
	}
	
	@Test
	public void test5() {
		int[] ar = {1,1,1,1,2,2,3};
		findXPlusOneElementInArray(ar);
	}
	
	public int findXPlusOnenumbersInArray(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i]+1 == array[j]) {
					count++;
					break;	
				}
			}
		}
		System.out.println(count);
		return count;
	}
	
	/*Approach 2 Pseudo Code:
	 * 
	 * Get the arg as int [] and inti int count and duplicate var = 0;
	 * Sort the array
	 * Traverse the array with for loop
	 * if(array[i]== array[i+1]) duplicateValue++
	 * If(arr[i]+1==arr[i+1]) count ++ or if duplicate value is > 0 then count+duplicateValue+1
	 * if(array[i] < array[i+1]) duplicateValue = 0;
	 * if(array.length == i+2) break;
	 * return the count
	 */
	
	public int findXPlusOneElementInArray(int[] array) {
		int count = 0;
		int duplicateValue = 0;
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			if(array[i]== array[i+1]) duplicateValue++;
			if(array[i]+1 == array[i+1]) {
				count = (duplicateValue == 0)? count+1 : count+duplicateValue+1;
				duplicateValue = 0;
			}
			if(array[i] < array[i+1]) duplicateValue = 0;
			if(array.length == i+2) break;
		}
		System.out.println(count);
		return count;
	}
}
