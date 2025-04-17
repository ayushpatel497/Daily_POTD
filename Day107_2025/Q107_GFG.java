import java.util.*;
class Solution {
    public int findMinCycle(int V, int[][] edges) {
        int res = Integer.MAX_VALUE;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1], weight = edge[2];
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            pq.offer(new int[]{src, 0});

            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int u = node[0];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0], w = neighbor[1];

                    // Skip the original edge
                    if ((u == src && v == dest) || (u == dest && v == src)) continue;

                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }

            if (dist[dest] != Integer.MAX_VALUE) {
                res = Math.min(res, dist[dest] + weight);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
