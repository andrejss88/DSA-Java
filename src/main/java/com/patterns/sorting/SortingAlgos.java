package com.patterns.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortingAlgos {

    public static void main(String[] args) {

        int[] input = new int[]{5, 8, 9, 1, 2};
        int[] result = selectionSort(input);

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(result));

    }

    // O(n^2)
    // to produce a NEW array without modifying
    // int[] sorted = nums.clone(); -> then do everything the same on the cloned one
    public static int[] selectionSort(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in the remaining array
            for (int j = i + 1; j < len; j++) {
                // nums[minIdex], NOT! nums[i]
                // to continuously compare with the smallest found in this second loop
                // NOT the num of the outer loop
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the current element with the found minimum element
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

// Given    [5,8,9,1,2]
// assume 5 (current element at start of loop) is smallest, remember its index
// loop until 1 (smallest) - remember its index
// finish at 2 - it's smaller than 5, but NOT smaller than 1, that's why we must continuously update "smallest index" and compare newer numbers to it

// ouside of inner loop - we can now swap whatever num with smallest
// using temp var - place smallest into left-most position, whatever i allows
// place the other value to the right
//            |
//            |
//            [1,8,9,5,2]

}
