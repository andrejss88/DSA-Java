package com._1easy.strings;

/**
 * 344
 * Write a function that reverses a string.
 * The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory*.
 * <p>
 * * ie - can't create another array to store a copy or temp result (requires more memory)
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class ReverseString {

    public static char[] reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        char tempLeft;
        char tempRight;

        while (left < right) {

            // swap left and right
            tempLeft = s[left];
            tempRight = s[right];

            s[left] = tempRight;
            s[right] = tempLeft;

            // move left and right inward
            left++;
            right--;
        }
        return s;
    }

// Simple one-liner if it weren't for the "in-place" constraint:
// return new StringBuilder(String.valueOf(s)).reverse().toString();

}
