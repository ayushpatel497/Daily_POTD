from typing import List
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        parent = [-1] * (len(edges) + 1)  # 1-based indexing

        def findParent(node):
            if parent[node] == -1:
                return node
            parent[node] = findParent(parent[node])  # Path compression
            return parent[node]

        for u, v in edges:
            parentU = findParent(u)
            parentV = findParent(v)

            if parentU == parentV:
                return [u, v]  # Found the redundant edge
            
            parent[parentU] = parentV  # Union

        return []
