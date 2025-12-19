from typing import List
from collections import defaultdict

class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def unite(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py:
            return

        if self.rank[px] > self.rank[py]:
            self.parent[py] = px
        elif self.rank[px] < self.rank[py]:
            self.parent[px] = py
        else:
            self.parent[py] = px
            self.rank[px] += 1

    def connected(self, x, y):
        return self.find(x) == self.find(y)

    def reset(self, x):
        self.parent[x] = x
        self.rank[x] = 0


class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        meetings.sort(key=lambda x: x[2])

        same_time = defaultdict(list)
        for x, y, t in meetings:
            same_time[t].append((x, y))

        uf = UnionFind(n)
        uf.unite(0, firstPerson)

        for t in same_time:
            for x, y in same_time[t]:
                uf.unite(x, y)

            for x, y in same_time[t]:
                if not uf.connected(x, 0):
                    uf.reset(x)
                    uf.reset(y)

        return [i for i in range(n) if uf.connected(i, 0)]
