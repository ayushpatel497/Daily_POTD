import java.util.*;
class Q102_GFG {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor == newColor) return image;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            image[x][y] = newColor;

            for (int i = 0; i < 4; i++) {
                int r = x + dx[i];
                int c = y + dy[i];

                if (r >= 0 && r < n && c >= 0 && c < m && image[r][c] == originalColor) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        return image;
    }
}
