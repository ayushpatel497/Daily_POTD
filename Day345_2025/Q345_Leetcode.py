from typing import List


class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        maxRow = [0] * (n + 1)
        minRow = [n + 1] * (n + 1)
        maxCol = [0] * (n + 1)
        minCol = [n + 1] * (n + 1)

        # process buildings
        for x, y in buildings:
            maxRow[y] = max(maxRow[y], x)
            minRow[y] = min(minRow[y], x)
            maxCol[x] = max(maxCol[x], y)
            minCol[x] = min(minCol[x], y)

        res = 0
        for x, y in buildings:
            if x > minRow[y] and x < maxRow[y] and \
               y > minCol[x] and y < maxCol[x]:
                res += 1

        return res
