class DSU:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def unite(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return False

        if self.rank[a] < self.rank[b]:
            a, b = b, a

        self.parent[b] = a
        if self.rank[a] == self.rank[b]:
            self.rank[a] += 1

        return True


class Solution:
    def secondMST(self, V, edges):
        E = len(edges)

        # Convert edges to list of (u, v, w)
        e = [(u, v, w) for (u, v, w) in edges]

        # Sort by weight
        e.sort(key=lambda x: x[2])

        d1 = DSU(V)
        mst_index = []
        mstWeight = 0

        # First MST
        for i in range(E):
            u, v, w = e[i]
            if d1.unite(u, v):
                mstWeight += w
                mst_index.append(i)

        if len(mst_index) != V - 1:
            return -1  # No MST possible

        answer = float('inf')

        # Try skipping each MST edge
        for skip in mst_index:
            d2 = DSU(V)
            curWeight = 0
            used = 0

            for i in range(E):
                if i == skip:
                    continue
                u, v, w = e[i]
                if d2.unite(u, v):
                    curWeight += w
                    used += 1
                    if curWeight >= answer:
                        break

            if used == V - 1 and curWeight > mstWeight:
                answer = min(answer, curWeight)

        return -1 if answer == float('inf') else answer
