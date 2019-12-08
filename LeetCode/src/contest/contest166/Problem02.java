package contest.contest166;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ansList = new ArrayList<>();
        int len = groupSizes.length;

        for (int i = 0; i < len; i++) {
            if (groupSizes[i] == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            int count = groupSizes[i];
            int n = count - 1;
            for (int j = i+1; n > 0 && j < len; j++) {
                if (groupSizes[j] == count) {
                    list.add(j);
                    groupSizes[j] = 0;
                    n--;
                }
            }

            groupSizes[i] = 0;
            ansList.add(list);
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
