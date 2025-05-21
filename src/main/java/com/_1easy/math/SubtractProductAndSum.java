package com._1easy.math;

/**
 * 1281
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 */
public class SubtractProductAndSum {

    // no tests - easy enough
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));

        System.out.println(subtractProductAndSumFaster(234));
    }

    public static int subtractProductAndSum(int n) {

        String numAsString = String.valueOf(n);
        int[] nums = new int[numAsString.length()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Character.getNumericValue(numAsString.charAt(i));
        }

        int product = 1;
        int sum = 0;

        for (int num : nums) {
            product *= num;
            sum += num;
        }
        return product - sum;
    }

    // someone's solution
    public static int subtractProductAndSumFaster(int n) {

        int sum = 0;
        int product = 1;

        // loop and work our way from the RIGHT of 'n', not left
        while (n > 0) {
            int digit = n % 10;  // get the digit (remainder) from left
            sum += digit;
            product *= digit;
            n /= 10;            // chop off the digit from left (divide and truncate decimal)
        }
        return product - sum;
    }

}
