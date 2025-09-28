import heapq
from collections import defaultdict

class Solution:
    def longestSubarray(self, arr, x):
        maxi = []   # max-heap (store negative values)
        mini = []   # min-heap
        freq = defaultdict(int)

        l, in_idx, start = 0, -1, 0
        n = len(arr)

        for i in range(n):
            freq[arr[i]] += 1
            heapq.heappush(maxi, -arr[i])
            heapq.heappush(mini, arr[i])

            while -maxi[0] - mini[0] > x:
                freq[arr[start]] -= 1
                while maxi and freq[-maxi[0]] == 0:
                    heapq.heappop(maxi)
                while mini and freq[mini[0]] == 0:
                    heapq.heappop(mini)
                start += 1

            if l < i - start + 1:
                in_idx = start
                l = i - start + 1

        return arr[in_idx:in_idx + l]
