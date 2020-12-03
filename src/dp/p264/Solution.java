package dp.p264;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/3
 */
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i = 2;
        while (list.size() < n) {
            if (isUgly(i)) {
                list.add(i);
            }
            ++ i;
        }
        return list.get(n - 1);
    }

    private boolean isUgly(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
    public static Ugly ugly = new Ugly();
    public int nthUglyNumber2(int n) {

        return ugly.nums[n - 1];
    }
}

class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
        Set<Long> set = new HashSet<>();
        Queue<Long> q = new PriorityQueue<>();
        set.add(1L);
        q.offer(1L);
        long currUgly, newUgly;
        int[] primes = {2,3,5};
        for (int i = 0; i < 1690; i++) {
            currUgly = q.poll();
            nums[i] = (int)currUgly;
            for (int prime : primes) {
                newUgly = currUgly * prime;
                if (!set.contains(newUgly)) {
                    set.add(newUgly);
                    q.offer(newUgly);
                }
            }
        }
    }
}
