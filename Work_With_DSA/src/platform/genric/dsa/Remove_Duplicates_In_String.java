package platform.genric.dsa;
import org.junit.*;
import java.util.*;

public class Remove_Duplicates_In_String {
	
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
		String str = "Hello";
		Assert.assertTrue(removeDuplicate(str).equals("Helo"));
		Assert.assertTrue(getLastDuplicate(str)==3);
	}

	@Test
	public void test2() {
		String str = "Helloo";
		Assert.assertTrue(removeDuplicate(str).equals("Helo"));
		Assert.assertTrue(getLastDuplicate(str)==5);
	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 * Declare a set and output string
	 * Traverse the string in for loop until length
	 * ----append the char to output string if set of add return true for adding char
	 * return output string
	 */
	
	public String removeDuplicate(String str) {
		Set<Character> set = new HashSet<Character>();
		String output = "";
		for (int i = 0; i < str.length(); i++) {
			if(set.add(str.charAt(i))) output = output+""+str.charAt(i);
		}
		return output;
	}
	
	public int getLastDuplicate(String str) {
		Set<Character> set = new HashSet<Character>();
		int value = -1;
		for (int i = 0; i < str.length(); i++) {
			if(!set.add(str.charAt(i))) value = i;
		}
		return value;
	}
}
