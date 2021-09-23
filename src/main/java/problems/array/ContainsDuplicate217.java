package problems.array; /**
 * <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 * <b>Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.</b>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        ContainsDuplicate217 containsDuplicate = new ContainsDuplicate217();
        int[] nums = {1, 2, 3, 1};
        System.out.println("Using Approach 0: " + containsDuplicate.containsDuplicateApproach0(nums));
        System.out.println("Using Approach 1: " + containsDuplicate.containsDuplicateApproach1(nums));
        System.out.println("Using Approach 2: " + containsDuplicate.containsDuplicateApproach2(nums));
    }

    /**
     * Brute-Force Approach
     * Time Complexity: O(n^2); Space Complexity: O(1)
     * For larger inputs, this approach will fail with <b>Time Limit Exceeded</b>.
     * Usually, if an algorithm is O(n^2), it can handle nn up to around 10^4.
     * It gets Time Limit Exceeded when n ≥ 10^5.
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateApproach0(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Time Complexity: O(nlogn);
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateApproach1(int[] nums) {
        Arrays.sort(nums); // O(nlogn)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Time Complexity: O(n); Space Complexity: O(n)
     * This can be slower for small inputs than Approach 1
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateApproach2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
