package com._1easy.arrays;

import java.util.Arrays;

/**
 * 136
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumberSort(new int[]{2, 2, 1}));  // 1
        System.out.println(singleNumberSort(new int[]{4, 1, 2, 1, 2}));  // 4
    }

    // NOT my solution - Bit Manipulation
    public static int singleNumberLinearAndConstantSpace(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    // 3ms, but WITH extra space - breaks problem condition
    // did just for fun - much faster than with Map<>
    public static int singleNumber(int[] nums) {

        int offset = 30_000;
        int[] freqArray = new int[60_001];

        for (int num : nums) {
            freqArray[num + offset]++;
        }

        int singleNum = 0;
        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] == 1) {
                singleNum = i;
                break;
            }
        }
        return singleNum - offset;
    }

    // 7ms, Beats 30% - Two Pointers solution
    // constant space, but NOT LINEAR - O(n logn)
    public static int singleNumberSort(int[] nums) {

        Arrays.sort(nums);

        int first = 0;
        int second = 1;

        while (second < nums.length) {

            int firstVal = nums[first];
            int secondVal = nums[second];

            // simple scenario 1,1,2,2,4
            if (firstVal == secondVal) {
                first += 2;
                second += 2;
            } else {
                // scenario 1,2,2
                // get third (i+2) - return whichever not equals to third
                int thirdVal = nums[second + 1];
                return secondVal == thirdVal ? firstVal : secondVal;
            }
        }

        // the last num is single - simple scenario 1,1,2,2,4
        return nums[nums.length - 1];
    }

}
