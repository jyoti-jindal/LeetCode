package problems.array.easy;

/**
 * <a href="https://leetcode.com/problems/build-array-from-permutation/">Build Array from Permutation</a>
 * <p>
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 * <p>
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,2,1,5,3,4]
 * Output: [0,1,2,4,5,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 * = [0,1,2,4,5,3]
 * Example 2:
 * <p>
 * Input: nums = [5,0,1,2,3,4]
 * Output: [4,5,0,1,2,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
 * = [4,5,0,1,2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * The elements in nums are distinct.
 * <p>
 * <p>
 * Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?
 */
public class BuildArrayFromPermutation1920 {
    public static void main(String[] args) {
        int res[] = buildArrayApproach1(new int[]{0, 2, 1, 5, 3, 4});
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    /**
     * Brute-Force Approach: Just apply what's said in the statement.
     * TC: O(n)
     * SC: O(n)
     *
     * @param nums
     * @return
     */
    public static int[] buildArrayApproach1(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    /**
     * To solve Follow up question: Can you solve it without using an extra space (i.e., O(1) memory)?
     * Approach: Use same array to swap the elements with Basic Idea: a = a + b*n => a = nums[i], b = nums[nums[i]]%n
     * <p>
     * NOTE: %n in b is to get the original value of nums[nums[i]]
     * since the nums[nums[i]] could already be changed like in exmaple 0,1,2,5,3,4
     *
     * @param nums
     * @return
     */
    public static int[] buildArrayApproach2(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            // Basic Idea: a = a + b*n => a = nums[i], b = nums[nums[i]]%n
            int b = nums[nums[i]] % n; /* %n to get the original value of nums[nums[i]] since the nums[nums[i]] could already be changed like in exmaple 0,1,2,5,3,4*/
            nums[i] = nums[i] + b * n;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;
    }
}
