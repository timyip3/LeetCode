package strStr;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        else if (haystack.length() == 0 || haystack.length() < needle.length())
            return -1;
        else {
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                boolean occur = true;

                for (int j = 0; j < needle.length(); j++) {
                    char char_haystack = haystack.charAt(i+j);
                    char char_needle = needle.charAt(j);

                    if (char_haystack != char_needle) {
                        occur = false;
                    }

                    if (!occur) {
                        break;
                    }
                }

                if (occur) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "abcd";
        String needle = "cde";

        StrStr solution = new StrStr();
        System.out.println("result: " + solution.strStr(haystack, needle));
    }
}
