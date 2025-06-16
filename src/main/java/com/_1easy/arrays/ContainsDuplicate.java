package com._1easy.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * All elements are distinct.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate2(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate2(new int[]{1, 2, 3, 4}));
    }

    // 10ms, Beats 92% Runtime, Memory 21%
    // O(n)
    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    // 20ms, Beats 29% Runtime, Memory 99%
    // O(nlogn)
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for (int first = 0, second = 1; second < nums.length; first++, second++) {
            if (nums[first] == nums[second]) return true;
        }
        return false;
    }

    // should be correct, but LeetCode says "Memory Limit Exceeded"
    public static boolean containsDuplicate(int[] nums) {

        int[] freqArray = new int[1_000_000_000];
        for (int num : nums) {
            freqArray[num]++;
            if (freqArray[num] > 1) return true;
        }
        return false;
    }
}
