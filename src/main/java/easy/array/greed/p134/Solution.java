package main.java.easy.array.greed.p134;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/12
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumGas = 0, sumCost = 0;
            int count = 0;
            while (count < n) {
                int j = (i + count) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas) {
                    break;
                }
                ++count;
            }
            if (count == n) return i;
            i = i + count + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cos = {3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit(gas, cos));
    }
}
