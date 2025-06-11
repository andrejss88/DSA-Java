package com._1easy.arrays.prefixsum;

import java.util.Arrays;

/**
 * 2574
 * You are given a 0-indexed integer array nums of size n.
 * Define two arrays leftSum and rightSum where:
 * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
 * Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
 * Example 1:
 * <p>
 * Input: nums = [10,4,8,3]
 * Output: [15,1,11,22]
 * Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
 * The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
 */
public class LeftAndRightSumDifferences {
    // This is a MODIFIED Prefix Sum problem
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference(new int[]{10, 4, 8, 3})));
    }
    // Solution that populates both left and right in a single pass (still 2ms):
    // https://leetcode.com/problems/left-and-right-sum-differences/solutions/6802603/simple-solution-with-prefix-sums/

    // orig: [10,4,8,3]
    // pfx : [10,14,22,25]

    // 2ms, Beats Runtime 98%
    public static int[] leftRightDifference(int[] nums) {

        int len = nums.length;

        int[] leftSum = new int[len];
        int[] rightSum = new int[len];

        leftSum[0] = 0;
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        rightSum[len - 1] = 0;
        for (int fromEnd = len - 1; fromEnd > 0; fromEnd--) {
            rightSum[fromEnd - 1] = rightSum[fromEnd] + nums[fromEnd];
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}
