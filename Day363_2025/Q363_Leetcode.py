from typing import List
from collections import defaultdict

class Solution:
    def helper(self, index, nextBottom, bottom, mp, memo):
        if len(bottom) == 1:
            return True

        if index == len(bottom) - 1:
            if nextBottom in memo:
                return memo[nextBottom]
            res = self.helper(0, "", nextBottom, mp, memo)
            memo[nextBottom] = res
            return res

        key = bottom[index:index+2]
        if key not in mp:
            return False

        for ch in mp[key]:
            if self.helper(index + 1, nextBottom + ch, bottom, mp, memo):
                return True
        return False

    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mp = defaultdict(list)
        memo = {}

        for s in allowed:
            mp[s[:2]].append(s[2])

        return self.helper(0, "", bottom, mp, memo)
