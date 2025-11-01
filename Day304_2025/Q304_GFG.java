import java.util.*;

class Q304_GFG {
    private void dfs(int node, List<List<Integer>> adj, int[] vis, int prev, int[] ans) {
        vis[node] = prev;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, prev + 1, ans);
            } else if (vis[node] - vis[i] > 1) {
                int cycleLength = vis[node] - vis[i] + 1;
                if (ans[0] == -1) ans[0] = cycleLength;
                else ans[0] = Math.min(ans[0], cycleLength);
            } else if (vis[node] + 1 < vis[i]) {
                dfs(i, adj, vis, prev + 1, ans);
            }
        }
    }

    public int shortCycle(int V, int[][] edges) {
        int ans = -1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] vis = new int[V];
        int[] res = {ans};

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0 && !adj.get(i).isEmpty()) {
                dfs(i, adj, vis, 1, res);
            }
        }

        return res[0];
    }
}
