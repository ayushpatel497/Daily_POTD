class Q332_Leetcode {
    int count;

    private int dfs(int u, int parent, List<List<Integer>> adj, int[] values, int k) {
        int sum = 0;

        for (int v : adj.get(u)) {
            if (v != parent) {
                int child = dfs(v, u, adj, values, k);
                if (child % k == 0) {
                    count++;
                }
                sum = (sum + child) % k;
            }
        }

        return (sum + values[u]) % k;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        count = 1; // root component
        dfs(0, -1, adj, values, k);
        return count;
    }
}
