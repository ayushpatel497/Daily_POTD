from typing import List

class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0

        for r in range(m - 2):
            for c in range(n - 2):
                if self.isMagic(grid, r, c):
                    ans += 1
        return ans

    def isMagic(self, grid: List[List[int]], r: int, c: int) -> bool:
        freq = [0] * 16

        # check values 1..9 and uniqueness
        for i in range(3):
            for j in range(3):
                num = grid[r + i][c + j]
                if num <= 0 or num >= 10:
                    return False
                freq[num] += 1
                if freq[num] > 1:
                    return False

        d1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]
        d2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]
        if d1 != d2:
            return False

        for i in range(3):
            rowSum = grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2]
            colSum = grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i]

            if rowSum != d1 or colSum != d2:
                return False

        return True
