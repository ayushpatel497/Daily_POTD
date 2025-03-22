from typing import List

class UnionFind:
    def __init__(self, n: int):
        self.parent = [-1] * n
        self.size = [1] * n

    def find(self, node: int) -> int:
        if self.parent[node] == -1:
            return node
        self.parent[node] = self.find(self.parent[node])
        return self.parent[node]

    def union(self, node1: int, node2: int):
        root1, root2 = self.find(node1), self.find(node2)
        if root1 == root2:
            return
        if self.size[root1] > self.size[root2]:
            self.parent[root2] = root1
            self.size[root1] += self.size[root2]
        else:
            self.parent[root1] = root2
            self.size[root2] += self.size[root1]

    def get_size(self, node: int) -> int:
        return self.size[self.find(node)]

class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        dsu = UnionFind(n)
        edge_count = {}

        for edge in edges:
            dsu.union(edge[0], edge[1])

        for edge in edges:
            root = dsu.find(edge[0])
            edge_count[root] = edge_count.get(root, 0) + 1

        complete_count = 0
        for vertex in range(n):
            if dsu.find(vertex) == vertex:
                node_count = dsu.get_size(vertex)
                expected_edges = (node_count * (node_count - 1)) // 2
                if edge_count.get(vertex, 0) == expected_edges:
                    complete_count += 1

        return complete_count
