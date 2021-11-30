package com.firstround.ques;

public class TC_Reverse_Word_In_Sentence {
	
	public static void main(String[] args) {
		//int 
		System.out.println(toFind("abbbab"));
	}
	
	private static char toFind(String str) {
		char appendChar = str.charAt(str.length()-1);
		String appendAll = "";
		appendAll += appendChar+str;
		System.out.println(appendAll);
		int left = 0,right=appendAll.length()-1;
		while(left<right) {
			if(appendAll.charAt(left)==appendAll.charAt(right)) {
				left++;
				right--;
			}else return 'z';
		}
		return appendChar;
	}
}
