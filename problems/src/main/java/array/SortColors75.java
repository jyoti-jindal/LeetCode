package array;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 * <b>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 *
 * </b>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 * <p>
 * Input: nums = [1]
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

public class SortColors75 {
    public static void main(String[] args) {
        SortColors75 sortColors = new SortColors75();
        int[] nums = {2, 0, 2, 1, 1, 0, 0};
        sortColors.sortColorsApproach2(nums);
        for(int n:nums) {
            System.out.print(n + " ");
        }
    }

    /**
     * Approach 1: Count 0's 1's and 2's and, then Overwrite array.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int countZeros = 0;
        int countOnes = 0;
        int countTwos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            } else if (nums[i] == 1) {
                countOnes++;
            } else if (nums[i] == 2) {
                countTwos++;
            }
        }
        for (int i = 0; i < countZeros; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < countOnes; i++) {
            nums[i + countZeros] = 1;
        }
        for (int i = 0; i < countTwos; i++) {
            nums[i + countZeros + countOnes] = 2;
        }
    }

    /**
     * Approach 1: Overwrite array with the total number of 0's, then 1's and followed by 2's.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     */
    public void sortColorsApproach2(int[] nums) {
        int countZeros = 0;
        int countOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            } else if (nums[i] == 1) {
                countOnes++;
            }
        }
        int i = 0;
        for (; i < countZeros; i++) {
            nums[i] = 0;
        }
        for (; i < countZeros + countOnes; i++) {
            nums[i] = 1;
        }
        for (; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
