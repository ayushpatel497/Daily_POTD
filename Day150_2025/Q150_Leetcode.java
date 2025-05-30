import java.util.Arrays;

class Q150_Leetcode {
    private void dfs(int node, int[] edges, int[] dist, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visited[neighbor]) {
            dist[neighbor] = dist[node] + 1;
            dfs(neighbor, edges, dist, visited);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        boolean[] visit1 = new boolean[n];
        boolean[] visit2 = new boolean[n];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist1[node1] = 0;
        dist2[node2] = 0;

        dfs(node1, edges, dist1, visit1);
        dfs(node2, edges, dist2, visit2);

        int minNode = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    minNode = i;
                }
            }
        }

        return minNode;
    }
}
