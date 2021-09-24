package problems.math.easy;

/**
 * <a href="https://leetcode.com/problems/power-of-three/">Power of Three</a>
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 9
 * Output: true
 * Example 4:
 * <p>
 * Input: n = 45
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 * Accepted
 * 391,500
 * Submissions
 * 915,187
 */
public class PowerOfThree326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThreeApproach1(9));
        System.out.println(isPowerOfThreeApproach2(9));
        System.out.println(isPowerOfThreeApproach3(9));
    }

    /**
     * TC: O(1)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThreeApproach1(int n) {
        double d = Math.log(n) / Math.log(3);
        int i = (int) d;
        //System.out.println(d + " " + i + " ");
        if (i == d) return true;
        return false;
    }

    /**
     * TC: O(logN base 3)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThreeApproach2(int n) {
        int i = 0;
        while (Math.pow(3, i) <= n) {
            if (Math.pow(3, i) == n) return true;
            i++;
        }

        return false;

    }

    /**
     * TC: O(logN base 3)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThreeApproach3(int n) {
        if (n <= 0) return false;
        while (n > 0) {
            if (n != 1 && n % 3 > 0) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
