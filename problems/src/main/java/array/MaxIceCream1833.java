package array;

import java.util.Arrays;

public class MaxIceCream1833 {
    public static void main(String[] args) {

    }

    /**
     * Approach 1: Sort array
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int n: costs) {
            int s = coins - n;
            if(s>=0) {
                coins-= n;
                count++;
            }
        }
        return count;
    }
}
