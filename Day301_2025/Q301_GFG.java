import java.util.*;

class Q301_GFG {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(col, -1));
            ans.add(temp);
        }

        Queue<int[]> q = new LinkedList<>();

        // Push all 1s into queue and mark their distance as 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    ans.get(i).set(j, 0);
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int a = cell[0], b = cell[1];

            for (int k = 0; k < 4; k++) {
                int na = a + dx[k];
                int nb = b + dy[k];

                if (na < 0 || nb < 0 || na >= row || nb >= col || ans.get(na).get(nb) != -1) continue;

                ans.get(na).set(nb, ans.get(a).get(b) + 1);
                q.offer(new int[]{na, nb});
            }
        }

        return ans;
    }
}
