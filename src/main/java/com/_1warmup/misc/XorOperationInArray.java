package com._1warmup.misc;

/**
 * 1486
 * You are given an integer n and an integer start.
 * Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
 * Return the bitwise XOR of all elements of nums.
 * <p>
 * <p>
 * Example:
 * Input: n = 5, start = 0
 * Output: 8
 * Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
 */
public class XorOperationInArray {

    public static void main(String[] args) {
        System.out.println("Result: " + xorOperation(5, 2));
    }

    // solution without using an array
    public static int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ (start + 2 * i);
            System.out.println(result);
        }
        return result;
    }
}
