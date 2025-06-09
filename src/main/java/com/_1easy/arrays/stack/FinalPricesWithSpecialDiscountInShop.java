package com._1easy.arrays.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1475
 * <p>
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i].
 * Otherwise, you will not receive any discount at all.
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 */
public class FinalPricesWithSpecialDiscountInShop {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPricesFaster(new int[]{8, 4, 6, 2, 3})));  // [4, 2, 4, 2, 3]
        System.out.println(Arrays.toString(finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(finalPrices(new int[]{10, 1, 1, 6})));
    }

    // not my solution
    // Using "Monotonic decreasing stack pattern"
    public static int[] finalPricesFaster(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and current price is less than or equal to the price at stack's top index
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();  // get the latest (previously iterated over) index of a bigger number
                result[index] = prices[index] - prices[i];  // at the older index - overwrite with discount
            }
            stack.push(i);  // populate the stack with indexes, it will be used in the while() above soon enough
            result[i] = prices[i]; // default price in case no discount is found, this will be overwritten in while() above too
        }

        return result;
    }


    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int currentPrice = prices[i];
            boolean foundDiscount = false;

            for (int j = i + 1; j < len; j++) {
                int nextPrice = prices[j];

                if (nextPrice <= currentPrice) {
                    answer[i] = currentPrice - nextPrice;
                    foundDiscount = true;
                    break;
                }
            }
            if (!foundDiscount) {
                answer[i] = currentPrice;
            }
        }

        return answer;
    }
}
