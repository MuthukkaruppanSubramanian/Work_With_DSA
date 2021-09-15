package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_11_Pal_Alto_Nteworks_Nice_String {
	
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
		String s = "azABaabza";
		System.out.println(balancedString(s));
	}

	@Test
	public void test2() {
		String s = "TacoCat";
		System.out.println(balancedString(s));
	}

	@Test
	public void test3() {
		String s = "AcZCbaBz";
		System.out.println(balancedString(s));
	}
	
	/*
	 * Pseudo Code
	 */
	
	public int balancedString(String s) {
		Set<Character> lowerCase = new HashSet<>();
		Set<Character> upperCase = new HashSet<>();
		Set<Character> common = new HashSet<>();
		Set<Character> output = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				upperCase.add(s.charAt(i));
			}else {
				lowerCase.add(s.charAt(i));
			}
		}
		
		for(Character c : upperCase) {
			if(lowerCase.contains(Character.toLowerCase(c))) {
				common.add(c);
				common.add(Character.toLowerCase(c));
			}
		}
		
		int left = 0, right = 0, minLength = Integer.MAX_VALUE;
		for(right = 0; right < s.length(); right++) {
			if(common.contains(s.charAt(right)))
				output.add(s.charAt(right));
			else {
				output.clear();
				left = right+1;
			}
			
			if(common.equals(output))
				minLength = Math.min(minLength, right-left+1);
		}
		
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
}






