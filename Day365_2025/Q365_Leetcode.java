import java.util.*;

class Q365_Leetcode {

    private boolean isPossible(int m, int n, int t, int[][] cells) {
        int[][] grid = new int[m + 1][n + 1];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // mark flooded cells till day t
        for (int i = 0; i < t; i++) {
            grid[cells[i][0]][cells[i][1]] = 1;
        }

        Queue<int[]> q = new LinkedList<>();

        // start BFS from top row
        for (int j = 1; j <= n; j++) {
            if (grid[1][j] == 0) {
                q.offer(new int[]{1, j});
                grid[1][j] = 1;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr > 0 && nc > 0 && nr <= m && nc <= n && grid[nr][nc] == 0) {
                    if (nr == m) return true;
                    grid[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col;
        int ans = 0;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isPossible(row, col, mid, cells)) {
                ans = mid;
                left = mid;
            } else {
                right = mid;
            }
        }
        return ans;
    }
}
