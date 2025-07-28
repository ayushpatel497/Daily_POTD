class Q209_GFG {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int maxe = Integer.MIN_VALUE;

        // Find maximum of all row sums and column sums
        for (int i = 0; i < n; ++i) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < n; ++j) {
                rowSum += mat[i][j];
                colSum += mat[j][i];
            }
            maxe = Math.max(maxe, Math.max(rowSum, colSum));
        }

        // Total operations needed to make every row sum equal to maxe
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int rowSum = 0;
            for (int j = 0; j < n; ++j) {
                rowSum += mat[i][j];
            }
            ans += (maxe - rowSum);
        }

        return ans;
    }
}
