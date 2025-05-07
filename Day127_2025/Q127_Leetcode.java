import java.util.*;

class State {
    int x, y, dis;
    State(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Q127_Leetcode {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] d = new int[n][m];
        boolean[][] v = new boolean[n][m];
        int INF = Integer.MAX_VALUE;

        for (int[] row : d)
            Arrays.fill(row, INF);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        d[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State s = pq.poll();
            if (v[s.x][s.y]) continue;
            v[s.x][s.y] = true;

            for (int[] dir : dirs) {
                int nx = s.x + dir[0];
                int ny = s.y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int dist = Math.max(d[s.x][s.y], moveTime[nx][ny]) + 1;
                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist;
                    pq.add(new State(nx, ny, dist));
                }
            }
        }

        return d[n - 1][m - 1];
    }
}
