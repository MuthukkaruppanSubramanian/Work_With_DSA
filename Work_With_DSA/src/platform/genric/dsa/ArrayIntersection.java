package platform.genric.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ArrayIntersection {
	/*
	 * Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must be unique and you may return
	 * the result in any order.  
	 * Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 * Output: [2]
	 *
	 *
	 *  TODO Auto-generated method stub
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - 2 Int array's
	 * What is the expected output? - int array if it has common values else []
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : {1,2,3,1}{1,4,5} => {1}
	 *   
	 *  Edge     : 
	 *  
	 *  Negative : {1,2,3,4}{6,7,8} => []
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
	 *	No – That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Using two for loop
	 *
	 * 7) Start with Pseudo code
	 * 		a. Method should accept two int array as args
	 * 		b. create a integer set
	 * 		c. Traverse the both the array using two for loops
	 * 		d. if i==j then add the value to set
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	//@Test
	public void test1() {
		int [] nums1 = {1,2,2,1};
		int [] nums2 = {2,2};
		System.out.println(arrayInterSection(nums1, nums2));
	}

	//@Test
	public void test2() {
		int [] nums1 = {1,1,2,2,3};
		int [] nums2 = {2,5,1};
		System.out.println(arrayInterSection(nums1, nums2));
	}
	
	@Test
	public void test3() {
		int [] nums1 = {10,4,2,11,1};
		int [] nums2 = {9,2,4,10,0,1,11};
		System.out.println(arrayInterSection(nums1, nums2));
	}
	
	public Set<Integer> getTheCommonElement(int[] nums1, int[] nums2) {
		Set<Integer> commonValues = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if(nums1[i]==nums2[j]) commonValues.add(nums1[i]);
			}
		}
		return commonValues;
	}
	
	public String arrayInterSection2Pointer(int[] nums1, int[] nums2) {
		ArrayList<Integer> commonValues = new ArrayList<Integer>();		int p1 = 0, p2 = 0;
		while(p2 < nums2.length) {
			if(nums1[p1] == nums2[p2]) {
				commonValues.add(nums1[p1]);
				p1++; p2++;
			}else if(nums1[p1] < nums2[p2]) p1++;
			else p2++;
			if(p1 >= nums1.length) break;
		}
		return Arrays.toString(commonValues.toArray());
	}

	public int[] arrayInterSection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] interSection = new int[Math.max(nums1.length, nums2.length)];
		int p1 = 0, p2 = 0, counter = 0;
		while(p2 < nums2.length) {
			if(nums1[p1] == nums2[p2]) {
				interSection[counter++] = nums1[p1++];
				p2++;
			}else if(nums1[p1] < nums2[p2]) p1++;
			else p2++;
		}
        int[] newArray = Arrays.copyOf(interSection, counter);
        System.out.println(Arrays.toString(newArray));
		return newArray;
	}
}
