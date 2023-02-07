package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_14_Long_Pressed_Name_LC_925 {
	
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
	
	//@Test
	public void test1() {
		String name = "alex";
		String typed = "aaleex";
		System.out.println(isLongPressedName(name, typed));
	}

	@Test
	public void test2() {
		String name = "abcd";
		String typed = "aaabbbcccddd";
		System.out.println(isLongPressedName(name, typed));
	}

	@Test
	public void test3() {
		String name = "alex";
		String typed = "aaleeexeex";
		System.out.println(isLongPressedName(name, typed));
	}

	@Test
	public void test4() {
		String name = "a";
		String typed = "aaaaa";
		System.out.println(isLongPressedName(name, typed));
	}

	@Test
	public void test5() {
		String name = "leelee";
		String typed = "lleeelee";
		System.out.println(isLongPressedName(name, typed));
	}
	
	/*
	 * Pseudo Code
	 */
	
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) {
            return false;
        } else if ((name.charAt(0) != typed.charAt(0)) || (name.charAt(name.length()-1) != typed.charAt(typed.length()-1))){
            return false;   
        }
        int nameLeft = 1, nameRight = name.length()-2;
        int typedLeft = 1, typedRight = typed.length()-2;
        
        while(nameLeft <= nameRight){
        	while(typed.charAt(typedLeft) == typed.charAt(typedLeft-1)){
        		if(name.charAt(nameLeft) != typed.charAt(typedLeft))
        			typedLeft++;
        		else break;
        	}
        	while(typed.charAt(typedRight) == typed.charAt(typedRight+1)) {
        		if(name.charAt(nameRight) != typed.charAt(typedRight))
        			typedRight--;
        		else break;
        	}
            
            if((name.charAt(nameLeft) != typed.charAt(typedLeft)) || (name.charAt(nameRight) != typed.charAt(typedRight))){
              return false;  
            }else {
                nameLeft++; typedLeft++; typedRight--; nameRight--;
            }
        }
        
        while (typedLeft < typedRight){
            if((typed.charAt(typedLeft) != typed.charAt(typedLeft-1)) || (typed.charAt(typedRight) != typed.charAt(typedRight+1)))
                return false;
            typedLeft++;
            typedRight--;
        }
        return true;
    }
}
