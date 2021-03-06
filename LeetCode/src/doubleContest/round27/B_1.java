package doubleContest.round27;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/30
 */
public class B_1 {

    private int strToInt(char[] arr, int l, int r) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans <<= 1;
            ans += (arr[i] - '0');
        }
        return ans;
    }

    public boolean hasAllCodes(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= len - k; i++) {
            set.add(strToInt(arr, i, i + k - 1));
        }

        return set.size() == (1 << k);
    }

}
