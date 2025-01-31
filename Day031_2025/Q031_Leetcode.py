from typing import List

class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        island_sizes = {}
        island_id = 2  # Start island IDs from 2
        
        def explore_island(row: int, col: int, island_id: int) -> int:
            if row < 0 or row >= n or col < 0 or col >= n or grid[row][col] != 1:
                return 0
            
            grid[row][col] = island_id
            return 1 + explore_island(row + 1, col, island_id) + \
                       explore_island(row - 1, col, island_id) + \
                       explore_island(row, col + 1, island_id) + \
                       explore_island(row, col - 1, island_id)

        # Step 1: Assign unique island IDs and compute sizes
        for row in range(n):
            for col in range(n):
                if grid[row][col] == 1:
                    island_sizes[island_id] = explore_island(row, col, island_id)
                    island_id += 1

        if not island_sizes:
            return 1

        max_island_size = max(island_sizes.values())

        # Step 2: Try converting each 0 into 1 and check the largest island possible
        for row in range(n):
            for col in range(n):
                if grid[row][col] == 0:
                    neighboring_islands = set()
                    
                    # Check 4 directions
                    if row > 0 and grid[row - 1][col] > 1:
                        neighboring_islands.add(grid[row - 1][col])
                    if row < n - 1 and grid[row + 1][col] > 1:
                        neighboring_islands.add(grid[row + 1][col])
                    if col > 0 and grid[row][col - 1] > 1:
                        neighboring_islands.add(grid[row][col - 1])
                    if col < n - 1 and grid[row][col + 1] > 1:
                        neighboring_islands.add(grid[row][col + 1])

                    new_island_size = 1  # The converted cell itself
                    for id in neighboring_islands:
                        new_island_size += island_sizes[id]

                    max_island_size = max(max_island_size, new_island_size)

        return max_island_size
