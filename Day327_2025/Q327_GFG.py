class Solution:
    def find(self, x, parent):
        if parent[x] == -1:
            return x
        parent[x] = self.find(parent[x], parent)
        return parent[x]

    def maxRemove(self, stones):
        n = len(stones)
        r = c = 0

        # find max row and column
        for st in stones:
            r = max(r, st[0])
            c = max(c, st[1])

        size = r + c + 2
        parent = [-1] * size
        sz = [0] * size

        # union rows and columns
        for st in stones:
            row = st[0]
            col = st[1] + r + 1

            u = self.find(row, parent)
            v = self.find(col, parent)

            if sz[u] < sz[v]:
                u, v = v, u

            sz[u] += 1

            if u != v:
                parent[v] = u
                sz[u] += sz[v]

        ans = 0
        for i in range(size):
            if parent[i] == -1 and sz[i] - 1 > 0:
                ans += (sz[i] - 1)

        return ans
