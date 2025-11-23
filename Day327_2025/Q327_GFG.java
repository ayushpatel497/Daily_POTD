class Q327_GFG {
    int find(int x, int[] parent) {
        if (parent[x] == -1) return x;
        return parent[x] = find(parent[x], parent);
    }

    public int maxRemove(int[][] stones) {
        int r = 0, c = 0;

        // find max row and max column
        for (int[] st : stones) {
            r = Math.max(r, st[0]);
            c = Math.max(c, st[1]);
        }

        int size = r + c + 2;
        int[] parent = new int[size];
        int[] sz = new int[size];

        // initialize parent = -1, size = 0
        for (int i = 0; i < size; i++) {
            parent[i] = -1;
            sz[i] = 0;
        }

        // union row and column nodes
        for (int[] st : stones) {
            int row = st[0];
            int col = st[1] + r + 1;

            int u = find(row, parent);
            int v = find(col, parent);

            if (sz[u] < sz[v]) {
                int temp = u;
                u = v;
                v = temp;
            }

            sz[u]++;

            if (u != v) {
                parent[v] = u;
                sz[u] += sz[v];
            }
        }

        int ans = 0;

        // count components
        for (int i = 0; i < size; i++) {
            if (parent[i] == -1 && sz[i] - 1 > 0) {
                ans += (sz[i] - 1);
            }
        }

        return ans;
    }
}
