class Solution:
    def maxEdgesToAdd(self, V, edges):
        # Maximum possible edges in an undirected graph = V*(V-1)/2
        return (V * (V - 1)) // 2 - len(edges)
