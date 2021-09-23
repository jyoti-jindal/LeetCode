package problems.array;

public class MaxProdSubArray152 {
    public static void main(String[] args) {
        MaxProdSubArray152 maxProdsubArray = new MaxProdSubArray152();
        maxProdsubArray.maxProduct(new int[]{2,3,-2,4});
    }

    /**
     * Approach 1: kadane's Algorithm
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int minProd =nums[0];
        int maxProd =nums[0];
        for(int i=1; i<nums.length; i++) {
            if(minProd > 0) {
                minProd *= nums[i];
            } else {
                minProd = nums[i];
            }
            maxProd = Math.max(minProd, maxProd);
        }
        return maxProd;
    }
}
