package com._1easy.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * 2206
 *
 * You are given an integer array nums consisting of 2 * n integers.
 *
 * You need to divide nums into n pairs such that:
 *
 * Each element belongs to exactly one pair.
 * The elements present in a pair are equal.
 * Return true if nums can be divided into n pairs, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3,2,2,2]
 * Output: true
 * Explanation:
 * There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
 * If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
 */
public class DivideArrayIntoEqualPairs {

    // 1ms, Runtime beats 99%, Memory beats 94%
    public static boolean divideArrayFaster(int[] nums) {
        // create frequency array of size 500 (indexes 0-499)
        int[] freqArr = new int[500];

        for(int num : nums) {
            int i = num - 1;
            freqArr[i] = ++freqArr[i];
        }

        for(int num : freqArr) {
            if(num % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    // 8ms, Runtime beats 46%, Memory beats 34%
    public static boolean divideArray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            // new number, start counting
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
            // we've seen this number, increment count
                int value = map.get(num);
                map.put(num, ++value);
            }
        }

        for(int value : map.values()) {
            if(value % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
