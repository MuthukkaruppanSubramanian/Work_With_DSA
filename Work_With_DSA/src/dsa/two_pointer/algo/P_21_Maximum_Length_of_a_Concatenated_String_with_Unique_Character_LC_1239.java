package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_21_Maximum_Length_of_a_Concatenated_String_with_Unique_Character_LC_1239 {
	
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
		List<String> s = Arrays.asList("un","iq","ue");
		System.out.println(maxLength(s));
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
    public int maxLength(List<String> arr) {
        int maxLength = 0;
        for(int i=0; i < arr.size(); i++){
            String s = arr.get(i);
            for(int j = i+1; j < arr.size(); j++){
                boolean found = false;
                for(int k = 0; k<arr.get(j).length();k++){
                    if(s.indexOf(arr.get(j).charAt(k)) != -1)  found = true;
                }
                if(!found) s = s+""+arr.get(j);
            }
            maxLength = Math.max(maxLength,s.length());
        }
        return maxLength;
    }
}
