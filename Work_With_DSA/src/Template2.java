import java.util.*;
import org.junit.*;

public class Template2 {
	/* Given an array of unique integers salary where salary[i] is the salary of the employee i.

	   Return the average salary of employees excluding the minimum and maximum salary.
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] salary = {4000,3000,1000,2000};
		Assert.assertTrue(average(salary)==2500.00000);
	}

	@Test
	public void test2() {
		int[] salary = {1000,2000,3000};
		Assert.assertTrue(average(salary)==2000.00000);
	}

	@Test
	public void test3() {
		int[] salray = {6000,5000,4000,3000,2000,1000};
		Assert.assertTrue(average(salray)==3500.00000);
	}
	
	/*
	 * Pseudo Code:
	 * 
	 */
	
    public double average(int[] salary) {
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        for(int i = 0; i<salary.length; i++){
            maxSum = Math.max(maxSum,salary[i]);
            minSum = Math.min(minSum,salary[i]);
        }
        double sum = 0;
        for(int i = 0; i<salary.length;i++){
            if(salary[i] == maxSum || salary[i] == minSum) continue;
            sum += salary[i];
        }
        return (sum/(salary.length-2));    
    }
}






















