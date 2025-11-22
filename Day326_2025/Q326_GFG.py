class DisjointSet:
    def __init__(self, n):
        self.parent = list(range(n))
        self.size = [1] * n

    def find(self, node):
        if node == self.parent[node]:
            return node
        self.parent[node] = self.find(self.parent[node])  # Path compression
        return self.parent[node]

    def unionBySize(self, u, v):
        pu = self.find(u)
        pv = self.find(v)

        if pu == pv:
            return False

        if self.size[pu] > self.size[pv]:
            self.parent[pv] = pu
            self.size[pu] += self.size[pv]
        else:
            self.parent[pu] = pv
            self.size[pv] += self.size[pu]

        return True

    def countComp(self):
        return sum(1 for i in range(len(self.parent)) if self.parent[i] == i)


class Solution:
    def minConnect(self, V, edges):
        if len(edges) < V - 1:
            return -1
        
        dsu = DisjointSet(V)

        for u, v in edges:
            dsu.unionBySize(u, v)

        components = dsu.countComp()
        return components - 1
