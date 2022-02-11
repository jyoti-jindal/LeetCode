package problems.array.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">
 * 287. Find the Duplicate Number
 * </a>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * Follow up:
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
public class FindDuplicateNumber287 {
    public static void main(String[] args) {
        FindDuplicateNumber287 findDuplicateNumber287 = new FindDuplicateNumber287();
        System.out.println(findDuplicateNumber287.findDuplicate4(new int[]{1, 2, 1, 3, 4}));
    }

    /**
     * Approach 0: Two loops and compare each element with all other array elements.
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate0(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * Approach 1: Sort the array and compare consecutive elements
     * TC: O(nlogn + n)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Approach 2: Sort the array and search using binary search
     * TC: O(nlogn + logn)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 1, r = n - 1;
        int duplicate = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                duplicate = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return duplicate;
    }

    /**
     * Approach 3: Loop over the array and keep adding in a set
     * TC: O(n)
     * SC: O(n)
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Approach 4: Use Floyd's Cycle Detection
     * TC: O(n)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate4(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}