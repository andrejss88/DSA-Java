package com._2easy.strings;

/**
 * 9
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */
public class PalindromeNumber {


    public static boolean isPalindrome(int x) {

        // negative nums are not palindromes
        if (x < 0) {
            return false;
        }

        // single digit is considered a palindrome
        // though this check can be removed - below works for single digits too
        if (x > 0 && x < 9) {
            return true;
        }

        String numAsString = String.valueOf(x);

        int left = 0;
        int right = numAsString.length() - 1;

        while (left < right) {
            if (numAsString.charAt(left) != numAsString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
