package greed.p649;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/11
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int ir = radiant.poll(), id = dire.poll();
            if (ir < id) {
                radiant.offer(ir + n);
            } else {
                dire.offer(id + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
