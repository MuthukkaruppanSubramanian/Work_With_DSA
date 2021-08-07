import org.junit.Assert;
import org.junit.Test;

public class LC_394_Decode_String_Recursion {
	String output = "";
	
	@Test
	public void test1() {
		String s = "3[a2[c]]";
		Assert.assertTrue(decodeString(s).equals("accaccacc"));
	}
	
	@Test
	public void test2() {
		String s = "3[a]2[bc]";
		Assert.assertTrue(decodeString(s).equals("aaabcbc"));
	}
	
	@Test
	public void test3() {
		String s = "2[abc]3[cd]ef";
		Assert.assertTrue(decodeString(s).equals("abcabccdcdcdef"));
	}

	@Test
	public void test4() {
		String s = "abc1[3[cd]]xyz";
		Assert.assertTrue(decodeString(s).equals("abccdcdcdxyz"));
	}
	
	@Test
	public void test5() {
		String s = "100[abc]";
		Assert.assertTrue(decodeString(s).equals("abc"));
	}
	
	private String decodeString(String s) {
		int firstClose 	= s.indexOf(']');
		if(firstClose == -1) return s;
		int firstOpen = firstClose;
		while(s.charAt(--firstOpen)!='[') {	}
		//int number      = (Character.isDigit(s.charAt(firstOpen-1)))? s.charAt(firstOpen-1)-'0' : 1;
		int numberIndex = firstOpen;
		while(--numberIndex >=0 && Character.isDigit(s.charAt(numberIndex))) {
		}
		int number = Integer.parseInt(s.substring(++numberIndex,firstOpen));
		String tmp2 = s.substring(firstOpen+1,firstClose).repeat(number);
		if(numberIndex == 0) {
			output = tmp2+s.substring(firstClose+1);
		}else if(firstClose==s.length()-1) {
			output = s.subSequence(0, numberIndex)+tmp2;
		}else {
			
			output = s.substring(0,numberIndex)+tmp2+s.substring(firstClose+1);
		}
		return decodeString(output);
	}
	
	private String reverseString(String s) {
		System.out.println(s.lastIndexOf('['));
		System.out.println(s.indexOf(']'));
		if(s.isEmpty()) return "";
		output += s.charAt(s.length()-1);
		reverseString(s.substring(0,s.length()-1));
		return output;
	}
	
}
