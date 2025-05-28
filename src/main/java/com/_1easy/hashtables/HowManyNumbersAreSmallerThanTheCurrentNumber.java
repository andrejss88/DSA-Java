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
