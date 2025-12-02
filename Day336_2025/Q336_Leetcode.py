from typing import List


class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        MOD = 10**9 + 7

        pointNum = {}
        for x, y in points:
            pointNum[y] = pointNum.get(y, 0) + 1

        ans = 0
        sum_edges = 0

        for pNum in pointNum.values():
            edge = pNum * (pNum - 1) // 2  # nC2

            ans = (ans + edge * sum_edges) % MOD
            sum_edges = (sum_edges + edge) % MOD

        return ans % MOD
