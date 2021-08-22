import org.junit.*;
import java.util.*;

public class Swiggy_Find_First_Unique_Char {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : S = "statistics"
	 *    output: int output = 3
	 *
	 * Approach 1: hash map
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(n) 
	 * 		
	 */
	
	@Test
	public void test1() {
		String s = "statistics";
		Assert.assertTrue(getFirstUniqCharIndex(s)==3);
	}

	@Test
	public void test2() {
		String s = "ss";
		Assert.assertTrue(getFirstUniqCharIndex(s)==-1);
	}

	@Test
	public void test3() {

	}
	
	/* 9:11
	 * Pseudo Code
	 * Declare hash map
	 * Traverse the string in for loop
	 * --add the char and its occurrence in the map
	 * Traverse the string in for loop
	 * check if the char occurrence == 1 then return i+1
	 * return -1
	 * 9:16
	 */
	
	/**
	 * @param s
	 * @return
	 */
	private int getFirstUniqCharIndex(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		for (int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i))==1) return i+1;
		}
		return -1;
	}//9:18
	
	private int getFirstUniqCharIndex2(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
				return i+1;
			}
		}
		return -1;
	}//9:18
}
