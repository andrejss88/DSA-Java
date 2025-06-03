package com._1easy.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 2824
 * Given a 0-indexed integer array nums of length n and an integer target, return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,1,2,3,1], target = 2
 * Output: 3
 * Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
 * - (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
 * - (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target
 * - (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
 * Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
 */
public class CountPairsWhoseSumIsLessThanTarget {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>(List.of(-1, 1, 2, 3, 1));
        List<Integer> list2 = new ArrayList<>(List.of(-6, 2, 5, -2, -7, -1, 3));
        List<Integer> list3 = new ArrayList<>(List.of(6, -1, 7, 4, 2, 3));
        List<Integer> list4 = new ArrayList<>(List.of(9, -5, -5, 5, -5, -4, -6, 6, -6));

        System.out.println(countPairsFaster(list4, 3));  // 27, not 25
        System.out.println(countPairsFaster(list3, 8)); // 8
        System.out.println(countPairsFaster(list1, 2));  // 3
        System.out.println(countPairsFaster(list2, -2));  // 10

    }

    // 3ms? Beats Runtime 44%
    // most likely due to tiny constraints
    // Current constraints → Brute-force wins
    // If n ≥ ~1,000+ → Two-pointer starts to win
    public static int countPairsFaster(List<Integer> nums, int target) {

        nums.sort(Integer::compareTo);
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                // all elements between left and right form valid pairs
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    // 2ms, Beats Runtime 96%,
    public static int countPairs(List<Integer> nums, int target) {

        int count = 0;
        int first = 0;
        int second = 1;
        int len = nums.size();

        while (second < len) {

            if (nums.get(first) + nums.get(second) < target) {
                count++;
            }

            // either reset sliding window...
            if (second == len - 1) {
                first++;
                second = first + 1;
            } else {
                second++;  // or extend its right edge
            }
        }
        return count;
    }
}
