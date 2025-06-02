package com._1easy.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 268
 */
public class MissingNumber {

    public static void main(String[] args) {

        System.out.println(missingNumberFaster(new int[]{3, 0, 1}));  // 2

//        System.out.println(missingNumberFaster(new int[]{0, 1}));  // 2
    }


    // NOT my solution
    // 2ms, Beats 27%, O(n)
    public static int missingNumberFaster(int[] nums) {

        int n = nums.length;
        int sumWithoutMissingNum = (n * (n + 1)) / 2; // Math formula for sum of N natural numbers
        int actualSum = Arrays.stream(nums).sum();
        return sumWithoutMissingNum - actualSum;
    }

    // 8ms, Runtime beats 5%, SLOWEST
    public static int missingNumberSlower(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }

        for (int num : nums) {
            set.remove(num);
        }
        return set.stream().toList().get(0);
    }

    // 5ms, Runtime beats 25%, sorting is O(n log n)
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums[nums.length - 1] + 1;
    }
}
