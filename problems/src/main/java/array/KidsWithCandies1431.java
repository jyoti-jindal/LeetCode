package array; /**
 * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Kids With the Greatest Number of Candies</a>
 * <b>Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
 * <p>
 * For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
 * </b>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 * Explanation:
 * Kid 1 has 2 candies and if he or she receives all extra candies (3) will have 5 candies --- the greatest number of candies among the kids.
 * Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Kid 3 has 5 candies and this is already the greatest number of candies among the kids.
 * Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
 * Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Example 2:
 * <p>
 * Input: candies = [4,2,1,1,2], extraCandies = 1
 * Output: [true,false,false,false,false]
 * Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of candies among the kids regardless of who takes the extra candy.
 * Example 3:
 * <p>
 * Input: candies = [12,1,12], extraCandies = 10
 * Output: [true,false,true]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 */

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies1431 {
    public static void main(String[] args) {
        KidsWithCandies1431 kidsWithCandies = new KidsWithCandies1431();
        int[] candies = {2,3,5,1,3};
        List<Boolean> output = new ArrayList<Boolean>();
        System.out.println("--- Using Approach 1 ---");
        output = kidsWithCandies.kidsWithCandiesApproach1(candies, 3);
        for(Boolean b: output) {
            System.out.print(b.toString() + " ");
        }
        System.out.println();
        System.out.println("--- Using Approach 2 ---");
        output = kidsWithCandies.kidsWithCandiesApproach2(candies, 3);
        for(Boolean b: output) {
            System.out.print(b.toString() + " ");
        }

    }

    /**
     * Approach 1: Brute-Force
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandiesApproach1(int[] candies, int extraCandies) {
        ArrayList<Boolean> output = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            boolean flag = true;
            int can = candies[i] + extraCandies;
            for (int j = 0; j < candies.length; j++) {
                if (can < candies[j]) {
                    flag = false;
                }
            }
            output.add(flag);
        }
        return output;
    }

    /**
     * Approach 2: Greedy Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandiesApproach2(int[] candies, int extraCandies) {
        ArrayList<Boolean> output = new ArrayList<Boolean>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            boolean flag = true;
            if ((candies[i] + extraCandies) < max) {
                flag = false;
            }
            output.add(flag);
        }
        return output;
    }
}
