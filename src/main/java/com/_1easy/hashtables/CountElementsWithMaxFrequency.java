package com._1easy.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * 3005
 * You are given an array nums consisting of positive integers.
 *
 * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
 * The frequency of an element is the number of occurrences of that element in the array.
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1,4]
 * Output: 4
 * Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
 * So the number of elements in the array with maximum frequency is 4.
 */
public class CountElementsWithMaxFrequency {

    // 1ms, Beats 99%
    public static int maxFrequencyElementsFaster(int[] nums) {

        int[] freqArray = new int[101];
        int max = 0;

        for(int num : nums) {
            freqArray[num]++;
            max = Math.max(max, freqArray[num]);
        }

        int sum = 0;
        for (int val : freqArray) {
            if (val == max) sum += val;
        }

        return sum;
    }
    // 3ms - Beats 26%
    public static int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        int sum = 0;
        for(int frequency : map.values()) {
            if(frequency == max) {
                sum += frequency;
            }
        }

        return sum;
    }
}
