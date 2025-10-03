import java.util.*;

class Q276_Leetcode {
    private static class Cell implements Comparable<Cell> {
        int height, row, col;
        Cell(int h, int r, int c) {
            height = h;
            row = r;
            col = c;
        }
        public int compareTo(Cell other) {
            return this.height - other.height; // min-heap
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        // Add boundary cells
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(heightMap[i][0], i, 0));
            pq.offer(new Cell(heightMap[i][n-1], i, n-1));
            visited[i][0] = visited[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(heightMap[0][j], 0, j));
            pq.offer(new Cell(heightMap[m-1][j], m-1, j));
            visited[0][j] = visited[m-1][j] = true;
        }

        int res = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int[] d : dirs) {
                int nr = cur.row + d[0];
                int nc = cur.col + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                int nh = heightMap[nr][nc];
                res += Math.max(0, cur.height - nh);
                pq.offer(new Cell(Math.max(nh, cur.height), nr, nc));
            }
        }

        return res;
    }
}
