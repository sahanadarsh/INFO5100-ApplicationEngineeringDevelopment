package Assignment6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given two strings s and t , write a function to determine 
 * if t is an anagram of s. (Score 2)
 * Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true

        Example 2:
        Input: s = "rat", t = "car"
        Output: false

        Note:
        You may assume the string contains only lowercase alphabets.

 */

public class Anagram {

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(Arrays.equals(c1, c2)) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean IsAnagramUsingMaps(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		Map<Character,Integer> map1 = new HashMap<>();

		for(int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			map1.put(c,map1.getOrDefault(c,0)+1);
		}

		for(int i=0; i < t.length(); i++) {
			char c = t.charAt(i);
			if( !map1.containsKey(c) || map1.get(c) == 0) {
				return false;
			}else {
				map1.put(c, map1.get(c) - 1);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println("s and t are anagaram: " + isAnagram(s,t));
	}
}
