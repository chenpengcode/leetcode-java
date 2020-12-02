package greed.p738;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/2
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] str = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < str.length && str[i - 1] <= str[i]) {
            ++i;
        }
        while (i > 0 && i < str.length && str[i - 1] > str[i] ) {
            --i;
            --str[i];
        }

        for (int j = i + 1; j < str.length; j++) {
            str[j] = '9';
        }

        return Integer.parseInt(String.valueOf(str));
    }

    public static void main(String[] args) {
        int N = 100;
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(N));
    }
}
