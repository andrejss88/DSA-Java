package com._1easy.hashtables;

import java.util.*;

/**
 * 1636
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 * <p>
 * Return the sorted array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 */
public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));
    }

    // 5ms, Beats 93% Runtime
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int freqCompare = a.getValue().compareTo(b.getValue());  // ASC by value
            if (freqCompare != 0) return freqCompare;
            return b.getKey().compareTo(a.getKey()); // DESC by key
        });

        int[] answer = new int[nums.length];
        int insertIndex = 0;
        for (var entry : list) {
            int frequency = entry.getValue();
            int num = entry.getKey();
            int start = 1;
            while(start <= frequency) {
                answer[insertIndex] = num;
                insertIndex++;
                start++;
            }
        }
        return answer;
    }
}