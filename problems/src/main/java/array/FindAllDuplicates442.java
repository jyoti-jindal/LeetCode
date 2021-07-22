package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicates442 {
    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int n: nums) {
            if(map.containsKey(n)) {
                list.add(n);
            }
            map.put(n,1);
        }
        return list;
    }
}
