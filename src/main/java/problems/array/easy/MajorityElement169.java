package problems.array.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>
 * <b>
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * </b>
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement169 {
    public static void main(String[] args) {
        majorityElementAppraoch1(new int[]{3, 2, 3});
        majorityElementAppraoch2(new int[]{3, 2, 3});
    }

    /**
     * Approach Sort and fetch the middle element,
     * since it is guaranteed that the majority element always exist.
     * TC: O(nlogn)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public static int majorityElementAppraoch1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Approach: Boyer-Moore Voting Algorithm
     * TC: O(n)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public static int majorityElementAppraoch2(int[] nums) {
        int count = 0;
        int me = nums[0];

        for (int num : nums) {
            if (me == num) {
                count++;
            } else {
                if (count == 0) {
                    count++;
                    me = num;
                } else {
                    count--;
                }
            }
        }
        return me;
    }
}
