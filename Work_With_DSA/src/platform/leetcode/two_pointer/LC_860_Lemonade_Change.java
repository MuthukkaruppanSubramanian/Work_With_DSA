package platform.leetcode.two_pointer;
import org.junit.*;
import java.util.*;

public class LC_860_Lemonade_Change {

	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		int[] nums = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
		System.out.println(lemonadeChange(nums));
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	/*
	 * Pseudo Code
	 */

	public boolean lemonadeChange(int[] bills) {
		int[] cash = new int[3];
		for(int i = 0; i < bills.length; i++){
			if(bills[i] == 5) {
				cash[0]++;
			}else if(bills[i] == 10){
				if(cash[0] > 0) {
					cash[0]--;
					cash[1]++;
				}else{
					return false;
				}
			}else{
				if(cash[0] > 0  && cash[1] > 0) {
					cash[0]--;
					cash[1] --;
					cash[2]++;
				}else if(cash[0] > 0) {
					cash[0] -=3;
					if(cash[0] < 0) return false;
					cash[2]++;
				}else {
					return false;
				}
			}
		}
		return true;
	}
}
