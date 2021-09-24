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

    // For Solutions: https://leetcode.com/problems/power-of-three/solution/

    /**
     * This solution is problematic because we start using doubles,
     * which means we are subject to precision errors.
     * This means, we should never use == when comparing double.
     * That is because the result of Math.log10(n) / Math.log10(3) could be 5.0000001 or 4.9999999.
     * This effect can be observed by using the function Math.log() instead of Math.log10().
     * <p>
     * TC: Unknown The expensive operation here is Math.log, which upper bounds the time complexity of our algorithm.
     * The implementation is dependent on the language we are using and the compiler [3]
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThreeApproach1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
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

    /**
     * Time complexity : O(log(n) base 3).
     * Space complexity : O(1)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThreeApproach4(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    /**
     * See Approach 4: Integer Limitations on https://leetcode.com/problems/power-of-three/solution/
     * Time complexity : O(1)O(1). We are only doing one operation.
     * Space complexity : O(1)O(1). We are not using any additional memory.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
