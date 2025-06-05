import java.util.*;

class Q156_GFG {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            inDeg[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDeg[i] == 0) q.add(i);
        }

        int[] paths = new int[V];
        paths[src] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                paths[v] += paths[u];
                inDeg[v]--;
                if (inDeg[v] == 0) {
                    q.add(v);
                }
            }
        }

        return paths[dest];
    }
}
