package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EqualsTest {
	public static void main(String[] args){
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2); //true == do reference check
		System.out.println(s1.equals(s2)); //true equals do contents check
		
		s1 = new String("abc");
		s2 = new String("abc");
		System.out.println(s1 == s2); // false; new reference
		System.out.println(s1.equals(s2)); //true; contect check
		
		s1 = s2;
		System.out.println(s1 == s2); // true
		System.out.println(s1.equals(s2)); //true; contect check
		
		String a = "Z";
		String b = "amit	";
		List<String> strings = new ArrayList<String>();
		strings.add(a);
		strings.add(b);
		Collections.sort(strings, Collections.reverseOrder());
		for(String str : strings)System.out.println(str);
	}
}
