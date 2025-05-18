package com._2easy.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem 66
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;

        // simplest case - initial input num doesn't end with 9
        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
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
