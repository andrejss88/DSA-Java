package com._1easy.strings;

import java.util.regex.Pattern;

/**
 * 125
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {

    private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^A-Za-z0-9]");

    // my solution
    public static boolean isPalindrome(String s) {
        char[] arr = NON_ALPHANUMERIC.matcher(s)
                .replaceAll("").toLowerCase().toCharArray();

        if (arr.length == 0) return true;

        // Two pointers - start from opposite ends and move toward center
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // someone else's solution improved by me
    // other's solution had .toLowerCase() inside the loop on each char
    public static boolean isPalindromeFaster(String s) {

        // Two pointers - start from opposite ends and move toward center
        int left = 0;
        int right = s.length() - 1;
        String smallStr = s.toLowerCase();

        while (left <= right) {
            char leftChar = smallStr.charAt(left);
            char rightChar = smallStr.charAt(right);

            // If either char not alphanum - ignore, move the pointer, and go back to the loop
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            } else if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
