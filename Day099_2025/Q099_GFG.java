import java.util.*;

class Q099_GFG {
    static int time = 0;

    static void dfs(int node, int parent, int[] vis, int[] tin, int[] low,
                    int[] mark, ArrayList<Integer>[] adj) {
        vis[node] = 1;
        tin[node] = low[node] = time++;
        int children = 0;

        for (int it : adj[node]) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && parent != -1)
                    mark[node] = 1;

                children++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (parent == -1 && children > 1)
            mark[node] = 1;
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        time = 0;
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                dfs(i, -1, vis, tin, low, mark, adj);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1)
                res.add(i);
        }

        if (res.isEmpty()) res.add(-1);
        return res;
    }
}
