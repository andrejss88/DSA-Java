package com._1easy.math;

import java.util.Arrays;

/**
 * 2160
 */
public class MinimumSumForDigitNumberAfterSplittingDigits {

    // no tests
    public static void main(String[] args) {

        System.out.println(minimumSum(2932));
        System.out.println(minimumSum(4009));
    }

    // used a hint about how to pick two smallest nums in 4 digits
    public static int minimumSum(int num) {

        // [2, 3, 9, 2]
        // if we had more digits, we could do this with a loop
        int[] digits = new int[]{num % 10, num % 100 / 10, num % 1000 / 100, num % 10_000 / 1000};

        // [2, 2, 3, 9]
        Arrays.sort(digits);

        // original solution
//        int numOne = Integer.parseInt((digits[0]) + String.valueOf(digits[2]));
//        int numTwo = Integer.parseInt((digits[1]) + String.valueOf(digits[3]));

        // much smarter - 2 becomes 20, so 20 + 2 = 22
        int numOne = digits[0] * 10 + digits[2];
        int numTwo = digits[1] * 10 + digits[3];

        return numOne + numTwo;
    }
}
