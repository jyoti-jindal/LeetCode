package problems.binarysearch.easy;

/**
 * <a href="https://leetcode.com/problems/binary-search/">704. Binary Search</a>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 *  
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

public class BinarySearch704 {
  
    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12};
        System.out.println("Using Binary Search Approach" + search(nums, 9));
    }
  
    /**
     * Binary Search Approach
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low  = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low + ((high-low)/2);
            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
