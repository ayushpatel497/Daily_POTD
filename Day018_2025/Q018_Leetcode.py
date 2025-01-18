from collections import deque
from typing import List

class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        # Q. Minimum Cost to Make at Least One Valid Path in a Grid
        rowSize = len(grid)
        colSize = len(grid[0])

        minimumCost = [[float('inf')] * colSize for _ in range(rowSize)]
        positionDeque = deque([(0, 0)])
        minimumCost[0][0] = 0

        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while positionDeque:
            row, col = positionDeque.popleft()

            for direction, (dr, dc) in enumerate(directions):
                newRow, newCol = row + dr, col + dc
                cost = 1 if grid[row][col] != (direction + 1) else 0

                if self.isValid(newRow, newCol, rowSize, colSize) and (minimumCost[row][col] + cost < minimumCost[newRow][newCol]):
                    minimumCost[newRow][newCol] = minimumCost[row][col] + cost

                    if cost == 1:
                        positionDeque.append((newRow, newCol))
                    else:
                        positionDeque.appendleft((newRow, newCol))

        return minimumCost[rowSize - 1][colSize - 1]

    def isValid(self, newRow, newCol, rowSize, colSize):
        return 0 <= newRow < rowSize and 0 <= newCol < colSize
