package problems.array;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 * Explanation: The array represents the integer 0.
 * Incrementing by one gives 0 + 1 = 1.
 * Thus, the result should be [1].
 * Example 4:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class PlusOne66 {
    public static void main(String[] args) {
        PlusOne66 plusOne = new PlusOne66();
        int digits[] = {9, 9};
        System.out.println("Using Approach 1");
        int[] result = plusOne.plusOneApproach1(digits);
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
        result = plusOne.plusOneApproach2(digits);
        System.out.println("Using Approach 2");
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param digits
     * @return
     */
    public int[] plusOneApproach1(int[] digits) {
        int n = digits.length;
        int d = digits[n - 1];
        int outputArray[] = new int[n + 1];
        int num = 0;
        if (d == 9) {
            for (int i = 0; i < n; i++) {
                num = num * 10 + digits[i];
            }
            num = num + 1;
            int i = n;
            while (num > 0 && i >= 0) {
                outputArray[i--] = num % 10;
                num = num / 10;
            }
        } else {
            digits[n - 1] = digits[n - 1] + 1;
            outputArray = digits;
        }
        return outputArray;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param digits
     * @return
     */
    public int[] plusOneApproach2(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int b[] = new int[n + 1];
            b[0] = carry;
            for (int i = 1; i < n + 1; i++) {
                b[i] = digits[i - 1];
            }
            return b;
        }
        return digits;
    }
}
