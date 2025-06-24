package com._1easy.hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [2]
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers(new int[]{1, 1}));
    }

    // 4ms, Beats 95% Runtime
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int[] freqArray = new int[nums.length + 1];
        for (int num : nums) freqArray[num]++;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < freqArray.length; i++) {
            if (freqArray[i] == 0) list.add(i);
        }
        return list;
    }

    // 19ms, Beats 33% Runtime. Added for completeness sake
    public static List<Integer> findDisappearedNumbersWithSet(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) list.add(i);
        }

        return list;
    }
}
