from typing import List
from collections import deque

class Solution:
    def isSafe(self, x: int, y: int, mat: List[List[int]]) -> bool:
        return 0 <= x < len(mat) and 0 <= y < len(mat[0]) and mat[x][y] == 1

    def orangesRotting(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        freshOrg, time = 0, 0
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        queue = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 2:
                    queue.append((i, j))
                if mat[i][j] == 1:
                    freshOrg += 1

        while queue and freshOrg:
            for _ in range(len(queue)):
                x, y = queue.popleft()
                for k in range(4):
                    newi, newj = x + dx[k], y + dy[k]
                    if self.isSafe(newi, newj, mat):
                        mat[newi][newj] = 2
                        queue.append((newi, newj))
                        freshOrg -= 1
            time += 1

        return time if freshOrg == 0 else -1

# Example Usage
sol = Solution()
mat = [
    [2, 1, 1],
    [1, 1, 0],
    [0, 1, 1]
]
print(sol.orangesRotting(mat))  # Output: 4
