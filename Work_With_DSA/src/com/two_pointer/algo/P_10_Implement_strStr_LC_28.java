package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_10_Implement_strStr_LC_28 {
	
	/*
	 * https://leetcode.com/problems/implement-strstr/submissions/
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Two Pointer
	 * 
	 *
	 * Time / Space Complexity: O(n) / 0(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		String s = "hello";
		String p = "ll";
		Assert.assertTrue(strStr(s, p)==2);
	}

	@Test
	public void test2() {
		String s = "mississippi";
		String p = "pi";
		Assert.assertTrue(strStr(s, p)==9);
	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */
	
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int left = 0;
        
        for(int right = needle.length(); right<=haystack.length();right++){
            String currentString = haystack.substring(left++,right);
            if(needle.equals(currentString)) return left-1;
        }
        return -1;
    }
}
