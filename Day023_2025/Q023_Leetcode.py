from typing import List

class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        communicable_servers = 0
        row_counts = [0] * len(grid[0])
        last_server_in_row = [-1] * len(grid)

        for row in range(len(grid)):
            server_count_in_row = 0
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    server_count_in_row += 1
                    row_counts[col] += 1
                    last_server_in_row[row] = col

            if server_count_in_row != 1:
                communicable_servers += server_count_in_row
                last_server_in_row[row] = -1

        for row in range(len(grid)):
            if last_server_in_row[row] != -1 and row_counts[last_server_in_row[row]] > 1:
                communicable_servers += 1

        return communicable_servers
