import heapq
from typing import List

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        pq = [(grid[0][0], 0, 0)]
        seen = set()
        directions = [(0,1), (1,0), (0,-1), (-1,0)]
        
        while pq:
            time, r, c = heapq.heappop(pq)
            if (r, c) in seen:
                continue
            seen.add((r, c))
            
            if r == n - 1 and c == n - 1:
                return time
            
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and (nr, nc) not in seen:
                    heapq.heappush(pq, (max(time, grid[nr][nc]), nr, nc))
        
        return -1
