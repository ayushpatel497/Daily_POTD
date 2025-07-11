class Q192_GFG {
    public int countConsec(int n) {
        if (n == 1) return 0;

        long total = 1L << n; // Total binary strings of length n
        long dp0 = 1, dp1 = 1; // Ending in 0 and 1 respectively

        for (int i = 2; i <= n; i++) {
            long new_dp0 = dp0 + dp1;
            long new_dp1 = dp0;
            dp0 = new_dp0;
            dp1 = new_dp1;
        }

        long withoutConsecutive = dp0 + dp1;
        return (int)(total - withoutConsecutive);
    }
}
