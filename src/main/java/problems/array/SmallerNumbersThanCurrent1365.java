package problems.array;

/**
 * <a href="https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number">How Many Numbers Are Smaller Than the Current Number</a>
 * <b></b>Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.</b>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 * <p>
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class SmallerNumbersThanCurrent1365 {
    public static void main(String[] args) {
        SmallerNumbersThanCurrent1365 smallerNumbersThanCurrent = new SmallerNumbersThanCurrent1365();
        int[] nums = {5, 0, 10, 0, 10, 6};
        System.out.println("Using Approach 1");
        int[] outputArray = smallerNumbersThanCurrent.smallerNumbersThanCurrentApproach1(nums);
        for (int i = 0; i < outputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
        System.out.println();
        int[] nums1 = {5, 0, 10, 0, 10, 6};
        System.out.println("Using Approach 2");
        outputArray = smallerNumbersThanCurrent.smallerNumbersThanCurrentApproach2(nums1);
        for (int i = 0; i < outputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
    }

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrentApproach1(int[] nums) {
        int[] outputArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] && i != j) {
                    count++;
                }
            }
            outputArray[i] = count;
        }
        return outputArray;
    }

    /**
     * Approach 2: Count Sort Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(range of nums)
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrentApproach2(int[] nums) {
        int[] countArray = new int[101];
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 0;
            } else {
                nums[i] = countArray[nums[i] - 1];
            }
        }
        return nums;
    }
}
