package com._1easy.arrays.matrix;

/**
 * 1672
 * <p>
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation:
 * 1st customer has wealth = 6
 * 2nd customer has wealth = 10
 * 3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 */
public class RichestCustomerWealth {

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{
                {1, 2, 3}, {3, 2, 1}
        }));

        System.out.println(maximumWealth(new int[][]{
                {1, 5}, {7, 3}, {3, 5}
        }));
    }

    // 0ms, Runtime Beats 100%, Memory Beats 95%
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int balance : account) {
                sum += balance;
            }
            maxWealth = Math.max(sum, maxWealth);
        }

        return maxWealth;
    }
}
