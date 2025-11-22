class DisjointSet {
    int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node]);  // Path compression
        return parent[node];
    }

    public boolean unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return false;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        return true;
    }

    public int countComp() {
        int c = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) c++;
        }
        return c;
    }
}

class Q326_GFG {
    public int minConnect(int V, int[][] edges) {
        int e = edges.length;

        if (e < V - 1) return -1;  // Not enough edges to connect all

        DisjointSet dsu = new DisjointSet(V);

        for (int[] edge : edges) {
            dsu.unionBySize(edge[0], edge[1]);
        }

        int components = dsu.countComp();
        return components - 1;  // Minimum operations
    }
}
