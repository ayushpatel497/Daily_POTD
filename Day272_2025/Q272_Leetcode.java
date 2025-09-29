class Q272_Leetcode {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        Integer[][] memo = new Integer[n][n];
        
        return dp(0, n - 1, values, memo);
    }
    
    private int dp(int i, int j, int[] values, Integer[][] memo) {
        if (i + 2 > j) return 0;
        if (i + 2 == j) return values[i] * values[i + 1] * values[j];
        
        if (memo[i][j] != null) return memo[i][j];
        
        int minScore = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            minScore = Math.min(minScore, values[i] * values[k] * values[j] 
                                           + dp(i, k, values, memo) 
                                           + dp(k, j, values, memo));
        }
        
        memo[i][j] = minScore;
        return minScore;
    }
}
