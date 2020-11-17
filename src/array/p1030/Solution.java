package array.p1030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-17 7:58
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });
        return ret;
    }

    public int[][] allCellsDistOrder_2(int R, int C, int r0, int c0) {
        int maxDict = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i < maxDict + 1; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d =  Math.abs(i - r0) + Math.abs(j - c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i < maxDict + 1; i++) {
            for (int[] it: bucket.get(i)) {
                ret[index ++] = it;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int R = 3, C = 3, r0 = 1, c0 = 2;
        System.out.println(Arrays.deepToString(solution.allCellsDistOrder_2(R, C, r0, c0)));
    }
}
