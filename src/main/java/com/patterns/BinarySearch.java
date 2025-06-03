package com.patterns;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] ints = new int[]{1, 2, 3, 5, 9};
        int[] ints2 = new int[]{-1, 0, 3, 5, 9, 12};

        System.out.println(Arrays.binarySearch(ints, 3));   // 2
        System.out.println(Arrays.binarySearch(ints2, 12)); // 5

        System.out.println(search(ints, 3));
        System.out.println(search(ints2, 12));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midIndex = (left + right) / 2;
            int midValue = nums[midIndex];

            if(midValue == target) return midIndex;

            if(midValue > target) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        return -1;
    }
}
