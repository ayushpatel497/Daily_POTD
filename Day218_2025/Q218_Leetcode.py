class Solution:
    def __init__(self):
        self.segTree = [0] * 400007
        self.baskets = []

    def build(self, p, l, r):
        if l == r:
            self.segTree[p] = self.baskets[l]
            return
        mid = (l + r) >> 1
        self.build(p << 1, l, mid)
        self.build(p << 1 | 1, mid + 1, r)
        self.segTree[p] = max(self.segTree[p << 1], self.segTree[p << 1 | 1])

    def query(self, p, l, r, ql, qr):
        if ql > r or qr < l:
            return float('-inf')
        if ql <= l and r <= qr:
            return self.segTree[p]
        mid = (l + r) >> 1
        return max(self.query(p << 1, l, mid, ql, qr),
                   self.query(p << 1 | 1, mid + 1, r, ql, qr))

    def update(self, p, l, r, pos, val):
        if l == r:
            self.segTree[p] = val
            return
        mid = (l + r) >> 1
        if pos <= mid:
            self.update(p << 1, l, mid, pos, val)
        else:
            self.update(p << 1 | 1, mid + 1, r, pos, val)
        self.segTree[p] = max(self.segTree[p << 1], self.segTree[p << 1 | 1])

    def numOfUnplacedFruits(self, fruits, baskets):
        self.baskets = baskets
        m = len(baskets)
        count = 0
        if m == 0:
            return len(fruits)
        self.build(1, 0, m - 1)

        for fruit in fruits:
            l, r, res = 0, m - 1, -1
            while l <= r:
                mid = (l + r) >> 1
                if self.query(1, 0, m - 1, 0, mid) >= fruit:
                    res = mid
                    r = mid - 1
                else:
                    l = mid + 1
            if res != -1 and baskets[res] >= fruit:
                self.update(1, 0, m - 1, res, float('-inf'))
            else:
                count += 1
        return count
