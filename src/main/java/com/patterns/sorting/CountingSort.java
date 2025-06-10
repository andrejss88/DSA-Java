package com.patterns.sorting;

import java.util.Arrays;

/**
 * For sorting collections of small, non-negative ints
 * Implementation:
 * 1) Find max
 * 2) Create count/frequency array
 * 3) Run prefix sum (cumulative counts)
 * 4) Place elements into output array accordingly
 * <p>
 * O(n+k), n is num of elements, k is range of key values
 * Faster than comparison sorts O(n log n) when k is small
 * Efficient when k not much larger than n
 * NOT suitable: large value range (e.g., from -10^9 to 10^9), floating point or types without natural range
 * <p>
 * Typical use cases: sort students by grades, events by time, participants by scores
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] inputArray = {1, 4, 3, 2, 2, 1};
        int[] outputArray = countSort(inputArray);

        // [1, 1, 2, 2, 3, 4]
        System.out.println(Arrays.toString(outputArray));
    }

    public static int[] countSort(int[] inputArray) {
        int n = inputArray.length;
        int max = 0;

        // 1) Find max - 4
        for (int i = 0; i < n; i++) {
            max = Math.max(max, inputArray[i]);
        }

        // 2) Use max to create count array
        // [0, 2, 2, 1, 1] - zero 0s, two 1s, etc.
        int[] countArray = new int[max + 1];
        for (int i = 0; i < n; i++) {
            countArray[inputArray[i]]++;
        }

        // 3) Mutate count arr to prefix sum arr
        // [0, 2, 4, 5, 6]
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 4) Populate output
        int[] outputArray = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int currentValue = inputArray[i];
            int shiftedIndex = countArray[currentValue] - 1;
            outputArray[shiftedIndex] = currentValue;
            countArray[currentValue]--;
        }

        return outputArray;
    }


}
