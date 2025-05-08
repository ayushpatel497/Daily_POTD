import java.util.*;

class State {
    int x, y, dis;
    State(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Q128_Leetcode {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] d = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int inf = 0x3f3f3f3f;

        for (int[] row : d) Arrays.fill(row, inf);
        d[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.offer(new State(0, 0, 0));

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            State s = pq.poll();
            if (visited[s.x][s.y]) continue;
            if (s.x == n - 1 && s.y == m - 1) break;
            visited[s.x][s.y] = true;

            for (int[] dir : dirs) {
                int nx = s.x + dir[0];
                int ny = s.y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int dist = Math.max(d[s.x][s.y], moveTime[nx][ny]) + (s.x + s.y) % 2 + 1;
                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist;
                    pq.offer(new State(nx, ny, dist));
                }
            }
        }

        return d[n - 1][m - 1];
    }
}
