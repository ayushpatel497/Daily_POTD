from collections import deque, defaultdict
from typing import List

class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        graph = [[] for _ in range(n)]
        indegree = [0] * n

        for u, v in edges:
            graph[u].append(v)
            indegree[v] += 1

        queue = deque()
        count = [[0] * 26 for _ in range(n)]

        for i in range(n):
            if indegree[i] == 0:
                queue.append(i)
            count[i][ord(colors[i]) - ord('a')] = 1

        visited = 0
        max_count = 0

        while queue:
            u = queue.popleft()
            visited += 1
            for v in graph[u]:
                for c in range(26):
                    add = 1 if ord(colors[v]) - ord('a') == c else 0
                    count[v][c] = max(count[v][c], count[u][c] + add)
                indegree[v] -= 1
                if indegree[v] == 0:
                    queue.append(v)
            max_count = max(max_count, max(count[u]))

        return max_count if visited == n else -1
