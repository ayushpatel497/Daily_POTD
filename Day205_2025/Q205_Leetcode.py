import sys
from typing import List


class Solution:
    def minimumScore(self, nums: List[int], edges: List[List[int]]) -> int:
        from collections import defaultdict
        sys.setrecursionlimit(10**6)

        n = len(nums)
        sum_ = [0] * n
        in_ = [0] * n
        out = [0] * n
        time = [0]  # using list for mutable integer
        adj = defaultdict(list)

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        def dfs(x, parent):
            in_[x] = time[0]
            time[0] += 1
            sum_[x] = nums[x]

            for y in adj[x]:
                if y == parent:
                    continue
                dfs(y, x)
                sum_[x] ^= sum_[y]

            out[x] = time[0]

        def calc(a, b, c):
            return max(a, b, c) - min(a, b, c)

        dfs(0, -1)

        res = float('inf')
        for u in range(1, n):
            for v in range(u + 1, n):
                if in_[v] > in_[u] and in_[v] < out[u]:
                    res = min(res, calc(sum_[0] ^ sum_[u], sum_[u] ^ sum_[v], sum_[v]))
                elif in_[u] > in_[v] and in_[u] < out[v]:
                    res = min(res, calc(sum_[0] ^ sum_[v], sum_[v] ^ sum_[u], sum_[u]))
                else:
                    res = min(res, calc(sum_[0] ^ sum_[u] ^ sum_[v], sum_[u], sum_[v]))

        return res
