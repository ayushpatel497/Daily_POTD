class Solution:
    def ratInMaze(self, maze):
        n = len(maze)
        if maze[0][0] == 0 or maze[n - 1][n - 1] == 0:
            return []

        directions = "DLRU"
        dr = [1, 0, 0, -1]
        dc = [0, -1, 1, 0]
        result = []

        def is_valid(r, c):
            return 0 <= r < n and 0 <= c < n and maze[r][c] == 1

        def backtrack(r, c, path):
            if r == n - 1 and c == n - 1:
                result.append(path)
                return
            maze[r][c] = 0  # mark visited
            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]
                if is_valid(nr, nc):
                    backtrack(nr, nc, path + directions[i])
            maze[r][c] = 1  # unmark

        backtrack(0, 0, "")
        result.sort()
        return result
