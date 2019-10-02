package regexMatching;

public class RegexMatching {
    public boolean isMatch(String s, String p) {
        final int STR_LEN = s.length();
        final int PTN_LEN = p.length();
        final char DOT_CHAR = '.';
        final char WILDCARD_CHAR = '*';
        boolean[][] map = new boolean[STR_LEN+1][PTN_LEN+1];

        map[0][0] = true;
        for (int j = 1; j <= PTN_LEN; j++) {
            char ptn_char = p.charAt(j-1);
            if (ptn_char == WILDCARD_CHAR) {
                map[0][j] = map[0][j-2];
            }
        }

        for (int i = 1; i <= STR_LEN; i++) {
            char str_char = s.charAt(i-1);
            for (int j = 1; j <= PTN_LEN; j++) {
                char ptn_char = p.charAt(j-1);

                if (ptn_char == str_char || ptn_char == DOT_CHAR) {
                    map[i][j] = map[i-1][j-1];
                }

                else if (ptn_char == WILDCARD_CHAR) {
                    map[i][j] = map[i][j-2];

                    if (str_char == p.charAt(j-2) || p.charAt(j-2) == DOT_CHAR) {
                        // (i-1,j-1) : when ba, ba* 1 occurrence
                        // (i, j-2): when ba, bc* 0 occurrence
                        // (i-1, j): when baa, ba* more than 1 occurrence
                        map[i][j] = map[i][j-1] || map[i][j-2] || map[i-1][j];
                    }
                }

                //System.out.printf("%s\t", map[i][j]);
            }

            //System.out.println();
        }

        return map[STR_LEN][PTN_LEN];
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) {
        String s = "aasdfas";
        String p = "aasdf.*.*s";

        boolean ret = new RegexMatching().isMatch(s, p);

        String out = booleanToString(ret);

        System.out.print(out);
    }
}
