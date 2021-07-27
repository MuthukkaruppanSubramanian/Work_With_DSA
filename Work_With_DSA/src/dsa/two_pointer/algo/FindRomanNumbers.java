package dsa.two_pointer.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindRomanNumbers {

	/*
	 * 1.Roman numerals are represented by seven different symbols: I, V, X, L, C, D
	 * and M.
	 * 
	 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written
	 * as II in Roman numeral, just two one's added together. 12 is written as XII,
	 * which is simply X + II. The number 27 is written as XXVII, which is XX + V +
	 * II.
	 * 
	 * Roman numerals are usually written largest to smallest from left to right.
	 * However, the numeral for four is not IIII. Instead, the number four is
	 * written as IV. Because the one is before the five we subtract it making four.
	 * The same principle applies to the number nine, which is written as IX. There
	 * are six instances where subtraction is used:
	 * 
	 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
	 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
	 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
	 * integer.
	 */

	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input : "III"
	 *    output: 3
	 *
	 * Approach 1: Two Pointers Opp Direction
	 *
	 * Pseudo code:
	 * Declare left pointer as 0 and right as length-1 also a int num = 0;
	 * Create a hashmap and store the reference for roman numbers
	 * If the str length is 2 then compare left < right then subtract right - left and return else add and return
	 * Add the left and right value to output integer and increment both
	 * Traverse the loop until left > right
	 * If left and right equal then check left is < left+1 and left -1
	 * then decrement the left value from the total sum else add it to total sum
	 * Check if left is < left+1 and left -1 then decrement the left value from the total sum
	 * else add the left value to total sum
	 * if right is less than right+1 and right -1 then subtract the right value from total sum
	 * else add the right value to total sum
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		String romanNum = "IV";
		Assert.assertTrue(convertRomanToNumericNums(romanNum)==4);
	}

	@Test
	public void test2() {
		String romanNum = "LVIII";
		Assert.assertTrue(convertRomanToNumericNums(romanNum)==58);
	}

	@Test
	public void test3() {
		String romanNum = "MCMXCIV";
		Assert.assertTrue(convertRomanToNumericNums(romanNum)==1994);
	}
	
	@Test
	public void test4() {
		String romanNum = "CMXCIX";
		Assert.assertTrue(convertRomanToNumericNums(romanNum)==999);
	}
	
	@Test
	public void test5() {
		String romanNum = "XIV";
		Assert.assertTrue(convertRomanToNumericNums(romanNum)==14);
	}

	private int convertRomanToNumericNums(String roman) {
		int right = roman.length()-1 , output = 0;
		HashMap<Character,Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('M', 1000);
		romanMap.put('D', 500);
		romanMap.put('C', 100);
		romanMap.put('L', 50);
		romanMap.put('X', 10);
		romanMap.put('V', 5);
		romanMap.put('I', 1);
		
		if(roman.length()==1) return(romanMap.get(roman.charAt(0)));
		for (int i = 1; i < roman.length(); i+=2) {
			if(romanMap.get(roman.charAt(i)) > romanMap.get(roman.charAt(i-1))) {
				output += romanMap.get(roman.charAt(i))-romanMap.get(roman.charAt(i-1));
			}else if((romanMap.get(roman.charAt(i)) < romanMap.get(roman.charAt(i-1))) && (romanMap.get(roman.charAt(i)) < romanMap.get(roman.charAt(i+1)))) {
				output += romanMap.get(roman.charAt(i-1));
				i-=1;
			}else output += romanMap.get(roman.charAt(i))+romanMap.get(roman.charAt(i-1));
			int tmp = i+2;
			if(tmp == roman.length()) {
				if(romanMap.get(roman.charAt(i+1)) > romanMap.get(roman.charAt(i))) {
					output -=romanMap.get(roman.charAt(i));
					output +=romanMap.get(roman.charAt(i+1)) - romanMap.get(roman.charAt(i));
				}else output +=romanMap.get(roman.charAt(i+1));
			}
		}
		
		

		/*
		 * if(roman.length()==2) { output = (romanMap.get(roman.charAt(0)) >
		 * romanMap.get(roman.charAt(1)))? romanMap.get(roman.charAt(0) ) +
		 * romanMap.get(roman.charAt(1)) : romanMap.get(roman.charAt(1)) -
		 * romanMap.get(roman.charAt(0)); return output; }else if(roman.length()==1)
		 * return(romanMap.get(roman.charAt(0)));
		 * 
		 * output = romanMap.get(roman.charAt(left++)) +
		 * romanMap.get(roman.charAt(right--));
		 * 
		 * while(left <= right) { if((romanMap.get(roman.charAt(left))) <
		 * romanMap.get(roman.charAt(left+1)) && (romanMap.get(roman.charAt(left))) <
		 * romanMap.get(roman.charAt(left-1))){ output -=
		 * romanMap.get(roman.charAt(left++)); }else
		 * if((romanMap.get(roman.charAt(left))) > romanMap.get(roman.charAt(left+1)) &&
		 * (romanMap.get(roman.charAt(left))) > romanMap.get(roman.charAt(left-1))){
		 * output = romanMap.get(roman.charAt(left++))-output; } else output +=
		 * romanMap.get(roman.charAt(left++)); if(left==right || left > right)break;
		 * if((romanMap.get(roman.charAt(right))) < romanMap.get(roman.charAt(right+1))
		 * && (romanMap.get(roman.charAt(right))) <
		 * romanMap.get(roman.charAt(right-1))){ output -=
		 * romanMap.get(roman.charAt(right--)); }else
		 * if((romanMap.get(roman.charAt(right))) > romanMap.get(roman.charAt(right+1))
		 * && (romanMap.get(roman.charAt(right))) >
		 * romanMap.get(roman.charAt(right-1))){ output =
		 * romanMap.get(roman.charAt(right--)) - output; } else output +=
		 * romanMap.get(roman.charAt(right--)); }
		 */
		return output;
	}

}
