package com._1easy.arrays;

import java.util.Arrays;

/**
 * 2006
 * Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
 * <p>
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 * Explanation: The pairs with an absolute difference of 1 are:
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {


    public static void main(String[] args) {

        System.out.println(countKDifference(new int[]{37, 29, 41, 44, 77, 64, 41, 21, 67, 74, 22, 60, 12, 10, 32, 92, 7, 10, 55, 37, 35, 65, 6, 97, 79, 48, 37, 73, 73, 85, 60, 34, 53, 68, 96, 44, 67, 45, 96, 96, 58, 61, 34, 35, 54, 15, 58, 22, 93, 31}, 60));  // 6

        System.out.println(countKDifference(new int[]{10, 2, 10, 9, 1, 6, 8, 9, 2, 8}, 5));  // 1
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));  // 4
        System.out.println(countKDifference(new int[]{1, 3}, 3));  // 0
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));  // 3
    }

    // 7ms, beats runtime 55%
    public static int countKDifference(int[] nums, int k) {

        Arrays.sort(nums);

        int count = 0;
        int firstIndx = 0;
        int secondIndx = 1;

        while (secondIndx <= nums.length) {

            // second index reached end of arr, time to reset
            if (secondIndx == nums.length) {
                firstIndx++;
                secondIndx = firstIndx + 1;
                continue;
            }

            int firstVal = nums[firstIndx];
            int secondVal = nums[secondIndx];

            // we went beyond K, no need to keep going until end of array, time to reset the sliding window
            if (secondVal - firstVal > k) {
                firstIndx++;
                secondIndx = firstIndx + 1;
                continue; // no need to keep iterating
            }

            if (secondVal - firstVal == k) {  // found a pair
                count++;
                secondIndx++; // extend sliding window, keep comparing first val with next
            } else if (secondVal - firstVal < k) {
                secondIndx++;  // no pair, but keep extending window until end of arr or distance between 1st and 2nd pointers is < K
            }
        }
        return count;
    }
}
