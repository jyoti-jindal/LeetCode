package problems.array;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 * <b>Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 * <p>
 * Input: nums = [1,1]
 * Output: 1
 * Example 4:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem without modifying the array nums?
 * Can you solve the problem using only constant, O(1) extra space?
 * Can you solve the problem with runtime complexity less than O(n2)?
 */

import java.util.HashMap;

public class FindDuplicate287 {
    public static void main(String[] args) {
        FindDuplicate287 findDuplicate = new FindDuplicate287();
        System.out.println(findDuplicate.findDuplicateApproach4(new int[]{1, 3, 4, 2, 2}));
    }

    /**
     * Approach 1: Using map
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int findDuplicateApproach1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return n;
            }
            map.put(n, 1);
        }
        return 0;
    }

    /**
     * Approach 2: Using Count Sort
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int findDuplicateApproach2(int[] nums) {
        int[] count = new int[nums.length];
        for (int n : nums) {
            count[n]++;
        }

        for (int i = 1; i <= nums.length - 1; i++) {
            if (count[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 3: If Array is immutable, mark the visiting number as negative
     * This approach works only if the numbers are positive.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicateApproach3(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]);
            if (nums[val] < 0) return val;
            nums[val] *= -1;
        }
        return 0;
    }

    /**
     * Approach 4: Floyd's Tortoise and Hare (Cycle Detection) Algorithm
     * Works only if the elements are present are in 1 to N range
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicateApproach4(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
