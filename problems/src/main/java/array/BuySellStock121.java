package array;

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
}
