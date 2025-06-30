package com._1easy.arrays.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1646
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * Example 2:
 * <p>
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 */
public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        System.out.println(maxProductWithTree(new int[]{1, 5, 4, 5}));
        System.out.println(maxProductWithTree(new int[]{3, 4, 5, 2}));
    }

    // 3ms, Beats 28%
    public static int maxProductWithTree(int[] nums) {
        // min-heap by default, pass in reverse order to change to max-heap
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            q.add(num);
        }

        return (q.poll() - 1) * (q.poll() - 1);
    }

    // not my solution, simple one-pass O(n)
    public int maxProductFastest(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    // 1ms, Beats 62% (2nd fastest)
    public static int maxProduct(int[] nums) {

        int len = 1001;
        int startIndex = 0;
        int[] freqArr = new int[len];
        for (int num : nums) {
            freqArr[num]++;
            startIndex = Math.max(startIndex, num);
        }

        int largest = 0;
        int secondLargest = 0;
        boolean largestNotFound = true;
        while (startIndex > 0) {
            int val = freqArr[startIndex];
            if (val == 0) {
                startIndex--;
                continue;
            }

            if (largestNotFound) {
                largest = startIndex;
                freqArr[startIndex]--;
                largestNotFound = false;
            } else {
                secondLargest = startIndex;
                break;
            }
        }
        return (largest - 1) * (secondLargest - 1);
    }
}
