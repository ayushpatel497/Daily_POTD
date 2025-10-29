import java.util.*;

class Q302_GFG {
    private void dfs(int idx, int dist, List<List<Integer>> adj, boolean[] visited, int[] result) {
        visited[idx] = true;
        if (dist > result[0]) {
            result[0] = dist;
            result[1] = idx;
        }

        for (int neighbor : adj.get(idx)) {
            if (!visited[neighbor]) {
                dfs(neighbor, dist + 1, adj, visited, result);
            }
        }
    }

    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int[] result = new int[2]; // result[0] = maxDist, result[1] = farthestNode
        dfs(0, 0, adj, visited, result);

        Arrays.fill(visited, false);
        result[0] = 0;
        dfs(result[1], 0, adj, visited, result);

        return result[0];
    }
}
