from bisect import bisect_left, bisect_right
from collections import defaultdict

class Solution:
    def countXInRange(self, arr, queries):
        mp = defaultdict(list)

        # Store indices of each value
        for i, val in enumerate(arr):
            mp[val].append(i)

        ans = []
        for l, r, x in queries:
            if x not in mp:
                ans.append(0)
                continue

            indices = mp[x]
            left = bisect_left(indices, l)
            right = bisect_right(indices, r)
            ans.append(right - left)

        return ans
