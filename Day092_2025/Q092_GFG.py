from collections import deque
from typing import List

class Solution:
    # Function to return Breadth First Search traversal of given graph.
    def bfs(self, adj: List[List[int]]) -> List[int]:
        nodeCount = len(adj)
        answer = []
        visited = [False] * nodeCount
        queue = deque()

        visited[0] = True
        queue.append(0)

        while queue:
            node = queue.popleft()
            answer.append(node)

            for neighbor in adj[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)

        return answer

# Example Usage
sol = Solution()
adj = [[1, 2, 3], [0, 4], [0, 4], [0, 5], [1, 2, 6], [3], [4]]
print(sol.bfs(adj))  # Output: BFS traversal list
