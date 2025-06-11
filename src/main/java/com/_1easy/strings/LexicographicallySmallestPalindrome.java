package com._1easy.strings;

public class LexicographicallySmallestPalindrome {

    public static void main(String[] args) {


        System.out.println(makeSmallestPalindromeFaster("egcfe")); // efcfe
    }

    // 9ms, Beats Runtime 20%
    public static String makeSmallestPalindromeFaster(String s) {

        int left = 0;
        int right = s.length() - 1;

        var sb = new StringBuilder(s);

        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar == rightChar) {
                sb.setCharAt(left, leftChar);
                sb.setCharAt(right, rightChar);
            } else {
                if (leftChar < rightChar) {
                    sb.setCharAt(left, leftChar);
                    sb.setCharAt(right, leftChar);
                } else {
                    sb.setCharAt(left, rightChar);
                    sb.setCharAt(right, rightChar);
                }
            }
            left++;
            right--;
        }

        return sb.toString();
    }


    // 11ms, Beats Runtime 15%
    public static String makeSmallestPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        char[] newStr = new char[s.length()];

        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar == rightChar) {
                newStr[left] = leftChar;
                newStr[right] = rightChar;
            } else {
                if (leftChar < rightChar) {
                    newStr[left] = leftChar;
                    newStr[right] = leftChar;
                } else {
                    newStr[left] = rightChar;
                    newStr[right] = rightChar;
                }
            }
            left++;
            right--;
        }

        // replacing below with simply "return new String(newStr);"
        // takes runtime to 7ms, Beats 42%...
        var sb = new StringBuilder();
        for (char c : newStr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
