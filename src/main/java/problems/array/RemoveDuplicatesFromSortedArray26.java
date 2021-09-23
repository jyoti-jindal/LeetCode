package problems.array;

public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray26();
        int[] nums = {1,1,2,3,4,4};
        int n = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        for(int i=0; i<n ;i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
