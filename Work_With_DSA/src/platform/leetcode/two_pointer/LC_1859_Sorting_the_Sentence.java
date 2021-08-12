package platform.leetcode.two_pointer;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class LC_1859_Sorting_the_Sentence {
	@Test
	public void test1() {
		String s = "is2 sentence4 This1 a3";
		Assert.assertTrue(sortTheGivenSentenceOptimized(s).equals("This is a sentence"));
	}

	@Test
	public void test2() {
		String s = "Myself2 Me1 I4 and3";
		Assert.assertTrue(sortTheGivenSentenceOptimized(s).equals("Me Myself and I"));
	}

	@Test
	public void test3() {
		String s = "This1 good3 is2";
		Assert.assertTrue(sortTheGivenSentenceOptimized(s).equals("This is good"));
	}

	//Brute force //O(n) / O(n)
	private String sortTheGivenSentence(String s) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		String[] sArray = s.split(" ");
		for (int i = 0; i < sArray.length; i++) {
			map.put(Integer.parseInt(sArray[i].substring(sArray[i].length()-1)), sArray[i].substring(0,sArray[i].length()-1));
		}
		s= "";
		for (int i = 1; i <= sArray.length; i++) {
			s +=map.get(i)+" ";
		}
		return s.trim();
	}
	
	//Brute force //O(n) / O(n)
	private String sortTheGivenSentenceOptimized(String s) {
		String[] sArray = new String[10]; //Constrain of index is 1-9 so array size is 10
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				sArray[s.charAt(i)-'0'] = s.substring(index, i).trim();
				index = i+1;
			}
		}
		s= "";
		for (int i = 1; i < sArray.length; i++) {
			if(sArray[i]!= null)
				s += sArray[i]+" ";
		}
		System.out.println(s.trim());
		return s.trim();
	}
}
