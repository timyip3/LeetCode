package validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "({[]})";
		System.out.println("result: " + isValid(string));
	}

	public static boolean isValid(String s) {
        if (s.length() == 0)
        	return true;
        
        Stack<Character> paraStack = new Stack<Character>();
        Map<Character, Character> paraMap = new HashMap<Character, Character>();
        paraMap.put(')', '(');
        paraMap.put(']', '[');
        paraMap.put('}', '{');
        
        for (int i = 0; i < s.length();i++) {
        	Character c = s.charAt(i);
        	
        	if (paraStack.isEmpty()) {
        		paraStack.push(c);
        	} else {
				Character topChar = paraStack.lastElement();
				
				if (paraMap.containsKey(c)) {
					Character correct_closed_para = paraMap.get(c);
					
					if (correct_closed_para.equals(topChar)) {
						paraStack.pop();
					} else {
						paraStack.push(c);
					}
				} else
					paraStack.push(c);
			}
        }
        
        if (paraStack.isEmpty()) {
			return true;
		} else
			return false;
    }
}
