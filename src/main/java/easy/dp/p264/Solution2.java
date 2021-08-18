package main.java.easy.dp.p264;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/3
 */
class Ugly2 {
    public int[] dp = new int[1690];
    Ugly2() {
        dp[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < 1690; ++i) {
            // main.java.easy.dp[i] = min(main.java.easy.dp[i2]*2, main.java.easy.dp[i3]*3, main.java.easy.dp[i5]*5)
            ugly = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            dp[i] = ugly;

            if (ugly == dp[i2] * 2) ++i2;
            if (ugly == dp[i3] * 3) ++i3;
            if (ugly == dp[i5] * 5) ++i5;
        }
    }
}

class Solution2 {
    public static Ugly2 u = new Ugly2();
    public int nthUglyNumber(int n) {
        return u.dp[n - 1];
    }
}

