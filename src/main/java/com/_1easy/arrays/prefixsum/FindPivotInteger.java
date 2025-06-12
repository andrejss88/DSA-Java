package com._1easy.arrays.prefixsum;

/**
 * 2485
 * Given a positive integer n, find the pivot integer x such that:
 * <p>
 * The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
 * Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 8
 * Output: 6
 * Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
 */
public class FindPivotInteger {

    public static void main(String[] args) {
        System.out.println(pivotIntegerFastestMath(8));
    }

    // NOT my solution - Math trick
    public static int pivotIntegerFastestMath(int n) {
        int ans = (n * n + n) / 2;
        int sq = (int) Math.sqrt(ans);
        if (sq * sq == ans) {
            return sq;
        } else {
            return -1;
        }
    }

    // 2ms still :/
    public static int pivotIntegerFasterShorter(int n) {

        // Given n
        // 1) Build arr and fromLeftSum in 1 loop :   [1,2, 3, 4,  5,  6,  7,  8]
        //                prefix sum left-right  >:   [1,3, 6, 10, 15, 21, 28, 36]
        // 2) Build       prefix sum right-left  >:   [8, 15, 21, 26, 30, 33, 35, 36]
        // AND check for common num at the same time
        // ->  find common num (21) -> get its index offset by 1
        if (n == 1) return 1;

        int[] arr = new int[n];
        int[] fromLeftSum = new int[n];
        int[] fromRightSum = new int[n];
        int lastIndx = n - 1;

        arr[0] = 1;
        fromLeftSum[0] = 1;
        // construct initial arr and leftToRight in a single loop
        // thus save one iteration
        for (int i = 1; i < n; i++) {
            arr[i] = i + 1;
            fromLeftSum[i] = fromLeftSum[i - 1] + arr[i];
        }

        fromRightSum[0] = arr[lastIndx];

        for (int sumIndx = 1, arrIndx = lastIndx - 1; sumIndx < n; sumIndx++, arrIndx--) {
            fromRightSum[sumIndx] = fromRightSum[sumIndx - 1] + arr[arrIndx];
            int valOne = fromRightSum[sumIndx];
            int valTwo = fromLeftSum[arrIndx];
            if (valOne == valTwo) return arrIndx + 1;
        }

        return -1;
    }

    // 2ms, Beats 26%
    public static int pivotIntegerFaster(int n) {

        int[] arr = new int[n];
        int[] fromLeftSum = new int[n];
        int[] fromRightSum = new int[n];
        int lastIndx = n - 1;

        arr[0] = 1;
        fromLeftSum[0] = 1;
        // construct initial arr and leftToRight in a single loop
        // thus save one iteration
        for (int i = 1; i < n; i++) {
            arr[i] = i + 1;
            fromLeftSum[i] = fromLeftSum[i - 1] + arr[i];
        }

        fromRightSum[0] = arr[lastIndx];
        for (int sumIndx = 1, arrIndx = lastIndx - 1; sumIndx < n; sumIndx++, arrIndx--) {
            fromRightSum[sumIndx] = fromRightSum[sumIndx - 1] + arr[arrIndx];
        }

        for (int leftIndx = lastIndx, rightIndx = 0; rightIndx < n; leftIndx--, rightIndx++) {
            int leftVal = fromLeftSum[leftIndx];
            int rightVal = fromRightSum[rightIndx];

            if (leftVal == rightVal) return leftIndx + 1;
        }

        return -1;
    }

    // 3ms, Beats 17%
    public static int pivotInteger(int n) {
        // given input             :   [1,2,3, 4, 5, 6, 7, 8]

        // prefix sum left-right  >:   [1, 3,  6,  10, 15, 21, 28, 36]
        // prefix sum right-left  >:   [8, 15, 21, 26, 30, 33, 35, 36]

        // loop fromLeftSum from end, fromRightSum from start and find common num (21) -> get its index offset by 1
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] fromLeftSum = new int[n];
        int[] fromRightSum = new int[n];
        int lastIndx = n - 1;

        fromLeftSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            fromLeftSum[i] = fromLeftSum[i - 1] + arr[i];
        }

        fromRightSum[0] = arr[lastIndx];
        for (int sumIndx = 1, arrIndx = lastIndx - 1; sumIndx < n; sumIndx++, arrIndx--) {
            fromRightSum[sumIndx] = fromRightSum[sumIndx - 1] + arr[arrIndx];
        }

        for (int leftIndx = lastIndx, rightIndx = 0; rightIndx < n; leftIndx--, rightIndx++) {
            int leftVal = fromLeftSum[leftIndx];
            int rightVal = fromRightSum[rightIndx];

            if (leftVal == rightVal) return leftIndx + 1;
        }

        return -1;
    }
}
