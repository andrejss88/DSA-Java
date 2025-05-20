package com._2easy.arrays;

/**
 * 1979
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * <p>
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * <p>
 * Example:
 * Input: nums = [2,5,6,9,10]
 * Output: 2
 */
public class FindGreatestCommonDivisorOfArray {

    public static int findGCD(int[] nums) {

        int min = nums[0];  // init with whatever value, it will be overwritten
        int max = 0;

        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        // looked at a hint for this one
        int maxDivisor = 1;
        for (int i = 1; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                maxDivisor = i;
            }
        }
        return maxDivisor;
    }
}
