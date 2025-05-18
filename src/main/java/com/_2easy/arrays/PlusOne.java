package com._2easy.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem 66
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;

        // simplest case - doesn't end with 9
        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }

        // if we get here - last num is def 9
        // first, check if num is 9, 99, 999 - ie need a new array
        HashSet<Integer> ints = new HashSet<>(Arrays.stream(digits).boxed().toList());
        if (ints.size() == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }

        // all other cases - no new array, loop backward and +1 each until result of +1 is not 9 -> 0
        // check if CURRENT 9 and NEXT is 9
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i];
            int next = digits[i - 1];
            if (current == 9 && next != 9) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
                break; // leave - nothing else to do
            } // but if we have two 9s together - more logic
        }

        return digits;
    }

//    Create new scratch file from selection

//            for (int i = digits.length - 1; i >= 0; i--) {
//        if (digits[i] == 9) {
//            digits[i] = 0;
//            digits[i - 1] = digits[i - 1] + 1;
//            break;
//        }
//    }

//    int[] newArr = null;
//        for (int i = digits.length;
//    i > 0 && digits.length == i; // break early once loop expanded
//    i--) {
//        // create new empty array of new size,
//        // all slots set to 0 by default, set 1st elem to 1
//        newArr = new int[digits.length + 1];
//        newArr[0] = 1;
//        System.out.println("looped");
//    }
//        return newArr;

//    digits[lastIndex] = 0;
//    digits[digits.length - 1] = digits[digits.length - 1] + 1;


//    if (digits[lastIndex] == 9) {
//        HashSet<Integer> ints = new HashSet<>(Arrays.stream(digits).boxed().toList());
//
//        // for 9, 99, 999...
//        if (ints.size() == 1) {
//            int[] newArr = new int[digits.length + 1];
//            newArr[0] = 1;
//            return newArr;
//            // for 19, 29, 389...
//        } else {
//            int[] newArr = new int[digits.length];
//            newArr[0] = digits[0] + 1;
//            return newArr;
//        }
//    }

}
