package problems.array.easy;

/**
 * <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 * <b>Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * Example 4:
 * <p>
 * Input: nums = [0]
 * Output: 1
 * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 */

import java.util.Scanner;

public class MissingNumber268 {
    public static void main(String[] args) {
        MissingNumber268 missingNumber = new MissingNumber268();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println("Using Approach 0");
        System.out.println(missingNumber.missingNumberApproach0(nums));
        System.out.println("Using Approach 1");
        System.out.println(missingNumber.missingNumberApproach1(nums));
        System.out.println("Using Approach 2");
        System.out.println(missingNumber.missingNumberApproach2(nums));
        System.out.println("Using Approach 3");
        System.out.println(missingNumber.missingNumberApproach3(nums));
    }


    /**
     * Approach 1: Sum of first i+1 number and subtract it from current element
     * and maintain the difference of two.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumberApproach3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (i + 1) - nums[i] + sum;
        }
        return sum;
    }

    /**
     * Approach 1: Sum of first n natural number
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumberApproach2(int[] nums) {
        int sum = 0;
        int expectedSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            expectedSum += (i + 1);
        }
        int result = expectedSum - sum;
        return result;
    }

    /**
     * Approach 1: Using Gauss Formula with one variable,
     * keep subtracting the ith element from sum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumberApproach1(int[] nums) {
        int sum = (nums.length * (nums.length + 1) / 2);
        for (int n : nums) {
            sum = sum - n;
        }
        return sum;
    }

    /**
     * Approach 1: Using Gauss Formula with two variables
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumberApproach0(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int result = (nums.length * (nums.length + 1) / 2) - sum;
        return result;
    }

}
