package int2Roman;

import java.util.HashMap;
import java.util.Map;

public class Int2Roman {
    public String intToRoman(int num) {
        if (num == 0)
            return "";
        if (num > 3999)
            return "";
        if (num < 0)
            return "";
        Map<Integer, String> symbolMap = new HashMap<Integer, String>();
        symbolMap.put(1, "I");
        symbolMap.put(2, "II");
        symbolMap.put(3, "III");
        symbolMap.put(4, "IV");
        symbolMap.put(5, "V");
        symbolMap.put(6, "VI");
        symbolMap.put(7, "VII");
        symbolMap.put(8, "VIII");
        symbolMap.put(9, "IX");
        symbolMap.put(10, "X");
        symbolMap.put(20, "XX");
        symbolMap.put(30, "XXX");
        symbolMap.put(40, "XL");
        symbolMap.put(50, "L");
        symbolMap.put(60, "LX");
        symbolMap.put(70, "LXX");
        symbolMap.put(80, "LXXX");
        symbolMap.put(90, "XC");
        symbolMap.put(100, "C");
        symbolMap.put(200, "CC");
        symbolMap.put(300, "CCC");
        symbolMap.put(400, "CD");
        symbolMap.put(500, "D");
        symbolMap.put(600, "DC");
        symbolMap.put(700, "DCC");
        symbolMap.put(800, "DCCC");
        symbolMap.put(900, "CM");
        symbolMap.put(1000, "M");
        symbolMap.put(2000, "MM");
        symbolMap.put(3000, "MMM");
        symbolMap.put(4000, "MMMM");

        StringBuilder result_sb = new StringBuilder();
        int it_num = num;
        int multi_times = 1;
        while (it_num > 0) {
            int digit = it_num % 10;
            System.out.println(digit);
            int real_num = digit * multi_times;

            String digit_sym = "";
            if (symbolMap.containsKey(real_num)) {
                digit_sym = symbolMap.get(real_num);
            }

            result_sb.insert(0, digit_sym);

            multi_times = multi_times * 10;
            it_num = it_num/10;
        }

        return result_sb.toString();
    }

    public static void main(String[] args) {
        int num = 2895;

        Int2Roman int2Roman = new Int2Roman();
        System.out.print(int2Roman.intToRoman(num));
    }
}
