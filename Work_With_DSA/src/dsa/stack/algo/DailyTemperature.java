package dsa.stack.algo;
import java.util.*;
import org.junit.*;

public class DailyTemperature {
	/* Longest Valid parenthesis in given string 
	 * 
	 * Given Input  data type: "}{{}}{"
	 *       Output data type: 4
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: using Stack
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] s = {73,74,75,71,69,72,76,73};
		Assert.assertTrue(dailyTemperatures(s)== new int[] {1,1,4,2,1,1,0,0});
	}


	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code:
	 * 
	 */
	
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> days = new Stack<>();
        int[] output = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++){           
            while(!days.isEmpty() && temperatures[days.peek()] < temperatures[i]) output[days.peek()] = i - days.pop();
            days.push(i);
        }
		return output;
    }
}






















