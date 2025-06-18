package com._1easy.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 3194
 * You have an array of floating point numbers averages which is initially empty. You are given an array nums of n integers where n is even.
 * You repeat the following procedure n / 2 times:
 * Remove the smallest element, minElement, and the largest element maxElement, from nums.
 * Add (minElement + maxElement) / 2 to averages.
 * Return the minimum element in averages.
 * Example 1:
 * <p>
 * Input: nums = [7,8,3,4,15,13,4,1]
 * <p>
 * Output: 5.5
 */
public class MinimumAverageOfSmallestAndLargestElements {

    public static void main(String[] args) {
        System.out.println(minimumAverageFaster(new int[]{4, 7, 5, 5}));
        System.out.println(minimumAverageFaster(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
    }

    // 1ms, Beats 100%, O(n)
    public static double minimumAverageFaster(int[] nums) {

        int[] freqArray = new int[51];
        for (int num : nums) {
            freqArray[num]++;
        }

        int leftIndex = 0;
        int rightIndex = freqArray.length - 1;
        double smallestAverage = 10_000;

        while (leftIndex <= rightIndex) {

            int leftVal = freqArray[leftIndex];
            int rightVal = freqArray[rightIndex];

            // 0 and 0
            if (leftVal == 0 && rightVal == 0) {
                leftIndex++;
                rightIndex--;
                // 0 and 1+
            } else if (leftVal == 0) {
                leftIndex++;
                // 1+ and 0
            } else if (rightVal == 0) {
                rightIndex--;
                // edge case when indexes meet and the value is 2+
            } else if (leftIndex == rightIndex) {
                double avg = (leftIndex + rightIndex) / 2.0;
                smallestAverage = Math.min(smallestAverage, avg);
                freqArray[leftIndex] -= 2;
                // 1+ and 1+
            } else {
                double avg = (leftIndex + rightIndex) / 2.0;
                smallestAverage = Math.min(smallestAverage, avg);
                freqArray[leftIndex]--;
                freqArray[rightIndex]--;
            }
        }

        return smallestAverage;
    }

    // 2ms, Beats 98%
    // top solution largely thanks to the fact that the constraint is TINY (arr length 50)
    public static double minimumAverageWithSort(int[] nums) {

        Arrays.sort(nums);

        int leftIndx = 0;
        int rightIndx = nums.length - 1;
        double smallestAverage = 10_000;

        while (leftIndx < rightIndx) {
            int leftVal = nums[leftIndx];
            int rightVal = nums[rightIndx];

            double avg = (leftVal + rightVal) / 2.0;
            smallestAverage = Math.min(smallestAverage, avg);

            leftIndx++;
            rightIndx--;
        }

        return smallestAverage;
    }


    // 4ms, beats 14%
    public static double minimumAverage(int[] nums) {

        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        Integer min = 51;
        Integer max = 0;
        double smallestAverage = 10_000;

        while (!list.isEmpty()) {
            for (Integer num : list) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            list.remove(min);
            list.remove(max);
            double avg = (double) (min + max) / 2;
            smallestAverage = Math.min(smallestAverage, avg);

            // reset values
            min = 51;
            max = 0;
        }

        return smallestAverage;
    }
}
