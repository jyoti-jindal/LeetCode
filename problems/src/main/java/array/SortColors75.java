package array;

public class SortColors75 {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int countZeros = 0;
        int countOnes = 0;
        int countTwos = 0;
        for(int i=0 ; i<nums.length ;i++) {
            if(nums[i] == 0) {
                countZeros++;
            } else if(nums[i] == 1) {
                countOnes++;
            } else if(nums[i] == 2) {
                countTwos++;
            }
        }
        for(int i=0;i<countZeros;i++) {
            nums[i] = 0;
        }
        for(int i=0;i<countOnes;i++) {
            nums[i+countZeros] = 1;
        }
        for(int i=0;i<countTwos;i++) {
            nums[i+countZeros+countOnes] = 2;
        }
    }
}
