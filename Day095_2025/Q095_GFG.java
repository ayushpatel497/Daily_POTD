import java.util.*;
class Q095_GFG {
    private int m, n;
    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{0,0},{-1,-1},{1,1},{-1,1},{1,-1}};
    
    public int countIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isSafe(grid, visited, newX, newY)) {
                    visited[newX][newY] = true;
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean isSafe(char[][] grid, boolean[][] visited, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 'L' && !visited[x][y];
    }
}
