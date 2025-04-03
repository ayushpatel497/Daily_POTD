import java.util.*;

class Q093_GFG {
    private boolean isSafe(int x, int y, int[][] mat) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] == 1;
    }

    public int orangesRotting(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int freshOrg = 0, time = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2)
                    queue.add(new int[]{i, j});
                if (mat[i][j] == 1)
                    freshOrg++;
            }
        }

        while (!queue.isEmpty() && freshOrg > 0) {
            int size = queue.size();
            for (int sz = 0; sz < size; sz++) {
                int[] idxs = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newi = idxs[0] + dx[k];
                    int newj = idxs[1] + dy[k];

                    if (isSafe(newi, newj, mat)) {
                        mat[newi][newj] = 2;
                        queue.add(new int[]{newi, newj});
                        freshOrg--;
                    }
                }
            }
            time++;
        }
        
        return freshOrg == 0 ? time : -1;
    }

    public static void main(String[] args) {
        Q093_GFG sol = new Q093_GFG();
        int[][] mat = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(sol.orangesRotting(mat)); // Output: 4
    }
}
