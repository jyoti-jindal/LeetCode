package problems.array.easy;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 * <b>You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * </b>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

import java.util.Scanner;

public class BuySellStock121 {
    public static void main(String[] args) {
        BuySellStock121 buySellStock = new BuySellStock121();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(buySellStock.maxProfit(arr));
    }

    /**
     * Brute-force Approach
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfitApproach0(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    /**
     * Approach 1: One Pass (find the smallest valley with following highest peak)
     * <a href="https://www.youtube.com/watch?v=4YjEHmw1MX0">Best Time to buy and sell stocks - One Transaction Allowed</a>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int lsp = Integer.MAX_VALUE;
        int os = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsp) {
                lsp = prices[i];
            }
            if (prices[i] - lsp > os) {
                os = prices[i] - lsp;
            }
        }
        return os;
    }

    /**
     * Same as Approach 1 with MAth.max function
     *
     * @param prices
     * @return
     */
    public int maxProfitApproach2(int[] prices) {
        int bestProfit = 0;
        int n = prices.length;
        int lsp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            lsp = Math.min(lsp, prices[i]);
            bestProfit = Math.max(bestProfit, prices[i] - lsp);
        }
        return bestProfit;
    }

    /**
     * Using PrefixMin and PostMax
     * TC: O(N)
     * SC: O(N)
     *
     * @param prices
     * @return
     */
    public int maxProfitApproach3(int[] prices) {
        int bestProfit = 0;
        int n = prices.length;
        int maxPrice[] = new int[n];
        maxPrice[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice[i] = Math.max(maxPrice[i + 1], prices[i]);
        }
        int minPrice[] = new int[n];
        minPrice[0] = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice[i] = Math.min(minPrice[i - 1], prices[i]);
        }

        for (int i = 0; i < n; i++) {
            bestProfit = Math.max(maxPrice[i] - minPrice[i], bestProfit);
        }
        return bestProfit;
    }
}
