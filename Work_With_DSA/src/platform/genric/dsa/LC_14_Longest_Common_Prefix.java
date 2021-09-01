package platform.genric.dsa;
import org.junit.*;
import java.util.*;

public class LC_14_Longest_Common_Prefix {
	
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
		String[] str = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(str));
	}

	@Test
	public void test2() {
		String[] str = {"flower","Tap","dlight"};
		System.out.println(longestCommonPrefix(str));
	}

	@Test
	public void test3() {
		String[] str = {"flower","Tap","flight"};
		System.out.println(longestCommonPrefix(str));
	}
	
	/*
	 * Pseudo Code
	 */
	
    public String longestCommonPrefix(String[] strs) {
        
        /*
        * 8:02
        * Declare hash map with key as char and value as treeset
        * Iterate the given array
        * ---based on the first char push to the string to tree set
        * ----check the max count with the current char count
        * 
        */
        if(strs[0].equals("")) return "";
        
        char firstChar = strs[0].charAt(0);
        int minLength = strs[0].length();
        String sample = strs[0];
        for(int i =1; i<strs.length; i++){
            if(strs[i].equals("")) return "";
            if(firstChar == (strs[i].charAt(0))){
                minLength = Math.min(minLength, strs[i].length());
                if(minLength == strs[i].length()) sample = strs[i];
            }else{
                return "";
            }
        }
        
        StringBuilder output = new StringBuilder();
        output.append(sample.charAt(0));
        for(int i = 1; i<sample.length();i++){
            for(int j = 0; j<strs.length; j++){
                if (!(sample.charAt(i) == (strs[j].charAt(i)))){
                    if(output.equals("")) return "";
                    else return output.toString();
                }
            }
            output.append(sample.charAt(i));
        }
        return output.toString();
    }
}
