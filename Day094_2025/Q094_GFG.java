import java.util.*;

class Q094_GFG{
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) { // Ignore edge to parent
                if (visited[neighbor]) {
                    return true; // Cycle detected
                }
                if (dfs(neighbor, node, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // DFS for cycle detection
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
