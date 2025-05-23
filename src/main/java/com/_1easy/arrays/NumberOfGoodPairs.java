package com._1easy.arrays;

/**
 * 1512
 * Given an array of integers nums, return the number of good pairs.
 * <p>
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
public class NumberOfGoodPairs {

    public static void main(String[] args) {
        int result = numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
        System.out.println(result); // 4

        int result2 = numIdenticalPairs(new int[]{1, 2, 3});
        System.out.println(result2); // 0
    }

    // 1ms, beats 88%, memory beats only 9%, surprisingly, though I don't create any extra objects
    public static int numIdenticalPairs(int[] nums) {

        int first = 0;
        int second = 1;
        int count = 0;
        int arrEnd = nums.length - 1;

        while (second < nums.length) {
            if (nums[first] == nums[second]) {
                count++;
            }

            if (second != arrEnd) {
                second++;  // advance 2nd pointer and go for another iteration
            } else {
                first++;
                second = first + 1;  // (reset second to be always ahead of first)
            }
        }
        return count;
    }
}
