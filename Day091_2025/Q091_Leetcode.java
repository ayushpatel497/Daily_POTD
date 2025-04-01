class Q091_Leetcode {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int jump = questions[i][1];

            int nextQuestion = Math.min(n, i + jump + 1);
            dp[i] = Math.max(dp[i + 1], point + dp[nextQuestion]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Q091_Leetcode sol = new Q091_Leetcode();
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(sol.mostPoints(questions)); // Example usage
    }
}
