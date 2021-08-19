package easy.math.p7;

/**
 * @Description
 * @Author CHENPENG
 * @Date 2021/8/19
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int y = Math.abs(x);
        int symbol = x / y;
        int ans = 0;
        while (y > 0) {
            if (ans > Integer.MAX_VALUE / 10) return 0;
            int tmp = y % 10;
            ans = ans * 10 + tmp;
            y /= 10;
        }
        return ans * symbol;
    }
}
