package com._1easy.arrays.matrix;

/**
 * 1351
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 */
public class CountNegativeNumbersInSortedMatrix {

    // [
    // [4, 3, 2,-1],
    // [3, 2, 1,-1],
    // [1, 1,-1,-2],
    // [-1,-1,-2,-3]
    // ]

    public static int countNegativesFaster(int[][] grid) {

        int count = 0;

        // loop over ever row

        // use binary to search for -1
        // implement logic that is reverse of classic binary search
        // if -1 is found - add to count from index of -1 to end of arr
        // if -1 is NOT found - then ?? - loop forward until I find first negative num, and add to count from there to end of arr


        return count;
    }

    // 1ms, simple Brute Force, Beats runtime 50%
    public static int countNegatives(int[][] grid) {

        int count = 0;

        for (int[] row : grid) {
            for (int num : row) {
                if (num < 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
