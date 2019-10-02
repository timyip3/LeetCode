package zigZagConversion;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "PAYPALISHIRING";
		int numRows = 3	;
		String result = convert(string, numRows);
		System.out.println("result: " + result);
	}

	public static String convert(String s, int numRows) {
        int str_len = s.length();
		if (str_len <= numRows)
			return s;
		if (numRows == 1)
			return s;
		
		StringBuilder[] result_arr = new StringBuilder[numRows];
		for (int i = 0; i < result_arr.length; i++) {
			result_arr[i] = new StringBuilder();
		}
		
		//handle numRows == 2
		if (numRows == 2) {
			for (int i = 0; i < str_len; i++) {
				char c = s.charAt(i);
				if (i % 2 == 0) {
					result_arr[0] = result_arr[0].append(c);
				} else {
					result_arr[1] = result_arr[1].append(c);
				}
			}
		} else {
			// numRows > 2
			int num_char_bt_lines = numRows - 2;
			int num_char_per_zigzag = numRows + num_char_bt_lines;
			
			for (int i = 0; i < str_len; i++) {
				int num_char_in_zigzag = i % num_char_per_zigzag;
				char c = s.charAt(i);
				
				if (num_char_in_zigzag < numRows) {
					result_arr[num_char_in_zigzag] = 
							result_arr[num_char_in_zigzag].append(c);
				} else {
					int diff = num_char_in_zigzag - numRows;
					result_arr[num_char_bt_lines - diff] =
							result_arr[num_char_bt_lines - diff].append(c);
				}
			}
		}
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < result_arr.length; i++) {
			result.append(result_arr[i]);
		}
		
		return result.toString();
    }
}
