package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDisappearedNumbers448 {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n: nums) {
            map.put(n,1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=nums.length ;i++) {
            if(!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Approach 2: Using Count Sort
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbersApproach2(int[] nums) {
        int[] count = new int[nums.length+1];
        for(int n: nums) {
            count[n]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=nums.length ;i++) {
            if(count[i]==0) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Approach 3: Change the value in-place
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbersApproach3(int[] nums) {
        for(int i=0; i<nums.length ;i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length ;i++) {
            if(nums[i]>0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
