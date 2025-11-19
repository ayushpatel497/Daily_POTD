import java.util.Arrays;
import java.util.PriorityQueue;

class Q323_LeetCode {
    public int minCostPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) 
            Arrays.fill(dist[i], (int)1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])  // {effort, r, c}
        );

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == m - 1) return effort;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newEffort = Math.max(
                        Math.abs(heights[r][c] - heights[nr][nc]),
                        effort
                    );

                    if (dist[nr][nc] > newEffort) {
                        dist[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}
