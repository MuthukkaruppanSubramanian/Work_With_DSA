package com.two_pointer.algo;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.*;

public class P_19_Max_Num_of_Words_You_Can_Type_LC_1935 {
	
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
		String s = "hello world", brokenletters = "ad";
		System.out.println(canBeTypedWords(s, brokenletters));
	}

	@Test
	public void test2() {
		String s = "leet code", brokenletters = "lt";
		System.out.println(canBeTypedWords(s, brokenletters));
	}

	@Test
	public void test3() {
		String s = "helld world", brokenletters = "ad";
		System.out.println(canBeTypedWords(s, brokenletters));
	}
	
	/*
	 * Pseudo Code
	 * Split the given text using space
	 * Iterate the each word
	 * ---Iterate the each char at broken letters
	 * -------set a boolean notfound as true
	 * -------check the index of that char in word if it return >=0
	 * ---------then break
	 * ---count++
	 * ---return count
	 */
	
    public int canBeTypedWordsop(String text, String brokenLetters) {
        int count = 0;
        String[] words = text.split("\\s");
        count = words.length;
        for(String word : words) {
        	boolean notFound = false;
        	int left = 0, right = brokenLetters.length()-1;
        	while(left <= right) {
        		if((word.indexOf(brokenLetters.charAt(right--)) < 0) &&
        				(word.indexOf(brokenLetters.charAt(left++)) < 0)) {
        			notFound = true;
        			break;
        		}
        	}
        	if(notFound) count--;
        }
    	return count;
    }
    
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String[] words = text.split("\\s");
        char[] charArray = brokenLetters.toCharArray();
        for(String word : words) {
        	boolean found = false;
        	for(int i = 0; i < brokenLetters.length(); i++) {
        		if(word.indexOf(charArray[i]) >= 0) {
        			found = true;
        		}
        	}
        	if(found) count++;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    	return words.length-count;
    	
    }
}
