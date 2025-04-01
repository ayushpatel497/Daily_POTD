class Solution:
    def __init__(self):
        self.answer = []
    
    def fillAnswer(self, node, adj, visited):
        visited[node] = True
        self.answer.append(node)
        for neighbor in adj[node]:
            if not visited[neighbor]:
                self.fillAnswer(neighbor, adj, visited)

    def dfs(self, adj):
        nodeCount = len(adj)
        visited = [False] * nodeCount
        self.answer = []
        
        for node in range(nodeCount):
            if not visited[node]:
                self.fillAnswer(node, adj, visited)
        
        return self.answer

# Example Usage
sol = Solution()
adj = [[1, 2], [0, 3, 4], [0, 4], [1, 5], [1, 2, 5], [3, 4]]
print(sol.dfs(adj))  # Output: DFS traversal order
