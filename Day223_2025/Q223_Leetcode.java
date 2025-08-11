class Q223_Leetcode {
    static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Extract powers of two from n
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }

        // Step 2: Precompute products for all ranges
        int m = bins.size();
        int[][] results = new int[m][m];
        for (int i = 0; i < m; i++) {
            long cur = 1;
            for (int j = i; j < m; j++) {
                cur = (cur * bins.get(j)) % MOD;
                results[i][j] = (int) cur;
            }
        }

        // Step 3: Answer queries
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];
            ans[q] = results[l][r];
        }
        return ans;
    }
}
