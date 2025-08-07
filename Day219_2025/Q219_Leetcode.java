class Q219_Leetcode {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            ans += fruits[i][i];
        }

        final int N = n;

        // Helper function
        java.util.function.Supplier<Integer> dp = () -> {
            int[] prev = new int[N];
            int[] curr = new int[N];
            java.util.Arrays.fill(prev, Integer.MIN_VALUE);
            java.util.Arrays.fill(curr, Integer.MIN_VALUE);

            prev[N - 1] = fruits[0][N - 1];

            for (int i = 1; i < N - 1; ++i) {
                for (int j = Math.max(N - 1 - i, i + 1); j < N; ++j) {
                    int best = prev[j];
                    if (j - 1 >= 0) best = Math.max(best, prev[j - 1]);
                    if (j + 1 < N) best = Math.max(best, prev[j + 1]);
                    curr[j] = best + fruits[i][j];
                }
                int[] temp = prev;
                prev = curr;
                curr = temp;
            }
            return prev[N - 1];
        };

        ans += dp.get();

        // Transpose the matrix
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = fruits[i][j];
                fruits[i][j] = fruits[j][i];
                fruits[j][i] = temp;
            }
        }

        ans += dp.get();
        return ans;
    }
}
