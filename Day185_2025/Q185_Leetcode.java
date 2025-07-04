class Q185_Leetcode {
    public char kthCharacter(long k, int[] operations) {
        k--;  // convert to 0-based indexing
        int ans = 0;
        for (int i = 63; i >= 0; i--) {
            if (((k >> i) & 1) == 1 && i < operations.length) {
                ans += operations[i];
            }
        }
        return (char) ('a' + (ans % 26));
    }
}
