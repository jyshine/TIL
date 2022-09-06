package org.example.stringTest;

public class DuplicationCheck {

    public static void main(String[] args) {
        System.out.println(isUnique("abcdefghijklmn"));
        System.out.println(isUnique("abccdefghijklmn"));
    }

    /**
     * ASCII = 128
     *
     * @param str
     * @return
     */
    private static boolean isUnique(String str) {
        if (str.length() > 128) return false;
        boolean[] charSet = new boolean[128];
        for (int i=0; i<str.length(); i++){
            System.out.println(str.charAt(i));
            int val = str.charAt(i);
            System.out.println(val);
            if(charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }


}
