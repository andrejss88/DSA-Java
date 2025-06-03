package com._1easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2089
 * <p>
 * You are given a 0-indexed integer array nums and a target element target.
 * A target index is an index i such that nums[i] == target.
 * Return a list of the target indices of nums after sorting nums in non-decreasing order.
 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,5,2,3], target = 2
 * Output: [1,2]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The indices where nums[i] == 2 are 1 and 2.
 */
public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {

        System.out.println(targetIndicesFastest(new int[]{1, 2, 5, 2, 3}, 2));  // [1,2,3,4]
    }

    // NOT my solution - too tricky :/
    public static List<Integer> targetIndicesFastest(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int last = 0, freq = 0;

        // Count the frequency of target and count numbers less than target.
        for (int i : nums) {
            if (i == target) freq++;
            if (i < target) last++;
        }

        // Add the indices where target would appear in a sorted array.
        for (int i = 0; i < freq; i++) {
            ans.add(last++);
        }

        return ans;
    }

    // 2ms again, No difference when binary search is used, most likely due to tiny constraints again
    // 1 <= nums[i], target <= 100
    public static List<Integer> targetIndices2(int[] nums, int target) {

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        // can't use native Binary Search because of duplicate values
        int left = 0;
        int right = nums.length - 1;
        int foundIndex = -1;

        while (left <= right) {
            int midIndex = (left + right) / 2;
            int midValue = nums[midIndex];

            if (midValue == target) {
                foundIndex = midIndex;
            }

            if (midValue > target) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }

        // now loop backwards to find duplicates
        int actualStartIndex = 0;
        for (int i = foundIndex - 1; i >= 0; i--) {
            int value = nums[i];
            if (value == target) {
                actualStartIndex = i;
            } else {
                break;
            }
        }

        // now start from the 1st occurrence of target
        for (int i = actualStartIndex; i < nums.length; i++) {
            int value = nums[i];
            if (value == target) {
                list.add(i);
            } else if (value > target) {
                break;
            }
        }
        return list;
    }

    // 2ms, Beats Runtime 81%
    public static List<Integer> targetIndices(int[] nums, int target) {

        // [1,2,5,2,3]

        // [1,2,2,3,5]
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value == target) {
                list.add(i);
            } else if (value > target) {
                break;
            }
        }

        return list;
    }
}
