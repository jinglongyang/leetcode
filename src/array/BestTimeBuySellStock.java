package array;

/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int l = prices == null ? 0 : prices.length;
        if (l <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            profit = Math.max(price - min, profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeBuySellStock().maxProfit(new int[]{1, 2}));
    }
}
