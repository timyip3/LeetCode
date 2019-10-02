package longestPalindrome;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "abcdcbac";
		String isPalin = longestPalindrome(string);
		System.out.println("longestPalindrome: " + isPalin);
	}
	
	public static String longestPalindrome(String s) {
        if (s.length() == 0) {
        	return s;
        }
        
        int max_len = 1;
        int len = s.length();
        int max_start = 0;
        boolean[][] table = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
        	table[i][i] = true;
        }
        
        for (int i = 1;i < len; i++) {
        	if (s.charAt(i-1) == s.charAt(i)) {
        		table[i-1][i] = true;
        		max_len = 2;
        		max_start = i-1;
        	} else {
        		table[i-1][i] = false;
        	}
        }
        
        for (int k = 3; k <= len; k++) {
        	for (int i = 0; i <= s.length() - k; i++) {
        		int j = i + k - 1;
        		if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
        			table[i][j] = true;
        			
        			if (k > max_len) {
        				max_len = k;
        				max_start = i;
        			}
        		}
			}
		}
		
        
        return s.substring(max_start, max_start + max_len);
    }
}
