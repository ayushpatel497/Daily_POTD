import heapq

class Solution:
    def minCost(self, houses):
        V = len(houses)
        inMST = [False] * V
        pq = [(0, 0)]  # (cost, node)
        total_cost = 0

        while pq:
            wt, u = heapq.heappop(pq)
            if inMST[u]:
                continue

            inMST[u] = True
            total_cost += wt

            for v in range(V):
                if not inMST[v]:
                    dist = abs(houses[u][0] - houses[v][0]) + abs(houses[u][1] - houses[v][1])
                    heapq.heappush(pq, (dist, v))

        return total_cost
