from typing import List
class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        visited = [False] * n
        inStack = [False] * n

        def dfs(node):
            if inStack[node]:
                return True  # Cycle detected
            if visited[node]:
                return False  # Already processed

            visited[node] = True
            inStack[node] = True

            for neighbor in graph[node]:
                if dfs(neighbor):
                    return True

            inStack[node] = False  # Node is safe
            return False

        for node in range(n):
            dfs(node)

        # Collect all safe nodes
        return [node for node in range(n) if not inStack[node]]
