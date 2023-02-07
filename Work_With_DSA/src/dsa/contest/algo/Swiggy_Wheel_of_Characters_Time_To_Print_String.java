package dsa.contest.algo;
import org.junit.*;
import java.util.*;

public class Swiggy_Wheel_of_Characters_Time_To_Print_String {
	
	/*
	 * 
	 * Sample Test Data 
	 *    Input : S = "BZA"
	 *    output: int seconds = 4;
	 *
	 * Approach 1: Using one pass
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		String s = "BZA";
		Assert.assertTrue(getTimeToPrint2(s)==4);
	}

	@Test
	public void test2() {
		String s = "CZA";
		Assert.assertTrue(getTimeToPrint2(s)==6);
	}

	@Test
	public void test3() {
		String s = "CNA";
		Assert.assertTrue(getTimeToPrint(s)==26);
	}

	@Test
	public void test4() {
		String s = "ZA";
		Assert.assertTrue(getTimeToPrint(s)==2);
	}
	
	@Test
	public void test5() {
		String s = "AAA";
		Assert.assertTrue(getTimeToPrint(s)==0);
	}

	/* 10:22
	 * Pseudo Code
	 * Declare a integer seconds
	 * if(first char > N) then Math.abs(('A'-first char)-26)
	 * Traverse the string in for loop from index 1
	 * if(current char > N || previous char > N)
	 * ------seconds += Math.abs((previous char-current char)-26)
	 * else
	 * ------seconds += Math.abs((previous char-current)
	 * return seconds
	 * 10:27
	 */
	
	private int getTimeToPrint(String s) {
		int seconds = 0;
		seconds = (s.charAt(0) > 'N')? Math.abs(Math.abs('A'-s.charAt(0))-26) : Math.abs('A'-s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) > 'N' || s.charAt(i-1) > 'N') {
				seconds += Math.abs(Math.abs(s.charAt(i-1)-s.charAt(i))-26);
			}else {
				seconds += Math.abs((s.charAt(i-1)-s.charAt(i)));
			}
		}
		return seconds;
	}//10:32
	//debugging - 10:40
	
	private int getTimeToPrint2(String s) {
		int seconds = 0;
		seconds += Math.min(Math.abs(Math.abs('A'-s.charAt(0))-26), Math.abs('A'-s.charAt(0)));
		for (int i = 1; i < s.length(); i++) {
			seconds += Math.min(Math.abs(Math.abs(s.charAt(i-1)-s.charAt(i))-26), Math.abs(s.charAt(i-1)-s.charAt(i)));
		}
		return seconds;
	}//10:32
	//debugging - 10:40
}
