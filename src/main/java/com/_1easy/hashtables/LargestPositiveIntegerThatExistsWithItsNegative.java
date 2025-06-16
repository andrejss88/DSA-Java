package com._1easy.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441
 * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
 * <p>
 * Return the positive integer k. If there is no such integer, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,-3,3]
 * Output: 3
 * Explanation: 3 is the only valid k we can find in the array.
 * Example 2:
 * <p>
 * Input: nums = [-1,10,6,7,-7,1]
 * Output: 7
 * Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        System.out.println(findMaxKFaster(new int[]{-12, -11, -9, -2, 2, 10}));
    }

    // 2ms, Beats 98%
    public static int findMaxKFaster(int[] nums) {

        int offset = 1000;  // place -1000 at index 0
        boolean[] freqArray = new boolean[2001];

        for (int num : nums) {
            freqArray[num + offset] = true;
        }

        int leftIndex = 0;
        int rightIndex = freqArray.length - 1;

        while (leftIndex < rightIndex) {
            boolean leftVal = freqArray[leftIndex];
            boolean rightVal = freqArray[rightIndex];

            if (leftVal && rightVal) return rightIndex - offset;

            leftIndex++;
            rightIndex--;
        }

        return -1;
    }

    // 5ms, Beats 84%
    public int findMaxK(int[] nums) {

        Set<Integer> negatives = new HashSet<>();
        Set<Integer> positives = new HashSet<>();

        for (int num : nums) {
            if (num < 0) {
                negatives.add(num);
            } else {
                positives.add(num);
            }
        }

        int highest = -1;
        for (int num : negatives) {
            int val = Math.abs(num);
            if (positives.contains(val)) {
                highest = Math.max(highest, val);
            }
        }

        return highest;
    }
}
