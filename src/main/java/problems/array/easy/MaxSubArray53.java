package problems.array.easy;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 * <b>Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * TODO: Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaxSubArray53 {

    public static void main(String[] args) {
        MaxSubArray53 maxSubArray = new MaxSubArray53();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * Approach 1: Kadane's Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int csum = nums[0];
        int osum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (csum >= 0) {
                csum = csum + nums[i];
            } else {
                csum = nums[i];
            }
            if (csum > osum) {
                osum = csum;
            }
        }
        return osum;
    }
}
