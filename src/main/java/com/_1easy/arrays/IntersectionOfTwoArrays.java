package com._1easy.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    // 3ms, Beats 53% Runtime, Beats 14% Memory
    // Freq Array + Set solution
    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] freqArr = new int[1001];
        for (int num : nums1) {
            freqArr[num] = ++freqArr[num];
        }

        Set<Integer> intersection = new HashSet<>();

        for (int num : nums2) {
            if (freqArr[num] != 0) {
                intersection.add(num);
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
