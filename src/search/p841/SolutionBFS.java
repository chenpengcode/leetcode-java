package search.p841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-08-31 8:30
 */
public class SolutionBFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int x = q.poll();
            num++;
            for (Integer it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }
        return num == n;
    }
}
