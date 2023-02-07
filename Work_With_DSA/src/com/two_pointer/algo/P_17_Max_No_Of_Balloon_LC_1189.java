package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_17_Max_No_Of_Balloon_LC_1189 {
	
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
		String text = "balon";
		System.out.println(maxNumberOfBalloons(text));
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
	
    public int maxNumberOfBalloons(String text) {
        /*
           1. Delcare a pattern map and collectionMap
           2. Add the pattern occurrence of char in ballon
           3. Traverse the string and add char occurrence to collection map if that char contains in pattern map
           4. Create a infine lopp
           5.   Iterate the pattern map
           6.      if that char exists and char count > 0
           7.           subtract that ocuurrence in collection map
           8.      else break
           9.   count++
           10.return count
         */
        
        HashMap<Character, Integer> pattern = new HashMap<Character, Integer>();
        pattern.put('b',1);
        pattern.put('a',1);
        pattern.put('l',2);
        pattern.put('o',2);
        pattern.put('n',1);
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = text.toCharArray();
        for(Character letter : charArray){
            map.put(letter, map.getOrDefault(letter, 0)+1);
        }
        boolean loop = true;
        while(loop){
            for(Map.Entry<Character,Integer> set : pattern.entrySet()){
                if(map.containsKey(set.getKey()) && map.get(set.getKey()) > 0){
                    map.put(set.getKey(), map.getOrDefault(set.getKey(), 0)-set.getValue());
                    if(map.get(set.getKey()) < 0) {
                    	loop = false;
                    	break;
                    }
                }else{
                    loop = false;
                    break;
                }
            }
            count++;
        }
        return count-1;
    }
}
