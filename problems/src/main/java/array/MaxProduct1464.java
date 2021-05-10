package array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array">Maximum Product of Two Elements in an Array</a>
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * Example 2:
 *
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * Example 3:
 *
 * Input: nums = [3,7]
 * Output: 12
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */
public class MaxProduct1464 {
    public static void main(String[] args) {
        MaxProduct1464 maxProduct = new MaxProduct1464();
        int nums[] = {1, 5, 4, 5};
        System.out.println("Using approach 1" + maxProduct.maxProductApproach1(nums));
        System.out.println("Using approach 2" + maxProduct.maxProductApproach2(nums));
    }

    /**
     * Brute-force Approach
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int maxProductApproach1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mul = (nums[i] - 1) * (nums[j] - 1);
                if (mul > max) {
                    max = mul;
                }
            }
        }
        return max;
    }

    /**
     * Sort and multiply last two elements by subtracting 1 from each element.
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int maxProductApproach2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    /**
     * Find two largest elements and multiply last two elements by subtracting 1 from each element.
     * Time Complexity: O(n)
     * Space Complexity: O(2)
     *
     * @param nums
     * @return
     */
    public int maxProductApproach3(int[] nums) {
        int largest1, largest2;
        largest1 = nums[0];
        largest2 = nums[1];
        if (nums[0] < nums[1]) {
            largest1 = nums[1];
            largest2 = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > largest1) {
                largest2 = largest1;
                largest1 = nums[i];
            } else if (nums[i] > largest2) {
                largest2 = nums[i];
            }
        }
        return (largest1 - 1) * (largest2 - 1);
    }
}
