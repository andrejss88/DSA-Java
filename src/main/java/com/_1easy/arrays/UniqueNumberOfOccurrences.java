package com._1easy.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 1207
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 */
public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences2(new int[]{1, 2, 2, 1, 1, 3}));
    }

    // still 2ms :)
    public static boolean uniqueOccurrences2(int[] arr) {

        int offset = 1000;
        int[] freqArray = new int[2001];
        for (int num : arr) {
            freqArray[num + offset]++;
        }

        // given input arr [1,2,2,1,1,3]
        // we now have     [0,3,2,1] (no zeroes, three 1s, two 2s, one 3)
        // now create "frequencies of frequencies" - if find a frequency > 1, then we have duplicate frequencies
        int[] secondFreqArray = new int[2001];
        for (int num : freqArray) {
            secondFreqArray[num]++;
            if (num != 0 && secondFreqArray[num] > 1) return false;
        }
        return true;
    }

    // 2ms, Beats 98% runtime, O(n)
    public static boolean uniqueOccurrences(int[] arr) {

        int offset = 1000;
        int[] freqArray = new int[2001];
        for (int num : arr) {
            freqArray[num + offset]++;
        }

        // given input arr [1,2,2,1,1,3]
        // we now have     [0,3,2,1] (no zeroes, three 1s, two 2s, one 3)
        // now add into a set - if addition fails at any point - we have a duplicate
        Set<Integer> uniques = new HashSet<>();
        for (int num : freqArray) {
            if (num != 0 && !uniques.add(num)) return false;
        }

        return true;
    }
}
