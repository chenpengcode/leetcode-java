package search.solution;

import org.junit.Test;

import java.util.List;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-08-31 8:17
 */
public class SolutionDFS841 {
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num ++;
        for (Integer it : rooms.get(x)) {
            if (!vis[it])
                dfs(rooms, it);
        }
    }
    @Test
    public void test01() {

    }
}
