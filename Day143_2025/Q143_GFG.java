class Q143_GFG {
    static int noOfWays(int m, int n, int x) {
        int[] curr = new int[x + 1];
        int[] next = new int[x + 1];
        next[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            curr = new int[x + 1];  // Reset for current iteration
            for (int s = 1; s <= x; s++) {
                curr[s] = curr[s - 1] + next[s - 1];
                if (s - 1 - m >= 0) {
                    curr[s] -= next[s - 1 - m];
                }
            }
            next = curr;
        }

        return next[x];
    }
}
