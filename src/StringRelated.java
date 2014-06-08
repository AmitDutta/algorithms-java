import static org.junit.Assert.*;

import org.junit.Test;

public class StringRelated {
	
	public String getFirstCharofStr(String str){
		StringBuffer buffer = new StringBuffer();
		boolean first = false;
		for (int i = 0; i < str.length(); i++){
			if (i == 0) first = true;
			if (str.charAt(i) != ' '){
				if (first){
					buffer.append(str.charAt(i));
					first = false;
				}
			}else{
				first = true;
			}
		}
		return buffer.toString();
	}
	
	public boolean isshuffled(String s1, String s2, String s3){
		if (s3.length() != s1.length() + s2.length()) return false;
		if (s3.length() ==  0 && s1.length() == 0 && s2.length() == 0) return true;
		if (s1.length() > 0 && s1.charAt(0)== s3.charAt(0)) return isshuffled(s1.substring(1), s2, s3.substring(1));
		else if (s2.length() > 0 && s2.charAt(0)== s3.charAt(0)) return isshuffled(s1, s2.substring(1), s3.substring(1));
		else return false;
	}
	
	@Test
	public void isShuffledTest(){
		String s1 = "abcd";
		String s2 = "xy";
		String s3 = "abcdxy";
		assertTrue(isshuffled(s1,s2,s3));		
	}
	
	@Test
	public void getFirstCharofStrTest(){
		StringRelated obj = new StringRelated();
		assertEquals("tiatc", obj.getFirstCharofStr(" this is a test case "));
		assertEquals("t", obj.getFirstCharofStr("        te "));
		assertEquals("aat", obj.getFirstCharofStr("asd       asdasd te"));
	}
}
