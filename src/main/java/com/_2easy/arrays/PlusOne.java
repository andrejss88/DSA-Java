package com._2easy.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem 66
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 3:
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */
public class PlusOne {

    // best solution (not mine)
    // can be done with a while loop too
    public static int[] plusOneBest(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;

        // simplest case - initial input num doesn't end with 9
        if (digits[lastIndex] != 9) {
            digits[lastIndex]++;
            return digits;
        }

        int ninesChanged = 0;
        for (int i = digits.length - 1; i >= 0; i--) {

            // for inputs 9, 99, 999, etc. - where we need a new, bigger array
            if (ninesChanged == digits.length - 1) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                return newArr; // [1,0], [1,0,0], [1,0,0,0], etc.
            }

            int current = digits[i];
            int next = digits[i - 1];

            if (current == 9 && next == 9) {
                digits[i] = 0;
                ninesChanged++;
            } else if (current == 9) {
                digits[i] = 0; // we change 9 here too, but we break out of the loop anyway
                digits[i - 1] = digits[i - 1] + 1;
                break; // leave - nothing else to do
            }
        }

        return digits;
    }

    public static int[] plusOneSlower(int[] digits) {
        int lastIndex = digits.length - 1;

        // simplest case - num doesn't end with 9
        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }

        // if we get here - last num is definitely 9
        // first, check if num is 9, 99, 999 - ie we need a new array
        // this is suboptimal - always O(n) for big and small arrays
        HashSet<Integer> ints = new HashSet<>(Arrays.stream(digits).boxed().toList());
        if (ints.size() == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }

        // all other cases - no new array
        // as long as we find two consecutive 9s - do +1 (9 -> 0)
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i];
            int next = digits[i - 1];

            if (current == 9 && next == 9) {
                digits[i] = 0;
            } else if (current == 9) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
                break; // leave - nothing else to do
            }
        }

        return digits;
    }
}
