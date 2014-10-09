package array;

/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int l = prices == null ? 0 : prices.length;
        if (l <= 1) return 0;

        int buy = -1, profit = 0;
        for (int i = 0; i < l; i++) {
            if ((i == 0 || prices[i] < prices[i - 1]) && (i == l - 1 || prices[i] <= prices[i + 1])) {
                //buy at bottom point
                buy = prices[i];
            }
            if (i != 0 && prices[i] >= prices[i - 1] && (i == l - 1 || prices[i] > prices[i + 1])) {
                //sell at peak point
                profit += (buy >= 0 ? prices[i] - buy : 0);
                buy = -1;
            }
        }
        return profit;
    }
}
