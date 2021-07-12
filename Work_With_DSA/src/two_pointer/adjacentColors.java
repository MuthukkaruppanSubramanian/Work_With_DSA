package two_pointer;

import java.util.Arrays;

import org.junit.Test;

public class adjacentColors {
	/*
	 * Given an array nums with n objects colored red, white, or blue, sort them
	 * in-place so that objects of the same color are adjacent, with the colors in
	 * the order red, white, and blue.
	 * 
	 * We will use the integers 0, 1, and 2 to represent the color red, white, and
	 * blue, respectively.
	 * 
	 * You must solve this problem without using the library's sort function.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [2,0,1] Output: [0,1,2]
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [0] Output: [0]
	 */
	/*
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int []
	 * What is the expected output? - int []
	 * Do I have constraints to solve the problem? - Using Three Pointer
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : [2,2,1,1,0]
	 *   
	 *  Edge     : [0,0,0]
	 *  
	 *  Negative : [1,2,3]
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
	 *  Simple Technique - > 3 pass
	 *  Three Pointer
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *	Then, explain either both or the best (depends on the time)
	 *	Approach 1: O(3n)
	 *  Approach 2: O(n)
	 *
	 * 7) Start with Pseudo code
	 * 		a. get the int array
	 * 		b. Traverse through arr and move all the 2 to right
	 * 		c. Traverse through arr and move all the 0 to left
	 * Time / Space complexity - O(3n) -> O(n) / O(1)		
	 * 
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		int[] arr = {2,2,0,1,1};
		System.out.println(Arrays.toString(sortTheColorUsing3Pointer(arr)));
	}

	@Test
	public void test2() {
		int[] arr = {2,0,0,1,1};
		System.out.println(Arrays.toString(sortTheColorUsing3Pointer(arr)));
	}
	
	@Test
	public void test3() {
		int[] arr = {1,2,0};
		System.out.println(Arrays.toString(sortTheColorUsing3Pointer(arr)));
	}
	
	@Test
	public void test4() {
		int[] arr = {0};
		System.out.println(Arrays.toString(sortTheColorUsing3Pointer(arr)));
	}
	private int[] sortTheColor(int[] arr) {
		if(arr.length==1) return arr;
		int left = 0, right =0;
		while (right < arr.length-1) {
			if(arr[right] == 2) 
				right++;
			else if(arr[right] != 2) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left++] = temp;
			}
		}
		left = 0; right =0;
		while (right < arr.length-1) {
			if(arr[right] == 0) 
				right++;
			else if(arr[right] != 0) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left++] = temp;
			}
		}
		return arr;
	}
	/*
	 * Psuedo Code:
	 * On the Give int arr assign 3 pointer on the index 0
	 * Check whether p0 == 0 | p1==1 | p2==2
	 * if(p0==0) -> check if(p0>p2) then swap the value and index of the pointers.
	 * Check the same for p1 and do swap, then do p0++
	 * Repeat the above steps for p1 and p2
	 * ifp0 != 0 | p1!=1 | p2!=2 increment the respective pointers
	 */
	private int[] sortTheColorUsing3Pointer(int[] colors) {
		int p0=0, p1=0, p2=colors.length-1, tmp=0;
		while(p1 <= p2) {
			if(colors[p1]==0) {
					tmp = colors[p0];
					colors[p0++] = colors[p1];
					colors[p1++] = tmp;
			}
			else if(colors[p1]==2) {
				tmp = colors[p1];
				colors[p1] = colors[p2];
				colors[p2--] = tmp;
			}else {
				p1++;
			}
		}
		return colors;
	}
}











