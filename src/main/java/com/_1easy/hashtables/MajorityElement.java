package com._1easy.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));

        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }

    // 13ms, Beats Runtime 29%, LeetCode AI says Time Comp O(n)
    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
        }

        int majority = nums.length / 2;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > majority) return entry.getKey();
        }

        return -1;
    }
}
