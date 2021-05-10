package array;

public class FinalPricesWithSpecialDiscount1475 {
    public static void main(String[] args) {
        FinalPricesWithSpecialDiscount1475 finalPricesWithSpecialDiscount = new FinalPricesWithSpecialDiscount1475();
        int[] prices = {8,4,6,2,3};
        System.out.println("Using Approach 1");
        finalPricesWithSpecialDiscount.finalPricesApproach1(prices);
        for(int i=0 ; i<prices.length; i++) {
            System.out.print(prices[i] + " ");
        }

        System.out.println();
        int[] prices1 = {8,4,6,2,3};
        System.out.println("Using Approach 2");
        finalPricesWithSpecialDiscount.finalPricesApproach2(prices1);
        for(int i=0 ; i<prices1.length; i++) {
            System.out.print(prices1[i] + " ");
        }
    }

    /**
     * Approach1: Brute-force with break statement.
     * Time Complexity: O(n^2)
     * space Complexity: O(1)
     *
     * @param prices
     * @return
     */
    public int[] finalPricesApproach1(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    /**
     * Approach 2: Brute-force with returning discount from another method.
     * @param prices
     * @return
     */
    public int[] finalPricesApproach2(int[] prices) {
        for(int i = 0; i < prices.length; i++) {
            int discount = findDiscount(prices, i);
            prices[i] = prices[i] - discount;
        }
        return prices;
    }

    private int findDiscount(final int[] prices, int i) {
        for(int j = i+1; j < prices.length; j++) {
            if(prices[j] <= prices[i]) {
                return prices[j];
            }
        }
        return 0;
    }
}
