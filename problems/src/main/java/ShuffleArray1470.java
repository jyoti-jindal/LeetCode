/**
 * <a href="https://leetcode.com/problems/shuffle-the-array"></a>
 * <b>Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * <p>
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn]. </b>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 * Example 3:
 * <p>
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
public class ShuffleArray1470 {
    public static void main(String[] args) {
        ShuffleArray1470 shuffleArray = new ShuffleArray1470();
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;
        System.out.println("Using Approach 1");
        int[] shuffledArray = shuffleArray.shuffleApproach1(nums, n);
        for(int i=0; i<shuffledArray.length; i++) {
            System.out.print(shuffledArray[i] + " ");
        }
        System.out.println();
        System.out.println("Using Approach 2");
        shuffledArray = shuffleArray.shuffleApproach2(nums, n);
        for(int i=0; i<shuffledArray.length; i++) {
            System.out.print(shuffledArray[i] + " ");
        }
        System.out.println();
        System.out.println("Using Approach 3");
        shuffledArray = shuffleArray.shuffleApproach3(nums, n);
        for(int i=0; i<shuffledArray.length; i++) {
            System.out.print(shuffledArray[i] + " ");
        }
    }

    /**
     * Approach 1: j variable is of type int, hence taking n*4 bytes space in memory.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffleApproach1(int[] nums, int n) {
        int[] shuffledArray = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            shuffledArray[j++] = nums[i];
            shuffledArray[j++] = nums[i + n];
        }
        return shuffledArray;
    }

    /**
     * Approach 2: j variable is of type short, hence taking n*2 bytes space in memory.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffleApproach2(int[] nums, int n) {
        int[] shuffledArray = new int[nums.length];
        short j = 0;
        for (int i = 0; i < n; i++) {
            shuffledArray[j++] = nums[i];
            shuffledArray[j++] = nums[i + n];
        }
        return shuffledArray;
    }

    /**
     * Approach 3: iterator variable (i) is used for indexing of output array, hence no extra space is used.
     * Time Complexity: O(n)
     * Space Complexity: O(1), if do not consider output array space.
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffleApproach3(int[] nums, int n) {
        int[] shuffledArray = new int[nums.length];
        for (int i = 0; i < n; i++) {
            shuffledArray[2 * i] = nums[i];
            shuffledArray[2 * i + 1] = nums[i + n];
        }
        return shuffledArray;
    }
}
