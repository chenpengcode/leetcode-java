package array.p134;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-19 1:43
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = gas.length;
        while (i < n) {
            int cnt = 0;
            int sumCost = 0;
            int sumGas = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumCost += cost[j];
                sumGas += gas[j];
                if (sumCost > sumGas) {
                    break;
                }
                cnt ++;
            }
            if (cnt == n){
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
