package LongestSubStrNoRepeatChar;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrNoRepeatChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcabcbb";
		int result = lengthOfLongestSubstring(input);
		System.out.println("length: " + result);
	}

	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int numOfChar = 0;
		Map<Character, Integer> charToIntMap = new HashMap<Character, Integer>();
		
		if (s.length() <= 1) {
			result = s.length();
		} else {
			for (int i = 0; i< s.length();i++) {
				if (charToIntMap.containsKey(s.charAt(i))) {
					numOfChar = Math.max(numOfChar, charToIntMap.get(s.charAt(i)));
				}
				
				charToIntMap.put(s.charAt(i), i+1);
				result = Math.max(result, i - numOfChar + 1);
			}
		}
		
		return result;
    }
}
