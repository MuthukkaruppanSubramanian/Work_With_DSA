package dsa.two_pointer.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HappyNumbers {
	/*
	 * Write an algorithm to determine if a number n is happy. A happy number is a
	 * number defined by the following process:
	 * 
	 * Starting with any positive integer, replace the number by the sum of the
	 * squares of its digits. Repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1. Those
	 * numbers for which this process ends in 1 are happy. Return true if n is a
	 * happy number, and false if not.
	 * 
	 * Example 1:
	 * 
	 * Input: n = 19 Output: true 
	 * Explanation: 1^2 + 9^2 = 82 
	 * 8^2 + 2^2 = 68 
	 * 6^2 + 8^2 = 100 
	 * 1^2 + 0^2 + 0^2 = 1
	 * 
	 * 
	 * Example 2: Input: n = 2 Output: false
	 */
	
	/* 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int
	 * What is the expected output? - boolean
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !! 
	 *  Positive : Input 19 , O/P = true
	 *   
	 *  Edge     : 
	 *  
	 *  Negative : int 99, O/P = false
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
	 *	Approach 1: O(n)
	 *
	 * 7) Start with Pseudo code
	 * 		a. Get the arg as int num
	 * 		b. While(n > 1)
	 * 		c. 
	 * 		d. 
	 * 		e. 
	 * 		Time / Space Complexity : O(n^2) / O(1)
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	@Test
	public void test1() {
		int num = 19;
		System.out.println(happyNumberBruteForce(num, false));
	}

	@Test
	public void test2() {
		int num = 99;
		System.out.println(happyNumberBruteForce(num, false));
	}
	
	@Test
	public void test3() {
		int num = 1114;
		System.out.println(happyNumberBruteForce(num, false));
	}

	@Test
	public void test4() {
		int num = 91;
		System.out.println(happyNumberBruteForce(num, false));
	}
	
	@Test
	public void test5() {
		int num = 28;
		System.out.println(happyNumberBruteForce(num, false));
	}
	
	@Test
	public void test6() {
		int num = 456565670;
		System.out.println(happyNumberBruteForce(num, false));
	}
	
	private int happyNumberBruteForce(int num, boolean recursion) {
		Boolean numberState = false;
		int tmp = 0;
		int reminder = 0;
		Set<Integer> calculatedNums = new HashSet<>();
		while(num >0) {
			if (!calculatedNums.add(num)) break;
			tmp = num%10;
			reminder = num/10;
			if(reminder >= 10) {
				reminder = happyNumberBruteForce(reminder, true);
				num = (tmp*tmp)+reminder;
			}else if(tmp < 10 && reminder < 10) {
				num = (reminder*reminder)+(tmp*tmp);
				if(recursion) return num;
				if(num==1) break;
			}
		}
		return num;
	}
}
