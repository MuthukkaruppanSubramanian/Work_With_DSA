package problem_solving_genric;

import org.junit.Test;

public class Palindrome {
	/*Given an num nums of size n, return the majority element. 
	 *You may assume that the majority element always exists in the num.
	 *The majority element is the element that appears more than n / 2 times. 
	 *
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - Int []
	 * What is the expected output? - 
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : [1,2,1,1,1,4] => 1
	 *   
	 *  Edge     : [1,1,1,2,2,2] => 
	 *  
	 *  Negative : [1,2,3,4]
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
	 *	Yes - What are those?
	 *	No – That is still fine, proceed to solve by what you know !!
	 *  i) Simple loop with two pass
	 *  ii)Loop with one pass
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
		 *	Then, explain either both or the best (depends on the time)
	 *	Approach 1: O(2n)
	 *  Approach 2: O(n)
	 *
	 * 7) Start with Pseudo code
	 * 		a. Method should take arg as int []
	 * 		b. Traverse the num and count its occurrence and store in HashMap
	 * 		c. traverse the map.entryset using foreach and if the value > n/2
	 * 		d. Then return the key
	 * 		
	 * Time Complexity: 0(2n)
	 * 
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		int num = 121;
		System.out.println(isPalindrome(num));
	}

	@Test
	public void test2() {
		int num = 10;
		System.out.println(isPalindrome(num));
	}
	
	@Test
	public void test3() {
		int num = -1;
		System.out.println(isPalindrome(num));
	}
	public boolean isPalindrome(int num) {
		if(num < 10 && -10 < num) 
			return true;
		int tmp = num;
		int value = 0;
		while(num > 0) {
			value = (value*10)+(num %10);
			num = num/10;
		}
		return (value==tmp);
	}
	
	
}
