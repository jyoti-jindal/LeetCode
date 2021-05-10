/**
 * <a href="https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/">Find N Unique Integers Sum up to Zero</a>
 * <b>Given an integer n, return any array containing n unique integers such that they add up to 0.</b>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */

import java.util.Scanner;

public class SumZero1304 {
    public static void main(String[] args) {
        SumZero1304 sumZero = new SumZero1304();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] output = sumZero.sumZero(n);
        for (int o : output) {
            System.out.print(o + " ");
        }
    }

    /**
     * Approach: Put values symmetric. (+x , -x). in array.
     * Time Complexity: O(n/2)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] num = new int[n];
        //int x = 1;
        for (int i = 0; i < n / 2; i++) {
            num[i] = (i + 1);
            num[n - 1 - i] = -(i + 1);
            // x++;
        }
        return num;
    }
}
