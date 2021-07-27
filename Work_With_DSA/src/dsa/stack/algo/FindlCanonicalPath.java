package dsa.stack.algo;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class FindlCanonicalPath {
	/*
	 * Given a string path, which is an absolute path (starting with a slash '/') to
	 * a file or directory in a Unix-style file system, convert it to the simplified
	 * canonical path. In a Unix-style file system, a period '.' refers to the
	 * current directory, a double period '..' refers to the directory up a level,
	 * and any multiple consecutive slashes (i.e. '//') are treated as a single
	 * slash '/'. For this problem, any other format of periods such as '...' are
	 * treated as file/directory names.
	 * 
	 * 
	 * The canonical path should have the following format:
	 * 
	 * The path starts with a single slash '/'. Any two directories are separated by
	 * a single slash '/'. The path does not end with a trailing '/'. The path only
	 * contains the directories on the path from the root directory to the target
	 * file or directory (i.e., no period '.' or double period '..') Return the
	 * simplified canonical path.
	 * 
	 * Example 1: Input: path = "/home/" Output: "/home" Explanation: Note that
	 * there is no trailing slash after the last directory
	 */
	
	
	/*
	 * 	 * Given Input  data type: String
	 *           Output data type: String
	 *           
	 *           // - /
	 *           ../ - skip previous dir
	 *           . - current dir
	 *           skip the last /
	 *           
	 *           
	 * Sample Test Data 
	 *    Input : s = "/home/"
	 *    output: /home
	 *        
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 * Pseudo code:
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String s = "/home/";
		Assert.assertTrue(findTheCanonicalpath(s)=="/home");

	}
	
	@Test
	public void test2() {
		String s = "/home//a/";
		Assert.assertTrue(findTheCanonicalpath(s)=="/home/a");
	}

	@Test
	public void test3() {
		String s = "/home//../a/";
		String[] strArray = s.split("/");
		
		Assert.assertTrue(findTheCanonicalpath(s)=="/a");
	}
	
	@Test
	public void test4() {
		String s = "/a/./b/../../c/";
		
		Assert.assertTrue(findTheCanonicalpath(s).equals("/c"));
	}

	/*Pseudo Code
	 * Create a empty stack of type String
	 * Convert the String s to String [] by spliting with '/'
	 * Travers the string array in for loop
	 * Check if the current element is equal to .. check stack is not empty and do pop
	 * else then check if the element is empty and stack.peek is not equal to /
	 * 		then push '/'
	 * else check if the element is equal to . continue
	 * else push the element to stack
	 * 
	 * 
	 * 
	 * 
	 * else check if the element is equal to .
	 */
	
	
	private String findTheCanonicalpath(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
























