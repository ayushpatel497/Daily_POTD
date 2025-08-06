class Q218_Leetcode {
    int[] segTree = new int[400007];
    int[] baskets;

    void build(int p, int l, int r) {
        if (l == r) {
            segTree[p] = baskets[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(p << 1, l, mid);
        build(p << 1 | 1, mid + 1, r);
        segTree[p] = Math.max(segTree[p << 1], segTree[p << 1 | 1]);
    }

    int query(int p, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return Integer.MIN_VALUE;
        }
        if (ql <= l && r <= qr) {
            return segTree[p];
        }
        int mid = (l + r) >> 1;
        return Math.max(query(p << 1, l, mid, ql, qr),
                        query(p << 1 | 1, mid + 1, r, ql, qr));
    }

    void update(int p, int l, int r, int pos, int val) {
        if (l == r) {
            segTree[p] = val;
            return;
        }
        int mid = (l + r) >> 1;
        if (pos <= mid) {
            update(p << 1, l, mid, pos, val);
        } else {
            update(p << 1 | 1, mid + 1, r, pos, val);
        }
        segTree[p] = Math.max(segTree[p << 1], segTree[p << 1 | 1]);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] basketsInput) {
        this.baskets = basketsInput;
        int m = baskets.length;
        int count = 0;
        if (m == 0) return fruits.length;

        build(1, 0, m - 1);
        for (int fruit : fruits) {
            int l = 0, r = m - 1, res = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (query(1, 0, m - 1, 0, mid) >= fruit) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (res != -1 && baskets[res] >= fruit) {
                update(1, 0, m - 1, res, Integer.MIN_VALUE);
            } else {
                count++;
            }
        }
        return count;
    }
}
