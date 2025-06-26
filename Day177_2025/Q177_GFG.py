import heapq
from collections import Counter

class Solution:
    def minValue(self, s, k):
        freq = Counter(s)
        max_heap = [-count for count in freq.values()]
        heapq.heapify(max_heap)

        while k > 0 and max_heap:
            top = -heapq.heappop(max_heap)
            top -= 1
            if top > 0:
                heapq.heappush(max_heap, -top)
            k -= 1

        return sum(x * x for x in map(lambda x: -x, max_heap))
