package problems.array;
/**
 * <a href="https://leetcode.com/problems/set-mismatch">Set Mismatch</a>
 * <b>You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */

import java.util.HashMap;

public class SetMismatch645 {
    public static void main(String[] args) {
        SetMismatch645 setMismatch = new SetMismatch645();
        int A[] = {1,2,2,4};
        int[] output = setMismatch.findErrorNumsApproach1(A);
        for(int n: output) {
            System.out.print(n + " ");
        }
    }

    /**
     * Approach 1: Using 2 equations
     * A-B = Sum(Actual) - Sum(Array Elements) -- 1
     * A^2-B^2 = Sum(Square Actual) - Sum(Square Array Elements) --2
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param
     * @return
     */
    public int[] findErrorNumsApproach1(int[] A) {
        int len = A.length;
        int Sum_N = 0;
        int Sum_NSq = 0;
        int missingNumber = 0, repeating = 0;

        for (int i = 0; i < A.length; i++) {
            Sum_N += (i + 1) - A[i];
            Sum_NSq += ((i + 1) * (i + 1)) - (A[i] * A[i]);
        }
        missingNumber = ((Sum_N + Sum_NSq / Sum_N) / 2);
        repeating = (missingNumber - Sum_N);
        return new int[]{repeating, missingNumber};
        //or
//        int sum = (Sum_NSq/Sum_N);
//        return new int[]{(sum-Sum_N)/2, (sum+Sum_N)/2};
    }

    /**
     * Approach 2: Using HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int[] findErrorNumsApproach2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int missing = 0;
        int duplicate = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                duplicate = n;
            }
            map.put(n, 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == null) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }

    /**
     * Approach 3: Using Counting sort
     * Time Complexity: O(n)
     * Space Complexity: O(n+1) = O(n)
     *
     * @param nums
     * @return
     */
    public int[] findErrorNumsApproach3(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            arr[nums[i]]++;
        int[] res = new int[2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2)
                res[0] = i;
            if (arr[i] == 0)
                res[1] = i;
            if (res[0] != 0 && res[1] != 0)
                break;
        }
        return res;
    }
}
