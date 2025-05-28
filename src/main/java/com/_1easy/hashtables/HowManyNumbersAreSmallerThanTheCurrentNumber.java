package com._1easy.hashtables;

import java.util.Arrays;

/**
 * 1365
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.
 * Example 1:
 * <p>
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    // NOT my solution - uses Prefix Sum
    // 1ms, Runtime beats 99%, Memory Beats 95%
    public static int[] smallerNumbersThanCurrent4(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        // Given [8, 1, 2, 2, 3], we now have a frequency array
        // [0,1,2,1,0,0,0,0,1,...], i.e. zero 0s, one 1, two 2's, one 3, one 8

        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];
        }

        // Given [0,1,2,1,0,0,0,0,1,...], we now have an array like this
        // [0, 1, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, ...]
        // that tells us "how many numbers are <= i ?
        // count[1] = 1 element that is  <= 1 (1)
        // count[2] = 3 elements that are <=2 (1,2,2)
        // count[3] = 4 elements that are <= 3 (1,2,2,3)
        // count[4] = 5 elements that are <= 4 (1,2,2,3,8)
        // all other are 5s, because (1,2,2,3,8) are less than 9, 10, 11, etc.

        // Given [8, 1, 2, 2, 3]
        // Given 8
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                // get count of all numbers less than nums[i]
                res[i] = count[nums[i] - 1];  // nums[i] is 8, then count[7] is 4
        }

        return res;
    }

    // NOT my solution
    // 5ms, Runtime beats 83%, Runtime beats 24%
    public static int[] smallerNumbersThanCurrent3(int[] nums) {

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] ans = new int[sorted.length];

        int ansIndx = 0;
        // [8, 1, 2, 2, 3]
        // [1, 2 ,2, 3, 8]
        // how many iterations (j) to find "8" in sorted array? -> 5, but since we started at 0, the ans is 4
        // therefore "8" is larger than 4 other elements, insert "4" at index 0 of answer array, which is synced with unsorted array

        // how many iterations (j) to find "1" in sorted array? -> 1, but 1-1=0
        // therefore "1" is larger than 0 other elements
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted.length; j++) {
                if (nums[i] == sorted[j]) {
                    ans[ansIndx] = j;
                    ansIndx++;
                    break;
                }
            }
        }
        return ans;
    }

    // Very minor improvement - find min
    // 10ms, Runtime beats 21%, Memory beats 57%
    // Trying to save Max results too much extra effort resulting in 13ms
    public static int[] smallerNumbersThanCurrent2(int[] nums) {

        int min = 101; // constraint: num <= 100
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];

            // finish iteration early for min values
            if (currentVal == min) {
                out[i] = 0;
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                // don't compare the same num in same position to itself
                if (i == j) continue;

                if (currentVal > nums[j]) {
                    out[i] = out[i] + 1;
                }
            }
        }

        return out;
    }

    // Brute force O(n^2)
    // 11ms, Runtime beats 8%, Memory beats 40%
    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] out = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];

            for (int j = 0; j < nums.length; j++) {
                // don't compare the same num in same position to itself
                if (i == j) continue;

                if (currentVal > nums[j]) {
                    out[i] = out[i] + 1;
                }
            }
        }

        return out;
    }
}
