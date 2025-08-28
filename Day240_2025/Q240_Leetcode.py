from typing import List

class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)

        # diagonals from first column
        for i in range(n):
            tmp = [grid[i + j][j] for j in range(n - i)]
            tmp.sort(reverse=True)  # descending
            for j in range(n - i):
                grid[i + j][j] = tmp[j]

        # diagonals from first row
        for j in range(1, n):
            tmp = [grid[i][j + i] for i in range(n - j)]
            tmp.sort()  # ascending
            for i in range(n - j):
                grid[i][j + i] = tmp[i]

        return grid
