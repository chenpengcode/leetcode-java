package main.java.easy.array.greed.p861;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/7
 */
public class Solution {
    public int matrixScore_2(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    public int matrixScore(int[][] A) {
        int row = A.length, column = A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                transRow(i, A);
            }
        }

        for (int i = 0; i < column; i++) {
            int count = 0;
            for (int j = 0; j < row; j++) {
                if (A[j][i] == 1) {
                    count++;
                }
            }
            if (count < (row + 1) / 2) {
                transCol(i, A);
            }
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            int bit = 0;
            for (int j = column - 1; j >= 0; j--) {
                sum += A[i][j] << (bit++);
            }
        }
        return sum;
    }

    private void transCol(int column, int[][] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i][column] = nums[i][column] == 1 ? 0 : 1;
        }
    }

    private void transRow(int row, int[][] nums) {
        int length = nums[0].length;
        for (int i = 0; i < length; i++) {
            nums[row][i] = nums[row][i] == 1 ? 0 : 1;
        }
    }

    public static void main(String[] args) {
//        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int[][] A = {{0, 1}, {1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.matrixScore_2(A));
    }
}
