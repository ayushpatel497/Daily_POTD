from typing import List

class Solution:
    def checkCuts(self, rectangles: List[List[int]], dim: int) -> bool:
        rectangles.sort(key=lambda x: x[dim])
        gap_count = 0
        furthest_end = rectangles[0][dim + 2]

        for i in range(1, len(rectangles)):
            if furthest_end <= rectangles[i][dim]:
                gap_count += 1
            furthest_end = max(furthest_end, rectangles[i][dim + 2])

        return gap_count >= 2

    def checkValidCuts(self, n: int, rectangles: List[List[int]]) -> bool:
        return self.checkCuts(rectangles, 0) or self.checkCuts(rectangles, 1)
