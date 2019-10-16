package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();

        if (n != 0)
            genParen(results, n, n, new StringBuilder());

        return results;
    }

    public void genParen(List<String> results, int left, int right, StringBuilder tmp) {
        if (right == 0) {
            results.add(tmp.toString());
            return;
        } else {
            if (left > 0) {
                tmp.append("(");
                genParen(results, left - 1, right, tmp);
                tmp.deleteCharAt(tmp.length()-1);
            }

            if (left < right) {
                tmp.append(")");
                genParen(results, left, right - 1, tmp);
                tmp.deleteCharAt(tmp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> results = new Solution().generateParenthesis(n);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
