import java.util.*;
public class Q100_GFG {
    public int minCost(int[][] houses) {
        int V = houses.length;
        boolean[] inMST = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [cost, node]
        pq.offer(new int[]{0, 0});
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int u = curr[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            totalCost += wt;

            for (int v = 0; v < V; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    pq.offer(new int[]{dist, v});
                }
            }
        }

        return totalCost;
    }
}
