package com._1easy.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {

    public static void main(String[] args) {
        System.out.println(findFinalValueFastest(new int[]{1000}, 1000));
        System.out.println(findFinalValueFastest(new int[]{1, 16, 13, 19, 12, 10}, 2));  // 2
        System.out.println(findFinalValueFastest(new int[]{2}, 2));
        System.out.println(findFinalValueFastest(new int[]{2, 7, 9}, 4));
        System.out.println(findFinalValueFastest(new int[]{5, 3, 6, 1, 12}, 3));
    }

    // 1ms, Beats 95% Runtime, Beats 87% Memory
    public static int findFinalValueFastest(int[] nums, int original) {

        boolean[] freqArray = new boolean[1001];
        for (int num : nums) {
            freqArray[num] = true;
        }

        int highest = 0;
        for (int i = original; i <= 1000; i = i * 2) {
            if (freqArray[i]) {
                highest = i * 2;
            } else {
                break;
            }
        }
        return highest == 0 ? original : highest;
    }

    // still 3ms
    public static int findFinalValueFaster(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int highest = 0;
        for (int i = original; i <= 1000; i = i * 2) {
            if (set.contains(i)) {
                highest = i * 2;
            } else {
                break;
            }
        }

        return highest == 0 ? original : highest;
    }

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