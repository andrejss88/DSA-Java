package com._1easy.hashtables;

import java.util.Arrays;

/**
 * 2956
 * You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:
 * answer1 : the number of indices i such that nums1[i] exists in nums2.
 * answer2 : the number of indices i such that nums2[i] exists in nums1.
 * Return [answer1,answer2].
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [2,3,2], nums2 = [1,2]
 * Output: [2,1]
 */

public class FindCommonElementsBetweenTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIntersectionValues(new int[]{2, 3, 2}, new int[]{1, 2})));
    }

    // 2ms, beats 98%
    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {

        int[] freqArr1 = new int[101];
        int[] freqArr2 = new int[101];

        for (int num : nums1) freqArr1[num]++;
        for (int num : nums2) freqArr2[num]++;

        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < freqArr1.length; i++) {
            int valOne = freqArr1[i];
            int valTwo = freqArr2[i];

            if (valOne != 0 && valTwo != 0) {
                answer1 += valOne;
                answer2 += valTwo;
            }
        }

        return new int[]{answer1, answer2};
    }
}
