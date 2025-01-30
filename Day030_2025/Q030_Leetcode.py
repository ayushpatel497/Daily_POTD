from collections import deque
from typing import List

class Solution:
    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        adjList = [[] for _ in range(n)]
        for edge in edges:
            adjList[edge[0] - 1].append(edge[1] - 1)
            adjList[edge[1] - 1].append(edge[0] - 1)

        colors = [-1] * n
        for node in range(n):
            if colors[node] == -1:
                colors[node] = 0
                if not self.isBipartite(adjList, node, colors):
                    return -1

        distances = [0] * n
        for node in range(n):
            distances[node] = self.getLongestShortestPath(adjList, node, n)

        maxGroups = 0
        visited = [False] * n
        for node in range(n):
            if not visited[node]:
                maxGroups += self.getNumberOfGroupsForComponent(adjList, node, distances, visited)

        return maxGroups

    def isBipartite(self, adjList, node, colors):
        for neighbor in adjList[node]:
            if colors[neighbor] == colors[node]:
                return False
            if colors[neighbor] == -1:
                colors[neighbor] = (colors[node] + 1) % 2
                if not self.isBipartite(adjList, neighbor, colors):
                    return False
        return True

    def getLongestShortestPath(self, adjList, srcNode, n):
        queue = deque([srcNode])
        visited = [False] * n
        visited[srcNode] = True
        distance = 0

        while queue:
            layerSize = len(queue)
            for _ in range(layerSize):
                currentNode = queue.popleft()
                for neighbor in adjList[currentNode]:
                    if not visited[neighbor]:
                        visited[neighbor] = True
                        queue.append(neighbor)
            distance += 1
        return distance

    def getNumberOfGroupsForComponent(self, adjList, node, distances, visited):
        maxGroups = distances[node]
        visited[node] = True
        for neighbor in adjList[node]:
            if not visited[neighbor]:
                maxGroups = max(maxGroups, self.getNumberOfGroupsForComponent(adjList, neighbor, distances, visited))
        return maxGroups
