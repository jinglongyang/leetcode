package array;

/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p/>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int l = prices == null ? 0 : prices.length;
        if (l <= 1) return 0;
        int[] left = new int[l];
        int[] right = new int[l];
        buildMaxProfit(prices, l, left, right);
        int profit = 0;
        for (int i = 0; i < l; i++) {
            profit = Math.max(left[i] + right[i], profit);
        }
        return profit;
    }

    private void buildMaxProfit(int[] prices, int l, int[] left, int[] right) {
        int min = prices[0];
        for (int i = 1; i < l; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
    }
}
