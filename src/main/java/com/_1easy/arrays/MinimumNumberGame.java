package com._1easy.arrays;

import java.util.Arrays;

public class MinimumNumberGame {


    // 2ms, Beats 98%
    public static int[] numberGame(int[] nums) {

        Arrays.sort(nums);
        int[] result = new int[nums.length];

        for (int first = 0, second = 1; second < nums.length; first += 2, second += 2) {
            result[first] = nums[second];
            result[second] = nums[first];
        }

        return result;
    }
}
