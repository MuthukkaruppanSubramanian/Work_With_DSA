package problem_solving_genric;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UniqueOccurrenceInArray {
	/*
	 * Question:
	 * Given an array of integers arr, write a
	 * function that returns true if and only if the number of occurrences of each
	 * value in the array is unique.   Example 1: Input: arr = [1,2,2,1,1,3] Output:
	 * true
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes -> 
	 * If No, Ask the person to provide more detail with example(s) -> 
	 * If yes, go to next step !!
	 * 
	 * What is the input(s)? - Int [] 
	 * What is the expected output? - Boolean
	 * Do I have constraints to solve the problem? -
	 * No Do I have all informations to go to next step!! How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set Minimum of 3 data set !! 
	 * Positive : [1,2,2,1,1,3]
	 * 
	 * Edge : [1,1,1,1,1] , {} 
	 * 
	 * Negative : {1,1,2,2}
	 * 
	 * Validate the data set with the interviewer
	 *
	 * 3) Do I know how to solver it? Yes - great, 
	 * 	Is there any alternate solution?
	 * 	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes 
	 * Yes - What are those? 
	 * 			i) two pass with hash map
	 * 			ii) single pass with hash map
	 * No – That is still fine, proceed to solve by what you know !! Simple
	 * Technique - > Brute Force !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * Then, explain either both or the best (depends on the time) 
	 * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * 
	 * Approach 1: O(2n) , Approach 2: O(n)
	 * 
	 * 7) Start with Pseudo code 
	 * 		a. Get the input arg as int []
	 * 		b. Traverse through for loop and add the key as element and its occurrence as value
	 * 		c. Traverse the hash map and check if values are duplicate then return false else true
	 * 		d. 
	 * 		e. 
	 * 		f.
	 * 
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		int [] newArray = {1,2,2,1,1,1};
		System.out.println(isOccurrenceUnique(newArray));

	}

	@Test
	public void test2() {
		// TODO Auto-generated method stub
		int [] newArray = {1,2,2,2,1,1};
		System.out.println(isOccurrenceUnique(newArray));

	}
	
	@Test
	public void test3() {
		// TODO Auto-generated method stub
		int [] newArray = {2,2,2,2,2,2};
		System.out.println(isOccurrenceUnique(newArray));

	}

	@Test
	public void test4() {
		// TODO Auto-generated method stub
		int [] newArray = {2,2,2,2,8,2};
		System.out.println(isOccurrenceUnique(newArray));

	}
	
	public boolean isOccurrenceUnique(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
		}

		if(map.keySet().size()==1) return true;
		Set<Integer> unique = new HashSet<Integer>();
		for(int i : map.values()) {
			if(!unique.add(i)) return false;
		}
		
		return true;
	}
	
}
