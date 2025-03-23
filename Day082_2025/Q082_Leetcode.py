import heapq
from typing import List

class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        MOD = 10**9 + 7
        graph = [[] for _ in range(n)]

        for startNode, endNode, travelTime in roads:
            graph[startNode].append((endNode, travelTime))
            graph[endNode].append((startNode, travelTime))

        minHeap = [(0, 0)]  # (time, node)
        shortestTime = [float('inf')] * n
        pathCount = [0] * n

        shortestTime[0] = 0
        pathCount[0] = 1

        while minHeap:
            currTime, currNode = heapq.heappop(minHeap)
            if currTime > shortestTime[currNode]:
                continue

            for neighborNode, roadTime in graph[currNode]:
                if currTime + roadTime < shortestTime[neighborNode]:
                    shortestTime[neighborNode] = currTime + roadTime
                    pathCount[neighborNode] = pathCount[currNode]
                    heapq.heappush(minHeap, (shortestTime[neighborNode], neighborNode))
                elif currTime + roadTime == shortestTime[neighborNode]:
                    pathCount[neighborNode] = (pathCount[neighborNode] + pathCount[currNode]) % MOD

        return pathCount[n - 1]
