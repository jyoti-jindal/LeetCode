package problems.array;

public class NumberOfTeams1395 {
    public static void main(String[] args) {

    }

    /**
     * Approach 1: Brute-Force
     * TC: O(n^3)
     * SC: O(1)
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int count = 0;
        for(int i=0 ; i<rating.length; i++) {
            for(int j=i+1 ; j<rating.length; j++) {
                for(int k=j+1 ; k<rating.length; k++) {
                    if((rating[i]<rating[j] && rating[j]<rating[k]) ||
                            (rating[i]>rating[j] && rating[j]>rating[k]))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
