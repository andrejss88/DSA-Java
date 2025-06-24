package com._1easy.hashtables;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032
 * Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.
 * Example 1:
 * <p>
 * Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * Output: [3,2]
 * Explanation: The values that are present in at least two arrays are:
 * - 3, in all three arrays.
 * - 2, in nums1 and nums2.
 */
public class TwoOutOfThree {

    public static void main(String[] args) {
        System.out.println(twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
    }

    // 2ms, beats 87% Runtime (second best), beats 73% Memory
    // can be faster with boolean frequency arrays
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        int[] freqArr1 = new int[101];
        int[] freqArr2 = new int[101];
        int[] freqArr3 = new int[101];

        for (int num : nums1) freqArr1[num]++;
        for (int num : nums2) freqArr2[num]++;
        for (int num : nums3) freqArr3[num]++;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < freqArr1.length; i++) {
            int val1 = freqArr1[i];
            int val2 = freqArr2[i];
            int val3 = freqArr3[i];

            boolean condition1 = val1 == 0 && val2 == 0;
            boolean condition2 = val1 == 0 && val3 == 0;
            boolean condition3 = val2 == 0 && val3 == 0;

            if (condition1 || condition2 || condition3) {
                continue;
            } else {
                list.add(i);
            }
        }

        return list;
    }

}
