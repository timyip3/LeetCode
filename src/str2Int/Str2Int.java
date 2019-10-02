package str2Int;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Str2Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "2147483646";
		int result = myAtoi(string);
		System.out.println("result: " + result);
	}
	
	public static int myAtoi(String str) {
        if (str.isEmpty())
        	return 0;
        
        int result = 0;
        String str_trim = str.trim();
        StringBuilder sb = new StringBuilder(str_trim);
        String regex = "^(\\d+|\\+\\d+|\\-\\d+)\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);
        
        if (!matcher.find()) {
        	return result;
        } else {
        	int end = matcher.end();
			int start_index = 0;
			
			String num_str = sb.substring(start_index, end);
			System.out.println("end: " + end + "str: " + num_str);
			double num_long = Double.parseDouble(num_str);
			
			if (num_long >= Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
			} else if (num_long <= Integer.MIN_VALUE) {
				result = Integer.MIN_VALUE;
			} else {
				result = (int) num_long;
			}
			
			return result;
		}
    }
}
