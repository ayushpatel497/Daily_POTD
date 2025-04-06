import java.util.*;
class Q096_GFG {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
        }

        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj[u])
                inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int neighbor : adj[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        return result;
    }
}
