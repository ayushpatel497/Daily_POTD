import java.util.*;
class Q098_GFG {
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int c, int d, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && !(node == c && neighbor == d || node == d && neighbor == c)) {
                dfs(neighbor, adj, c, d, visited);
            }
        }
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        dfs(c, adj, c, d, visited);
        return !visited[d];
    }
}
