package com._1easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1394
 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
 * Return the largest lucky integer in the array. If there is no lucky integer return -1.
 * <p>
 * Example 1:
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * <p>
 * Example 2:
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 */
public class FindLuckyIntegerInArray {

    // [1,2,2,3,3,3]  -> 1,2,3 all lucky, 3 is largest
    public static void main(String[] args) {
        int result = findLuckyFaster(new int[]{1, 2, 2, 3, 3, 3});
        System.out.println(result);
    }

    // 1ms, Beats Runtime 100%
    public static int findLuckyFaster(int[] arr) {

        int[] freqArray = new int[501];
        for (int num : arr) {
            freqArray[num] = ++freqArray[num];
        }

        for (int i = freqArray.length - 1; i >= 0; i--) {
            int val = freqArray[i];
            if(val != 0 && val == i) return i;
        }

        return -1;
    }

    // 5ms, Beats Runtime 76%, Beats 85% Memory
    public int findLucky(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int largest = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (key == value) {
                largest = Math.max(largest, key);
            }
        }
        return largest == 0 ? -1 : largest;
    }
}
