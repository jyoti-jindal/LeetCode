package problems.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum1 {


    public static void main(String[] args) {
        TwoSum1 twoSum = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] returnedArray = twoSum.twoSumApproach1(nums, target);
        System.out.println("Answer using Approach 1");
        for (int n : returnedArray) {
            System.out.print(n + " ");
        }
        System.out.println();
        returnedArray = twoSum.twoSumApproach2(nums, target);
        System.out.println("Answer using Approach 2");
        for (int n : returnedArray) {
            System.out.print(n + " ");
        }
        System.out.println();
        returnedArray = twoSum.twoSumApproach3(nums, target);
        System.out.println("Answer using Approach 3");
        for (int n : returnedArray) {
            System.out.print(n + " ");
        }
    }

    /**
     * Brute-Force Approach
     * Time Complexity : O(n^2), For each element, we try to find its
     * complement by looping through the rest of array which takes O(n) time.
     * Space Complexity : O(1)
     *
     * @param nums   the original array
     * @param target the target sum
     * @return the integer array
     */
    public int[] twoSumApproach1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        System.out.print("No two sum solution found.");
        return null;
    }

    /**
     * Two-pass Hash
     * Time Complexity : O(n), hash table reduced the look up time to O(1)
     * Space Complexity : O(n), extra space required depends on the number of items
     * stored in the hash table, which stores exactly nn elements.
     * <p>
     * Note: You can do it with single pass also.</p>
     *
     * @param nums   the original array
     * @param target the target sum
     * @return the integer array
     */
    public int[] twoSumApproach2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        System.out.print("No two sum solution found.");
        return null;
    }

    /**
     * One-pass Hash
     * Time Complexity : O(n), Hash table reduced the look up time to O(1)
     * Space Complexity : O(n), extra space required depends on the number of items
     * stored in the hash table, which stores exactly nn elements.
     * <p>
     * Note: You can do it with single pass also.</p>
     *
     * @param nums   the original array
     * @param target the target sum
     * @return the integer array
     */
    public int[] twoSumApproach3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        System.out.print("No two sum solution found.");
        return null;
    }
}
