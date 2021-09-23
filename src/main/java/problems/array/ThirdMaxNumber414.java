package problems.array;

import java.util.Arrays;

public class ThirdMaxNumber414 {
    public static void main(String[] args) {
        ThirdMaxNumber414 thirdMaxNumber = new ThirdMaxNumber414();
        int[] nums = {3,2,1};
        thirdMaxNumber.thirdMax(nums);
    }

    /**
     * Approach 1: Sort array and find 3rd max element
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<3) {
            return nums[n-1];
        } else {
            int max = nums[n-1];
            int thirdMax = nums[n-1];
            int count = 1;
            for(int i=n-1; i>=0;i--) {
                if(nums[i]<thirdMax && count<3) {
                    thirdMax = nums[i];
                    count++;
                }
            }
            if(count < 3) {
                return max;
            }
            return thirdMax;
        }
    }
}
