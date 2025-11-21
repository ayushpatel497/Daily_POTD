import java.util.*;

class Q325_GFG {

    static class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    private int[] dijkstra(int start, int V, List<List<Pair>> adj) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);

        dist[start] = 0;
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.wt;

            for (Pair it : adj.get(node)) {
                int v = it.node;
                int wt = it.wt;
                if (dist[v] > d + wt) {
                    dist[v] = d + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            adj.add(new ArrayList<>());

        List<int[]> curved = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2], cwt = e[3];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));

            curved.add(new int[]{u, v, cwt});
        }

        int[] dist1 = dijkstra(a, V, adj);
        int[] dist2 = dijkstra(b, V, adj);

        int ans = dist1[b];

        for (int[] e : curved) {
            int u = e[0], v = e[1], cwt = e[2];

            ans = Math.min(ans, dist1[u] + cwt + dist2[v]);
            ans = Math.min(ans, dist1[v] + cwt + dist2[u]);
        }

        if (ans >= 1e9) return -1;
        return ans;
    }
}
