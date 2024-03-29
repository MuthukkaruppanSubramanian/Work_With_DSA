package platform.genric.dsa;

import java.util.Arrays;

public class TwoSumNumbersFromArray {

	public static void main(String[] args) {

		/*
		 * // TODO Auto-generated method stub
		 * 
		 * 1) Did I understand the problem? Yes or No !! - Yes 
		 * -> If No, Ask the person to provide more detail with example(s) 
		 * -> If yes, go to next step !!
		 * 
		 * What is the input(s)? - String
		 * What is the expected output? - String
		 * Do I have constraints to solve the problem? - No
		 * Do I have all informations to go to next step!!
		 * How big is your test data set will be?
		 *
		 *
		 * 2) Test Data Set
		 *  Minimum of 3 data set !! 
		 *  Positive : Input Array - {1,2,34,5} , Sum = 6
		 *   
		 *  Edge     : Input Array - {-1,4,3,2,1}, sum = 3
		 *  		   Input Array - {0,1,4,3,2,5}, sum = 5
		 *  
		 *  Negative : Input Array - {123,12,12}, sum = 3
		 *  Validate the data set with the interviewer 
		 *
		 * 3) Do I know how to solver it?
		 *	Yes - great, Is there any alternate solution?
		 *	No - Can I break down the problem to sub problems?
		 *
		 * 4) Ask for the hint (If you don't know how to solve it)
		 *
		 *
		 * 5) Do I know alternate solution to solve this problem? 
		 *	Yes - What are those?
		 *	No � That is still fine, proceed to solve by what you know !!
		 *  Simple Technique - > Brute Force !!
		 *  
		 * 6) If you know alternate solutions -> find out the O Notations (Performance)
 		 *	Then, explain either both or the best (depends on the time)
		 *	Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
		 *
		 * 7) Start with Pseudo code
		 * 
		 * 8)Implement the code
		 * 
		 * 9)Test against the different data set
		 * 
		 * 10) If it fails Debug them to solve it !!
		 */
		int[] array = {0,1,2,34,5};
		int target = 6;
		Boolean result = false;
		int[] indexArray = new int [2];
		for(int i =0; i < array.length;i++) {
			for(int j = i+1; j < array.length;j++) {
				int tmp = array[i]+array[j];
				if(target == tmp) {
					indexArray[0] = i;
					indexArray[1] = j;
					System.out.println("The first matching index: " + Arrays.toString(indexArray));
					result = true;
					break;
				}
			}
			if(result) {
				break;
			}
		}
		
	}

}
