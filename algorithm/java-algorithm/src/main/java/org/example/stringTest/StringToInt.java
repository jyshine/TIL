package org.example.stringTest;

class Solution2 {

    public Integer stringToInt(String s,int radix) {
        String regExp = "^-?[0-9]+$";

        if (!s.matches(regExp)){
            return null;
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                }
                i++;
            }

            while (i < len) {
                digit = Character.digit(s.charAt(i++), radix);
                System.out.println(digit);
                result *= radix;
                System.out.println(result);
                result -= digit;
                System.out.println(result);
            }
        }
        return negative ? result : -result;
    }
}
public class StringToInt {


    public static void main(String[] args) {

        assert stringToInteger("123") == 123 : "123";
        Solution2 solution2 = new Solution2();
        Integer i = solution2.stringToInt("-123", 10);
        System.out.println(i);
//        System.out.println(i==-1242);
    }

    private static int stringToInteger(String s) {
        return 0;
    }
}
