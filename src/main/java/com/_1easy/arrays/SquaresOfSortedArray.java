package com._1easy.arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {

    // 1ms - Beats Runtime 100%, came up with this myself
    public static int[] sortedSquaresFaster(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int leftIndex = 0;
        int rightIndex = len - 1;

        int outIndex = rightIndex;
        while (leftIndex <= rightIndex) {

            int leftSquared = nums[leftIndex] * nums[leftIndex];
            int rightSquared = nums[rightIndex] * nums[rightIndex];

            if (leftSquared > rightSquared) {
                output[outIndex] = leftSquared;
                leftIndex++;
            } else {
                output[outIndex] = rightSquared;
                rightIndex--;
            }
            outIndex--;
        }
        return output;
    }

    // 7ms, beats runtime 40%
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = num * num;
        }

        Arrays.sort(nums);
        return nums;
    }
}
