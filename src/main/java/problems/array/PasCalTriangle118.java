package problems.array;

import java.util.ArrayList;
import java.util.List;

public class PasCalTriangle118 {
    public static void main(String[] args) {
        PasCalTriangle118 pasCalTriangle = new PasCalTriangle118();
        pasCalTriangle.generate(2);
    }
// TODO- need to solve this

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOflist = new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++) {
            List<Integer> list = new ArrayList<Integer>();
            int n = (int) Math.pow(11,i);
            while(n>0) {
                int a= n%10;
                n=n/10;
                list.add(a);
            }
            listOflist.add(list);
        }
        return listOflist;
    }
}
