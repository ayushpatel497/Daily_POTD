from typing import List
class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        # Calculate the sum of the first row
        first_row_sum = sum(grid[0])
        second_row_sum = 0
        minimum_sum = float('inf')

        # Iterate over each column to determine the minimum sum
        for turn_index in range(len(grid[0])):
            first_row_sum -= grid[0][turn_index]  # Remove the current column from the first row sum
            minimum_sum = min(minimum_sum, max(first_row_sum, second_row_sum))
            second_row_sum += grid[1][turn_index]  # Add the current column to the second row sum

        return minimum_sum
