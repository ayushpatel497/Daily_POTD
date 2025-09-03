from typing import List

class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        ans = 0

        # Sort: by x ascending, if tie then y descending
        points.sort(key=lambda p: (p[0], -p[1]))

        for i in range(len(points) - 1):
            xMin = points[i][0] - 1
            xMax = float('inf')
            yMin = float('-inf')
            yMax = points[i][1] + 1

            for j in range(i + 1, len(points)):
                if (points[j][0] > xMin and points[j][0] < xMax and
                    points[j][1] > yMin and points[j][1] < yMax):
                    
                    ans += 1
                    xMin = points[j][0]
                    yMin = points[j][1]

        return ans
