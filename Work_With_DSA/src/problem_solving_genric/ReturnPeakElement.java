package problem_solving_genric;

import org.junit.Test;

public class ReturnPeakElement {

		/*
		 * // TODO Auto-generated method stub
		 * 
		 * 1) Did I understand the problem? Yes or No !! - Yes 
		 * -> If No, Ask the person to provide more detail with example(s) 
		 * -> If yes, go to next step !!
		 * 
		 * What is the input(s)? - int[] array
		 * What is the expected output? - int
		 * Do I have constraints to solve the problem? - No
		 * Do I have all informations to go to next step!!
		 * How big is your test data set will be?
		 *
		 *
		 * 2) Test Data Set
		 *  Minimum of 3 data set !! 
		 *  Positive : {1,2,1} => 2
		 *   		   {1,2,3,2,5,1} = >3
		 *   		   {5}  => 5
		 *   
		 *  Edge     :  {1,3,3}  => 3
		 *  
		 *  Negative : {1,2,3} = > -1
		 *  Validate the data set with the interviewer 
		 *
		 * 3) Do I know how to solver it? - Yes
		 *	Yes - great, Is there any alternate solution?
		 *	No - Can I break down the problem to sub problems?
		 *
		 * 4) Ask for the hint (If you don't know how to solve it)
		 *
		 *
		 * 5) Do I know alternate solution to solve this problem? - yes
		 *	Yes - What are those? - yes using for loop
		 *	No – That is still fine, proceed to solve by what you know !!
		 *  Simple Technique - > Brute Force !!
		 *  
		 * 6) If you know alternate solutions -> find out the O Notations (Performance)
		 *	 Then, explain either both or the best (depends on the time)
		 *	 Start with worst -> Improve (Optimize) -> End up with the best
		 *   Approach 1: O(n)
		 *
		 * 7) Start with Pseudo code
		 * 		a. Get the i/p as int array
		 * 		b. return -1 if array is empty or return highest if array size is <= 2
		 * 		c. Traverse the array from position 1
		 * 		d. compare the previous, current and next values
		 * 		e. when current value is high then return it
		 * 		f. if nothing matches then return -1
		 * 		
		 * 8)Implement the code
		 * 
		 * 9)Test against the different data set
		 * 
		 * 10) If it fails Debug them to solve it !!
		 */
	
	@Test
	public void test1() {
		int[] array = {0,2,1};
		System.out.println(returnThenPeakElement(array));
	}
	
	@Test
	public void test2() {
		int[] array = {1,2,3,2,5,1};
		System.out.println(returnThenPeakElement(array));
	}
	
	@Test
	public void test3() {
		int[] array = {2,2,2,2,2,2};
		System.out.println(returnThenPeakElement(array));
	}
	
	@Test
	public void test4() {
		int[] array = {7};
		System.out.println(returnThenPeakElement(array));
	}
	
	@Test
	public void test5() {
		int[] array = {1,3,3};
		System.out.println(returnThenPeakElement(array));
	}
	
	public int returnThenPeakElement(int[] numArray) {
		
		if(numArray.length==0) return -1;
		if(numArray.length == 1) {
			return numArray[0];
		} else if (numArray.length == 2) {
			return (numArray[0] > numArray[1])? numArray[0] : numArray[1];
		}
		for (int i = 1; i < numArray.length; i++) {
			if(numArray[i-1]<=numArray[i] && numArray[i+1]<=numArray[i]) return numArray[i];
			if(i+2 >= numArray.length) break;
		}
		return -1;
	}
}
