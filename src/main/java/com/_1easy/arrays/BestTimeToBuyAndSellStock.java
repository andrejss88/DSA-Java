package com._1easy.arrays;

public class BestTimeToBuyAndSellStock {

    // Not mine, much more elegant
    // 1ms, Runtime Beats 99%
    public static int maxProfitElegant(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {  // new low? Update and keep looping
                buyPrice = prices[i];
            } else {
                // not new low? then new High, we are also in the future already
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }

    // 2ms, Runtime beats 75%
    public static int maxProfit(int[] prices) {

        int lowestPrice = prices[0];  // we can buy on first day
        int maxProfit = 0;
        int mostRecentProfit;

        for (int today = 1; today < prices.length; today++) {
            int todayPrice = prices[today];

            // did the price go down?
            if (todayPrice < lowestPrice) {
                lowestPrice = todayPrice;
                continue;
            }

            // if we got this far, then the price went UP and it happened AFTER most recent low
            // so calculate the profit
            mostRecentProfit = todayPrice - lowestPrice;

            // but is it the biggest profit in the entire history?
            if (mostRecentProfit > maxProfit) {
                maxProfit = mostRecentProfit;
            }
        }
        return maxProfit;
    }
}