import heapq

class Solution:
    def maxAverageRatio(self, classes: list[list[int]], extraStudents: int) -> float:
        # Max-heap using negative profit
        def profit(pass_cnt, total_cnt):
            return (pass_cnt + 1) / (total_cnt + 1) - pass_cnt / total_cnt

        heap = []
        total = 0.0

        for p, t in classes:
            total += p / t
            heapq.heappush(heap, (-profit(p, t), p, t))  # negative for max-heap

        for _ in range(extraStudents):
            pfit, p, t = heapq.heappop(heap)
            total += -pfit
            p += 1
            t += 1
            heapq.heappush(heap, (-profit(p, t), p, t))

        return total / len(classes)
