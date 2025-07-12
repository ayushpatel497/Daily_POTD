class Q193_Leetcode {
    int[][][] F = new int[31][31][31];
    int[][][] G = new int[31][31][31];

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        for (int[][] layer : F)
            for (int[] row : layer)
                Arrays.fill(row, 0);
        for (int[][] layer : G)
            for (int[] row : layer)
                Arrays.fill(row, 0);

        if (firstPlayer > secondPlayer) {
            int temp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = temp;
        }

        int[] result = dp(n, firstPlayer, secondPlayer);
        return new int[]{result[0], result[1]};
    }

    private int[] dp(int n, int f, int s) {
        if (F[n][f][s] != 0)
            return new int[]{F[n][f][s], G[n][f][s]};
        if (f + s == n + 1)
            return new int[]{1, 1};
        if (f + s > n + 1) {
            int[] res = dp(n, n + 1 - s, n + 1 - f);
            F[n][f][s] = res[0];
            G[n][f][s] = res[1];
            return res;
        }

        int earliest = Integer.MAX_VALUE, latest = Integer.MIN_VALUE;
        int nHalf = (n + 1) / 2;

        if (s <= nHalf) {
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < s - f; j++) {
                    int[] res = dp(nHalf, i + 1, i + j + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        } else {
            int sPrime = n + 1 - s;
            int mid = (n - 2 * sPrime + 1) / 2;
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < sPrime - f; j++) {
                    int[] res = dp(nHalf, i + 1, i + j + mid + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        }

        F[n][f][s] = earliest + 1;
        G[n][f][s] = latest + 1;
        return new int[]{F[n][f][s], G[n][f][s]};
    }
}
