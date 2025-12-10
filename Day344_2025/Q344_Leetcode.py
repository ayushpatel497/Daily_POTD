from typing import List


class Solution:
    def countPermutations(self, complexity: List[int]) -> int:
        n = len(complexity)

        if min(complexity[1:]) <= complexity[0]:
            return 0

        mod = 10**9 + 7
        ans = 1

        for i in range(2, n):
            ans = (ans * i) % mod

        return ans
