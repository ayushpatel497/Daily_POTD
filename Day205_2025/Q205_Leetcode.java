class Q205_Leetcode {
    private int[] sum, in, out;
    private int time;
    private List<List<Integer>> adj;

    private void dfs(int node, int parent, int[] nums) {
        in[node] = time++;
        sum[node] = nums[node];

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, nums);
                sum[node] ^= sum[neighbor];
            }
        }

        out[node] = time;
    }

    private int calc(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        sum = new int[n];
        in = new int[n];
        out = new int[n];
        time = 0;
        adj = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(0, -1, nums);

        int res = Integer.MAX_VALUE;

        for (int u = 1; u < n; ++u) {
            for (int v = u + 1; v < n; ++v) {
                if (in[v] > in[u] && in[v] < out[u]) {
                    res = Math.min(res, calc(sum[0] ^ sum[u], sum[u] ^ sum[v], sum[v]));
                } else if (in[u] > in[v] && in[u] < out[v]) {
                    res = Math.min(res, calc(sum[0] ^ sum[v], sum[v] ^ sum[u], sum[u]));
                } else {
                    res = Math.min(res, calc(sum[0] ^ sum[u] ^ sum[v], sum[u], sum[v]));
                }
            }
        }

        return res;
    }
}
