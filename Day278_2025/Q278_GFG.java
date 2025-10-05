import java.util.*;

class Q278_GFG {
    private static final String dir = "DLRU";
    private static final int[] dr = {1, 0, 0, -1};
    private static final int[] dc = {0, -1, 1, 0};

    private boolean isValid(int r, int c, int n, int[][] maze) {
        return r >= 0 && c >= 0 && r < n && c < n && maze[r][c] == 1;
    }

    private void findPath(int r, int c, int[][] maze, StringBuilder path, ArrayList<String> res) {
        int n = maze.length;
        if (r == n - 1 && c == n - 1) {
            res.add(path.toString());
            return;
        }
        maze[r][c] = 0; // mark visited
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (isValid(nr, nc, n, maze)) {
                path.append(dir.charAt(i));
                findPath(nr, nc, maze, path, res);
                path.deleteCharAt(path.length() - 1); // backtrack
            }
        }
        maze[r][c] = 1; // unmark
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 1 && maze[n - 1][n - 1] == 1) {
            findPath(0, 0, maze, new StringBuilder(), result);
        }
        Collections.sort(result);
        return result;
    }
}
