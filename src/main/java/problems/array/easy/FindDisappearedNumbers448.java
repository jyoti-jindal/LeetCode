package problems.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">448. Find All Numbers Disappeared in an Array</a>
 * <b>
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * </b>
 * <p>
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p>
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * <p>
 * Follow up: Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */
public class FindDisappearedNumbers448 {
    public static void main(String[] args) {
        System.out.println("Using Approach 1");
        List<Integer> res = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for(int n: res) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Using Approach 2");
        res = findDisappearedNumbersApproach2(new int[]{4,3,2,7,8,2,3,1});
        for(int n: res) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Using Approach 3");
        res = findDisappearedNumbersApproach3(new int[]{4,3,2,7,8,2,3,1});
        for(int n: res) {
            System.out.print(n + " ");
        }
    }

    /**
     * Approach 2: Using HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Approach 2: Using Count Sort
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbersApproach2(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int n : nums) {
            count[n]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Follow up: Could you do it without extra space and in O(n) runtime?
     * You may assume the returned list does not count as extra space.
     * Approach 3: Change the value in-place
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbersApproach3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
