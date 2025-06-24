package com._1easy.arrays;

import java.util.Arrays;

/**
 * 88
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        mergeFaster(new int[]{1, 0}, 1,
                new int[]{2}, 1);

        mergeFaster(new int[]{1, 2, 3, 0, 0, 0}, 3,
                new int[]{2, 5, 6}, 3);

        mergeFaster(new int[]{1}, 1,
                new int[]{}, 0);

        mergeFaster(new int[]{0}, 0,
                new int[]{1}, 1);
    }

    // not my solution, 0ms
    public static void mergeFaster(int[] nums1, int m, int[] nums2, int n) {

        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int pMerge = m + n - 1;

        while (pointer2 >= 0) {
            if (pointer1 >= 0 && nums1[pointer1] > nums2[pointer2]) {
                nums1[pMerge--] = nums1[pointer1--];
            } else {
                nums1[pMerge--] = nums2[pointer2--];
            }
        }
    }

    // 1ms, Beats 27% Runtime (most solutions are 0ms)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int val : nums2) {
            nums1[m++] = val;
        }

        Arrays.sort(nums1);
    }
}
