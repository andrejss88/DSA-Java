package com._1easy.arrays;

import java.util.Arrays;

/**
 * 1051
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
 * Return the number of indices where heights[i] != expected[i].
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 * Example 2:
 * <p>
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Explanation:
 * heights:  [5,1,2,3,4]
 * expected: [1,2,3,4,5]
 * All indices do not match.
 */
public class HeightChecker {

    public static void main(String[] args) {
        System.out.println(heightCheckerFaster(new int[]{1, 3, 3, 3, 2, 2}));
    }

    // See class CountingSort
    // 1ms, Beats Runtime 93%
    public static int heightCheckerFaster(int[] heights) {

        // find max
        int max = 0;
        for (int height : heights) {
            max = Math.max(height, max);
        }

        // create freq array
        int[] freqArr = new int[max + 1];
        for (int num : heights) {
            freqArr[num]++;
        }
        // [0,1,2,3] -> [0,1,3,6]
        // mutate freq array to prefix sum
        for (int i = 1; i < freqArr.length; i++) {
            freqArr[i] = freqArr[i - 1] + freqArr[i];
        }

        // populate output array
        int[] output = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int currentValue = heights[i];
            int shiftedIndex = freqArr[currentValue] - 1;
            output[shiftedIndex] = currentValue;
            freqArr[currentValue]--;
        }

        // loop over heights and output
        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (output[i] != heights[i]) count++;
        }

        return count;
    }


    // simplest - 2ms, beats 88%
    public int heightChecker(int[] heights) {

        int[] clone = heights.clone();
        Arrays.sort(clone);

        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (clone[i] != heights[i]) count++;
        }

        return count;
    }
}
