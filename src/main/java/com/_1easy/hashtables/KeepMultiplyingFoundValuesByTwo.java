package com._1easy.hashtables;

import java.util.Arrays;

public class KeepMultiplyingFoundValuesByTwo {

    // TODO - find faster solution

    // 3ms - Runtime beats 66%
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int val : nums) {
            if (val == original) {
                original = original * 2;
            }
        }
        return original;
    }
}
