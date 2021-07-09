package problem_solving_genric;

import org.junit.Test;

public class FindMissingNumber {
	/*
	 * Question: Given an array nums containing n distinct numbers in the range [0,
	 * n], return the only number in the range that is missing from the array.
	 * 
	 * Input: nums = [3,0,1] Output: 2
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes -> If No, Ask the person
	 * to provide more detail with example(s) -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - Int [] What is the expected output? - Boolean Do I
	 * have constraints to solve the problem? - No Do I have all informations to go
	 * to next step!! How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set Minimum of 3 data set !! 
	 * Positive : [1,2,4,5] => 3
	 * 
	 * Edge : [1,1,1,1,1] => -1
	 * 
	 * Negative : {1,3,2,4} => -1
	 * 
	 * Validate the data set with the interviewer
	 *
	 * 3) Do I know how to solver it? Yes - great, Is there any alternate solution?
	 * No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes Yes - What are
	 * those? 
	 * 
	 * i) Single pass
	 * ii)Two pass  with one nested for loop
	 * 
	 * No – That is still fine, proceed to solve by what you know !! Simple Technique - > Brute
	 * Force !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * Then, explain either both or the best (depends on the time) Approach 1: Start
	 * with worst -> Improve (Optimize) -> End up with the best
	 * 
	 * Approach 1: O(n)
	 * Approach 2: O(n^2+n)
	 * 
	 * 7) Start with Pseudo code
	 * Approach 1:
	 * 	a.Get input arg as int array
	 *  b.initialize minVlaue, maxvalue, actualSum of the given array
	 *  c.Traverse through the array and compare the element to get the minVlaue, maxvalue and actualSum
	 *  d.Using n(n+1)/2 get the expected sum with maxValue and minus with the actual sum
	 *  e.if(total == 0 && minValue !=0) return 0;
	 *  f.if(total == 0 && minValue ==0) return -1;
	 *	g.if(total != 0 && minValue ==0) return total;
	 *  h.if none of the above condition matched then minValue > 1
	 *  i.then total - (((minValue-1)*(minValue))/2)
	 *  j.if total ==0 then return -1(No missing num) else total(missing num)
	 *  
	 *  Time Complexity : O(n)
	 *  Space Complexity : 0(1)
	 * Approach 2:
	 *  a.get the int array
	 *  b.initialize lastMax pos as int var
	 *  c.traverse through the array using two for loops
	 *  e.swap the element if lastmax pos value is greater than the current one
	 *  d.Traverse the sorted array
	 *  f.if current and previously difference is 0 go to next element
	 *  g.if the difference is one then -1 to the current index
	 *  
	 *  Time Complexity : O(n^2+n)
	 *  Space Complexity : 0(1)
	 * 
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	//@Test
	public void test1() {
		int[] arr = {0,2,4,3};
		System.out.println(missingNumbers(arr));
	}

	//@Test
	public void test2() {
		int[] arr = {1,1,1,1,1};
		System.out.println(missingNumbers(arr));
	}
	
	//@Test
	public void test3() {
		int[] arr = {3,1,2};
		System.out.println(missingNumbers(arr));
	}

	@Test
	public void test4() {
		int[] arr = {0,1,2,3,5};
		System.out.println(missingNumbers(arr));
	}

	public int missingNumbers(int[] array) {
		int minValue = array[0];
		int maxValue = array[0];
		int actualSum = array[0];
		int total = 0;
		for (int i = 1; i < array.length; i++) {
			if(array[i] > maxValue) maxValue = array[i];
			if(array[i] < minValue) minValue = array[i];
			actualSum += array[i];
		}
		total = ((maxValue*(maxValue+1))/2) - actualSum;
		if(total == 0 && minValue !=0) return 0;
		if(total == 0 && minValue ==0) return -1;
		if(total != 0 && minValue ==0) return total;
//		total = (((maxValue*(maxValue+1))/2)-(((minValue-1)*(minValue))/2))-actualSum;
		total = total - (((minValue-1)*(minValue))/2);
		return (total==0)? -1 : total;
	}
	
	//Find Missing number in the given range
	public int missingElement(int[] array) {
		int tmp = 0;
		for(int i=0; i < array.length; i++) {
			for(int j=i+1; j<array.length;j++) {
				if(array[i] > array[j]) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		
		for(int i=0; i<array.length-1;i++) {
			if(array[i+1]-array[i]==2)return array[i]+1; 
		}
		return -1;
	}
}
