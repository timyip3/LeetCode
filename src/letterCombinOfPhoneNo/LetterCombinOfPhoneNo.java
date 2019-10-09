package letterCombinOfPhoneNo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinOfPhoneNo {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> no_Letter_Map = new HashMap<Character, String>();
        no_Letter_Map.put('1', "");
        no_Letter_Map.put('2', "abc");
        no_Letter_Map.put('3', "def");
        no_Letter_Map.put('4', "ghi");
        no_Letter_Map.put('5', "jkl");
        no_Letter_Map.put('6', "mno");
        no_Letter_Map.put('7', "pqrs");
        no_Letter_Map.put('8', "tuv");
        no_Letter_Map.put('9', "wxyz");
        no_Letter_Map.put('0', "");

        List<String> results = new ArrayList<String>();
        dfs(digits, 0, new StringBuilder(), results, no_Letter_Map);
        return results;
    }

    public void dfs(String digits, int index, StringBuilder result, List<String> results,
                    Map<Character, String> no_letter_map) {
        if (index == digits.length()) {
            if (index > 0) {
                results.add(result.toString());
                return;
            }
        }

        String chars = no_letter_map.get(digits.charAt(index));
        for (int i = 0; i < chars.length(); i++) {
            char letter = chars.charAt(i);
            result.append(letter);
            dfs(digits, index + 1, result, results, no_letter_map);
            result.deleteCharAt(result.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinOfPhoneNo solution = new LetterCombinOfPhoneNo();
        System.out.println("result: " + solution.letterCombinations(digits));
    }

}
