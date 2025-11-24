class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    boolean unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        if (rank[a] < rank[b]) {
            int t = a; a = b; b = t;
        }
        parent[b] = a;
        if (rank[a] == rank[b]) rank[a]++;
        return true;
    }
}

class Q328_GFG {
    public int secondMST(int V, int[][] edges) {

        int E = edges.length;

        // Convert into list of (u, v, w)
        int[][] e = new int[E][3];
        for (int i = 0; i < E; i++) {
            e[i][0] = edges[i][0];
            e[i][1] = edges[i][1];
            e[i][2] = edges[i][2];
        }

        // Sort by weight
        java.util.Arrays.sort(e, (a, b) -> a[2] - b[2]);

        DSU d1 = new DSU(V);
        java.util.List<Integer> mstIndex = new java.util.ArrayList<>();
        int mstWeight = 0;

        // First MST
        for (int i = 0; i < E; i++) {
            if (d1.unite(e[i][0], e[i][1])) {
                mstWeight += e[i][2];
                mstIndex.add(i);
            }
        }

        if (mstIndex.size() != V - 1)
            return -1; // no MST possible

        int answer = Integer.MAX_VALUE;

        // Try skipping each MST edge
        for (int skip : mstIndex) {
            DSU d2 = new DSU(V);
            int curWeight = 0;
            int used = 0;

            for (int i = 0; i < E; i++) {
                if (i == skip) continue;
                if (d2.unite(e[i][0], e[i][1])) {
                    curWeight += e[i][2];
                    used++;

                    if (curWeight >= answer) break;
                }
            }

            if (used == V - 1 && curWeight > mstWeight)
                answer = Math.min(answer, curWeight);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
