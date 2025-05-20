package com._1warmup.misc;

/**
 * 258
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * <p>
 * Example 2:
 * <p>
 * Input: num = 0
 * Output: 0
 */
public class AddDigits {

    public static int addDigits(int num) {
        if (num <= 9) {
            return num;
        }

        String str = String.valueOf(num);

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }

        if (sum >= 10) {
            return addDigits(sum);
        }

        return sum;
    }

    // someone else's one-line trick solution
    // called digital root in math
    
    // return 1 + (num - 1) % 9;

}
