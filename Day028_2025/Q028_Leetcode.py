from typing import List
class Solution:
    def is_valid(self, row, col, row_size, col_size):
        return 0 <= row < row_size and 0 <= col < col_size

    def get_max_fishes(self, row, col, row_size, col_size, grid):
        current_fishes = grid[row][col]
        grid[row][col] = 0  # Mark as visited

        for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            new_row, new_col = row + dr, col + dc

            if self.is_valid(new_row, new_col, row_size, col_size) and grid[new_row][new_col] != 0:
                current_fishes += self.get_max_fishes(new_row, new_col, row_size, col_size, grid)

        return current_fishes

    def findMaxFish(self, grid: List[List[int]]) -> int:
        row_size = len(grid)
        col_size = len(grid[0])
        max_fishes = 0

        for row in range(row_size):
            for col in range(col_size):
                if grid[row][col] != 0:
                    current_fishes = self.get_max_fishes(row, col, row_size, col_size, grid)
                    max_fishes = max(max_fishes, current_fishes)

        return max_fishes
