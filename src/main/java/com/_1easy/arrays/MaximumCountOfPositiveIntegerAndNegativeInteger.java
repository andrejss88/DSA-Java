package com._1easy.arrays;

/**
 * 2529
 * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
 * <p>
 * In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
 * Note that 0 is neither positive nor negative.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,-1,-1,1,2,3]
 * Output: 3
 * Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
 */
public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static void main(String[] args) {
        System.out.println(maximumCountFaster(new int[]{-2, -1, -1, 1, 2, 3})); // 3
        System.out.println(maximumCountFaster(new int[]{-3, -2, -1, 0, 0, 1, 2}));  // 3
        System.out.println(maximumCountFaster(new int[]{0, 0}));  // 0
        System.out.println(maximumCountFaster(new int[]{-2, -1, -1}));  // 3
        System.out.println(maximumCountFaster(new int[]{1, 1, 2}));  // 3
    }

    public static int maximumCountBinary(int[] nums) {

        int searchValue = 0;

        // search for 0 using binary - get its index
        return -1;
    }

    // 0ms, Beats 100% Runtime - measurement is same, but may be faster with some inputs
    // with very large number of positive numbers
    public static int maximumCountFaster(int[] nums) {

        int neg = 0;

        // break early when we find first positive
        int firstPosIndx = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (val < 0) neg++;

            if (val > 0) {
                firstPosIndx = i;
                break;
            }
        }

        int pos = 0;
        if (firstPosIndx != -1) {
            pos = nums.length - firstPosIndx;
        }

        return Math.max(neg, pos);
    }

    // 0ms, Beats 100% Runtime
    public static int maximumCount(int[] nums) {

        int neg = 0;
        int pos = 0;

        for (int num : nums) {
            if (num < 0) neg++;
            if (num > 0) pos++;
        }

        return Math.max(neg, pos);
    }
}
