package dsa.sliding_window.algo;

import org.junit.Test;

public class CaloriesGained {
	/*
	 * Given Input  data type: int[] , k days, lower and upper
	 *       Output data type: int
	 * Sample Test Data 
	 *    Input : [6,5,0,0],  k=2, lower = 0 and upper = 5;
	 *    output: 0
	 *
	 * Approach 1: Sliding window
	 * 
	 * Approach 2: Two Pointers Opp Direction
	 *
	 * Pseudo code - Approach 1:
	 * a.Initialize totalPoint var
	 * b.Traverse the array using while loop till array length and 
	 *   increment of right and left +2 each
	 * c.add the two index value and check if < lower then -1 else +1
	 * d.Return totalPoint
	 *
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] calories = {1,2,3,4,5};
		int days= 1, lower = 3, upper =3;
		findThePointsGained(calories,days,lower,upper);
	}
	

	@Test
	public void test2() {
		int[] calories = {3,2};
		int days= 2, lower = 0, upper =1;
		findThePointsGained(calories,days,lower,upper);
	}
	
	@Test
	public void test3() {
		int[] calories = {6,5,0,0};
		int days= 2, lower = 1, upper =5;
		findThePointsGained(calories,days,lower,upper);
	}
	
	public int findThePointsGained(int[] calories, int days, int lower, int upper) {
		int totalPoints = 0 , initialSum = 0, count = 0;
		for(int i = 0; i < calories.length;){
			while(count < days) {
				initialSum += calories[i++];
				count++;
			}
			if(initialSum < lower) totalPoints--;
			if(initialSum > upper) totalPoints++;
			initialSum = 0; count = 0;
		}
		return totalPoints;
	}
}
