from collections import deque
from typing import List

class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        directionX = [0, 0, 1, -1]
        directionY = [1, -1, 0, 0]
        rowSize, colSize = len(isWater), len(isWater[0])
        cellHeights = [[-1] * colSize for _ in range(rowSize)]
        cellQueue = deque()

        for x in range(rowSize):
            for y in range(colSize):
                if isWater[x][y] == 1:
                    cellQueue.append((x, y))
                    cellHeights[x][y] = 0

        heightOfNextLayer = 1
        while cellQueue:
            for _ in range(len(cellQueue)):
                currentX, currentY = cellQueue.popleft()
                for direction in range(4):
                    neighborX = currentX + directionX[direction]
                    neighborY = currentY + directionY[direction]
                    if self.isValidCell(neighborX, neighborY, rowSize, colSize) and cellHeights[neighborX][neighborY] == -1:
                        cellHeights[neighborX][neighborY] = heightOfNextLayer
                        cellQueue.append((neighborX, neighborY))
            heightOfNextLayer += 1

        return cellHeights

    def isValidCell(self, x: int, y: int, rowSize: int, colSize: int) -> bool:
        return 0 <= x < rowSize and 0 <= y < colSize
