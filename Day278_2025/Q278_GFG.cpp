class Solution {
    string dir = "DLRU";
    int dr[4] = {1, 0, 0, -1};
    int dc[4] = {0, -1, 1, 0};
    bool isValid(int r, int c, int n, vector<vector<int>>& maze) {
        return r >= 0 && c >= 0 && r < n && c < n && maze[r][c];
    }
    void findPath(int r, int c, vector<vector<int>>& maze, string& path, vector<string>& res) {
        int n = maze.size();
        if (r == n - 1 && c == n - 1) {
            res.push_back(path);
            return;
        }
        maze[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (isValid(nr, nc, n, maze)) {
                path.push_back(dir[i]);
                findPath(nr, nc, maze, path, res);
                path.pop_back();
            }
        }
        maze[r][c] = 1;
    }
  public:
    vector<string> ratInMaze(vector<vector<int>>& maze) {
        // Q. Rat in a Maze
        // code here
        vector<string> result;
        int n = maze.size();
        string path = "";
        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            findPath(0, 0, maze, path, result);
        }
        sort(result.begin(), result.end());
        return result;
    }
};