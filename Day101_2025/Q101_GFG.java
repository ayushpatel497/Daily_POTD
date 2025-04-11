import java.util.*;
class Q101_GFG {
    static class Pair {
        int dist, node;
        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node, weight = neighbor.dist;
                if (dist[v] > d + weight) {
                    dist[v] = d + weight;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }

        return dist;
    }
}
