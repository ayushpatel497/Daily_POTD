import heapq

class Solution:
    def kClosest(self, points, k):
        def squared_dist(p):
            return p[0] ** 2 + p[1] ** 2

        max_heap = []

        for p in points:
            dist = squared_dist(p)
            if len(max_heap) < k:
                heapq.heappush(max_heap, (-dist, p))
            else:
                if dist < -max_heap[0][0]:
                    heapq.heappop(max_heap)
                    heapq.heappush(max_heap, (-dist, p))

        return [point for _, point in max_heap]
