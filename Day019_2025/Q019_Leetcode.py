from typing import List
import heapq

class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        if not heightMap or not heightMap[0]:
            return 0

        rowSize, colSize = len(heightMap), len(heightMap[0])
        visited = [[False] * colSize for _ in range(rowSize)]
        boundary = []

        # Add boundary cells to the priority queue
        for row in range(rowSize):
            heapq.heappush(boundary, (heightMap[row][0], row, 0))
            heapq.heappush(boundary, (heightMap[row][colSize - 1], row, colSize - 1))
            visited[row][0] = visited[row][colSize - 1] = True
        for col in range(colSize):
            heapq.heappush(boundary, (heightMap[0][col], 0, col))
            heapq.heappush(boundary, (heightMap[rowSize - 1][col], rowSize - 1, col))
            visited[0][col] = visited[rowSize - 1][col] = True

        totalWaterVolume = 0
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        # Process cells in the priority queue
        while boundary:
            minBoundaryHeight, row, col = heapq.heappop(boundary)

            for dr, dc in directions:
                neighborRow, neighborCol = row + dr, col + dc

                if self.isValidCell(neighborRow, neighborCol, rowSize, colSize) and not visited[neighborRow][neighborCol]:
                    neighborHeight = heightMap[neighborRow][neighborCol]

                    if neighborHeight < minBoundaryHeight:
                        totalWaterVolume += minBoundaryHeight - neighborHeight

                    heapq.heappush(boundary, (max(neighborHeight, minBoundaryHeight), neighborRow, neighborCol))
                    visited[neighborRow][neighborCol] = True

        return totalWaterVolume

    def isValidCell(self, row, col, rowSize, colSize):
        return 0 <= row < rowSize and 0 <= col < colSize