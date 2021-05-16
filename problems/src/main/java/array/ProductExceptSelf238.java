package array;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 * <b>Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductExceptSelf238 {
    public static void main(String[] args) {
        ProductExceptSelf238 productExceptSelf = new ProductExceptSelf238();
        productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
    }

    /**
     * Approach 1:
     * TC: O(n)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int output[] = new int[n];
        output[0] = 1;

        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int k = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            output[i] = output[i] * k;
            k = k * nums[i];
        }
        return output;
    }
}
