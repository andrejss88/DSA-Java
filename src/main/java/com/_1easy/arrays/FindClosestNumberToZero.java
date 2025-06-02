package com._1easy.arrays;

/**
 * 2239
 * Given an integer array nums of size n, return the number with the value closest to 0 in nums.
 * If there are multiple answers, return the number with the largest value.
 * <p>
 * Input: nums = [2,-1,1]
 * Output: 1
 * Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 */
public class FindClosestNumberToZero {

    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{2, -1, 1}));  // 1
        System.out.println(findClosestNumber(new int[]{-100, -100})); // -100

        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
    }

    // 2ms, 2nd best solution, Beats Runtime 88%
    public static int findClosestNumber(int[] nums) {

        int closestToZero = Integer.MAX_VALUE;
        for (int num : nums) {
            int distance = Math.abs(num);
            int closestDistance = Math.abs(closestToZero);

            if (distance < closestDistance) {
                closestToZero = num;
            }

            if (num == closestDistance) {
                closestToZero = num;
            }
        }
        return closestToZero;
    }
}
