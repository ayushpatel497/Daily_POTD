from typing import List

class UnionFind:
    def __init__(self, n):
        self.parent = [-1] * n
        self.size = [1] * n

    def find(self, node):
        if self.parent[node] < 0:
            return node
        self.parent[node] = self.find(self.parent[node])
        return self.parent[node]

    def union(self, nodeA, nodeB):
        rootA = self.find(nodeA)
        rootB = self.find(nodeB)
        if rootA == rootB:
            return False
        if self.size[rootA] > self.size[rootB]:
            self.parent[rootB] = rootA
            self.size[rootA] += self.size[rootB]
        else:
            self.parent[rootA] = rootB
            self.size[rootB] += self.size[rootA]
        return True

    def getSize(self, node):
        return self.size[self.find(node)]

class Solution:
    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        rowCount, colCount = len(grid), len(grid[0])
        totalCells = rowCount * colCount

        sortedQueries = sorted(enumerate(queries), key=lambda q: q[1])
        sortedCells = sorted(
            ((r, c, grid[r][c]) for r in range(rowCount) for c in range(colCount)),
            key=lambda cell: cell[2]
        )

        uf = UnionFind(totalCells)
        result = [0] * len(queries)

        cellIndex = 0
        for queryIndex, queryValue in sortedQueries:
            while cellIndex < totalCells and sortedCells[cellIndex][2] < queryValue:
                row, col, _ = sortedCells[cellIndex]
                cellId = row * colCount + col

                for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    newRow, newCol = row + dr, col + dc
                    if 0 <= newRow < rowCount and 0 <= newCol < colCount and grid[newRow][newCol] < queryValue:
                        uf.union(cellId, newRow * colCount + newCol)

                cellIndex += 1

            result[queryIndex] = uf.getSize(0) if queryValue > grid[0][0] else 0

        return result

# Example Usage
grid = [[1, 2, 4], [3, 4, 3], [2, 1, 2]]
queries = [2, 3, 4]
sol = Solution()
print(sol.maxPoints(grid, queries))  # Example Output
