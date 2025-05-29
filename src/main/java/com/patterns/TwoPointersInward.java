package com.patterns;

import java.util.Arrays;

public class TwoPointersInward {


    public static void main(String[] args) {

        // Moving INWARD example 1:
        // simple, just checking left == right, and left++ / right--
        var isPalindromicNum = isPalindrome(123321);
        System.out.println(isPalindromicNum);

        // Moving INWARD example 2: for reversing, swapping
        // a bit more complex, needs temp variable to store left/right before swapping, then left++ / right--
        var reversed = reverse(new char[]{'a','b','c'});
        System.out.println(Arrays.toString(reversed));
    }


    private static char[] reverse(char[] s) {

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

    private static boolean isPalindrome(int x) {

        // negative nums are not palindromes
        if (x < 0) {
            return false;
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
