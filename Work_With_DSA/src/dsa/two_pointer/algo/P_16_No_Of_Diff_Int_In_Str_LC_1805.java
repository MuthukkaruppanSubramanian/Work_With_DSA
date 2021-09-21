package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_16_No_Of_Diff_Int_In_Str_LC_1805 {

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
		String s = "kiwlvsvfi6v7s985r0h6s28p7fnl5oupx7wjwuhchinxobbs3cu9znbzw89tvye05a4fmarpha9653cqp6z5hp1n22ighbi6pedqtgldudc8njufv74x1dctkhkvlf57egb464sqj8pgibiibu7ootcfpi6vgjd733j4ehillylhacru9v02ozjgbcqdqaeb3evvmuibc46szvn5pfgzkxedpapndua36534bzhoxckksbotw5jux1bm2f1clvv7wzwbzdr0nycsmw8tb7v30cty4st6cdbvxi9x65jy5fifulqol0s8ol1n4gz7paqzd1g78osqa9i23suvbgxkphafnxdfyx7588esf36ti1ua48rdecqi4xd24vm4ysd50mhrzl3ji4upely8zdtb47lp3cv7ol0fy3h2";
		System.out.println(numDifferentIntegers(s));
	}

	@Test
	public void test2() {
		String s = "0xa0";
		System.out.println(numDifferentIntegers(s));
	}

	@Test
	public void test3() {

	}

	/*
    1. Declare a set with sata type as string
    2. Traverse the word in for while
    3. ---while char at right - '0' is  < 9
    4. -------right++;
    5. ---take the sub string of left, right add to set
    6. ---else left++,right++;
    7. return the size of set
	 */
	public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<String>();
        int left = 0, right = 0;
        String tmp = "";
        while(right < word.length()){
            if(word.charAt(right)-'0' <= 9){
                while(right < word.length() && word.charAt(right)-'0' <= 9){
                    if(left == right && word.charAt(right)-'0' == 0) left++;
                    else tmp = tmp+""+word.charAt(right);
                    right++;
                }
                tmp = tmp.isEmpty()? "0" : tmp;
                set.add(tmp);
                tmp = "";
                left = right;
            }else{
                left++;
                right++;
            }
        }
        System.out.println(set);
        return set.size();
	}
}
