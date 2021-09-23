package problems.array;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 * <b>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {
        MergeSortedArray88 mergeSortedArray = new MergeSortedArray88();
        int nums1[] = {1, 2, 3, 0, 0, 0};

        mergeSortedArray.mergeApproach2(nums1, 3, new int[]{2, 5, 6}, 3);
        for (int n : nums1) {
            System.out.print(n + " ");
        }
    }

    /**
     * Approach 1: Start from 0th position
     * Time Complexity: O(m logn) maybe
     * Space Complexity: O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeApproach1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                for (int k = m - 1; k >= i; k--) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[i] = nums2[j];
                j++;
                m++;
            }
        }
        while (j < n) {
            nums1[i] = nums2[j];
            j++;
            i++;
        }
    }

    /**
     * Approach 2: Start from back
     * Time Complexity: O(m+n)
     * Space Complexity: O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeApproach2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
                k--;
            } else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
    }
}
