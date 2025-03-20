from typing import List
from collections import deque

class Solution:
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:
        # Create adjacency list
        adjList = [[] for _ in range(n)]
        for u, v, w in edges:
            adjList[u].append((v, w))
            adjList[v].append((u, w))

        # Finding components and their cost
        visited = [False] * n
        components = [-1] * n
        componentCost = []
        componentId = 0

        def getComponentCost(source):
            queue = deque([source])
            componentCostValue = float('inf')
            visited[source] = True

            while queue:
                node = queue.popleft()
                components[node] = componentId

                for neighbor, weight in adjList[node]:
                    componentCostValue &= weight
                    if not visited[neighbor]:
                        visited[neighbor] = True
                        queue.append(neighbor)

            return componentCostValue

        for node in range(n):
            if not visited[node]:
                componentCost.append(getComponentCost(node))
                componentId += 1

        # Answer queries
        answer = []
        for start, end in query:
            if components[start] == components[end]:
                answer.append(componentCost[components[start]])
            else:
                answer.append(-1)

        return answer
