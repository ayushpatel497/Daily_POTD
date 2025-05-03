from typing import List


class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        countA = [0] * 7
        countB = [0] * 7
        countSame = [0] * 7
        n = len(tops)

        for i in range(n):
            countA[tops[i]] += 1
            countB[bottoms[i]] += 1
            if tops[i] == bottoms[i]:
                countSame[tops[i]] += 1

        ans = n
        for i in range(1, 7):
            if countA[i] + countB[i] - countSame[i] == n:
                ans = min(ans, n - max(countA[i], countB[i]))

        return -1 if ans == n else ans
