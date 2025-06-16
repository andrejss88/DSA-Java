package com._1easy.arrays;

/**
 * 2016
 * Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
 * Return the maximum difference. If no such i and j exists, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [7,1,5,4]
 * Output: 4
 * Explanation:
 * The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
 * Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.
 * Example 2:
 * <p>
 * Input: nums = [9,4,3,2]
 * Output: -1
 * Explanation:
 * There is no i and j such that i < j and nums[i] < nums[j].
 */
public class MaximumDifferenceBetweenIncreasingElements {

    public static void main(String[] args) {
        System.out.println(maximumDifferenceFaster(new int[]{7,1,5,4}));
    }
    // 0ms, Beats 100%, O(n) linear
    // always move forward, keep updating the min, and if it's not a new min - update the max
    public static int maximumDifferenceFaster(int[] nums) {

        int maxDifference = 0;
        int minValue = Integer.MAX_VALUE;

        for (int currentVal : nums) {
            if (currentVal < minValue) {
                minValue = currentVal;
            } else {
                maxDifference = Math.max(maxDifference, currentVal - minValue);
            }
        }

        return maxDifference == 0 ? -1 : maxDifference;
    }

    // 5ms, slowest of all
    public static int maximumDifference(int[] nums) {

        int len = nums.length;
        int maxDifference = 0;

        for (int i = 0; i < len; i++) {
            int firstVal = nums[i];
            for(int j = i + 1; j < len; j++) {
                int secondVal = nums[j];
                if(firstVal < secondVal) {
                    maxDifference = Math.max(maxDifference, secondVal - firstVal);
                }
            }
        }

        return maxDifference == 0 ? -1 : maxDifference;
    }
}
