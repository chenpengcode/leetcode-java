package greed.p735;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/11
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.offerLast(asteroid);
            } else {
                boolean exist = true;
                while (!stack.isEmpty()) {
                    int volume = stack.peekLast();
                    if (volume > 0) {
                        if (volume > -asteroid) {
                            exist = false;
                            break;
                        } else if (volume < -asteroid){
                            stack.pollLast();
                        } else {
                            exist = false;
                            stack.pollLast();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (exist) {
                    stack.offerLast(asteroid);
                }
            }
        }
        int n = stack.size();
        int[] res = new int[n];
        int i = n - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = {-2,1,1,-1};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }
}
