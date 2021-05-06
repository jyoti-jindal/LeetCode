/**
 * <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array">Maximum Product of Two Elements in an Array</a>
 * <b>Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums. </b>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * Example 3:
 * <p>
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */

public class RunningSum1480 {
    public static void main(String[] args) {

    }

    /**
     * Approach1: Separate Array for Output
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int[] runningSumApproach1(int[] nums) {
        int runningSum[] = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

    /**
     * Approach2: Use Input Array for Output
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int[] runningSumApproach2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
