package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_20_Check_if_One_String_Swap_Can_Make_Strings_Equal_LC_1790 {
	
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
		String s1 = "bank", s2 = "kanb";
		Assert.assertTrue(areAlmostEqual(s1, s2));
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
	
    public boolean areAlmostEqual(String s1, String s2) {
        int p1 = -1;
        StringBuilder sb = new StringBuilder(s2);
        for (int right = 0; right < s2.length(); right++){
            if(s1.charAt(right) != s2.charAt(right)){
                if(p1 == -1)p1 = right;
                else{
                    sb.setCharAt(p1, s2.charAt(right));
                    sb.setCharAt(right, s2.charAt(p1));
                    return sb.toString().equals(s1);
                } 
            }
        }
        return sb.toString().equals(s1);
    }
}
