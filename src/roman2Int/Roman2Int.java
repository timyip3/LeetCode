package roman2Int;

import java.util.HashMap;
import java.util.Map;

public class Roman2Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "MCMXCIV";
		int result = roman2Int(s);
		System.out.println("result: " + result);
	}

	public static int roman2Int(String s) {
		Map<Character, Integer> symbolMap = new HashMap<Character, Integer>();
		
		symbolMap.put('I', 1);
		symbolMap.put('V', 5);
		symbolMap.put('X', 10);
		symbolMap.put('L', 50);
		symbolMap.put('C', 100);
		symbolMap.put('D', 500);
		symbolMap.put('M', 1000);
		
		int result = 0;
		int curr = 0;
		
		if (s.length() == 0)
			return 0;
		if (s.length() == 1) {
			return symbolMap.get(s.charAt(0));
		} else {
			while (curr <= s.length()-2) {
				//check if subtraction is needed on s[0] and s[1]
				if (symbolMap.get(s.charAt(curr)) < symbolMap.get(s.charAt(curr+1))) {
					result = result +
							symbolMap.get(s.charAt(curr+1)) - symbolMap.get(s.charAt(curr));
					curr = curr + 2;
				} else {
					result = result + 
							symbolMap.get(s.charAt(curr));
					curr = curr + 1;
				}
			}
			
			if (curr == s.length()-1)
				result = result + symbolMap.get(s.charAt(s.length()-1));
		}
		
		return result;
	}
}
