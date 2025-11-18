import java.util.*;

class Q322_GFG {
    public int countPaths(int V, int[][] edges) {
        int MOD = (int)1e9 + 7;

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[V];
        dist[0] = 0;
        ways[0] = 1;

        // Min-heap: {distance, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long currDist = top[0];
            int node = (int) top[1];

            for (int[] nbr : adj.get(node)) {
                int adjNode = nbr[0];
                int wt = nbr[1];

                if (currDist + wt < dist[adjNode]) {
                    dist[adjNode] = currDist + wt;
                    pq.offer(new long[]{dist[adjNode], adjNode});
                    ways[adjNode] = ways[node];
                } 
                else if (currDist + wt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[V - 1];
    }
}
