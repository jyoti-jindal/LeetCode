public class RemoveElement27 {
    public static void main(String[] args) {
        RemoveElement27 removeElement = new RemoveElement27();
        int[] nums = {3,2,2,3};
        int n = removeElement.removeElement(nums, 3);
        for(int i=0; i<n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * Approach 1: Two Pointers - when elements to remove are rare
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n;) {
            if (nums[i] == val) {
                //int temp = nums[i];
                nums[i] = nums[n-1];
                //nums[n-1] = temp;
                //i--;
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
