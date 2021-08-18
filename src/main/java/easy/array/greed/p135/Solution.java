package main.java.easy.array.greed.p135;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/24
 */
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
            else left[i] = 1;
        }

        int right = 0, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) right++;
            else right = 1;
            ans += Math.max(right, left[i]);
        }
        return ans;
    }

    /**
     * inc 为上一个递增序列的长度， dec为当前递减序列的长度
     * pre 为上一个同学分配的数量
     * @return 最终分配所需要的最少数量
     * **/
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ans = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ans += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) dec++;
                ans += dec;
                pre = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2, 5, 3, 4, 6, 2};
        Solution solution = new Solution();
        System.out.println(solution.candy2(ratings));
    }
}
