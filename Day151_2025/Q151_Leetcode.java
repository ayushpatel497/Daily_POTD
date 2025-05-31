import java.util.*;

class Q151_Leetcode {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;

        int label = 1;
        int[][] cells = new int[n * n + 1][2];
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) cols.add(i);

        for (int row = n - 1; row >= 0; row--) {
            for (int col : cols) {
                cells[label++] = new int[]{row, col};
            }
            Collections.reverse(cols);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next = curr + 1; next <= Math.min(n * n, curr + 6); next++) {
                int[] pos = cells[next];
                int r = pos[0], c = pos[1];
                int dest = board[r][c] != -1 ? board[r][c] : next;

                if (dist[dest] == -1) {
                    dist[dest] = dist[curr] + 1;
                    q.offer(dest);
                }
            }
        }

        return dist[n * n];
    }
}
