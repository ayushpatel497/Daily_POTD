class Q314_GFG {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        long dp0 = 0;          // state 0: rest (not holding, no cooldown)
        long dp1 = -arr[0];    // state 1: holding a stock
        long dp2 = 0;          // state 2: in cooldown (just sold)

        for (int i = 1; i < n; i++) {
            long price = arr[i];
            long prev0 = dp0, prev1 = dp1, prev2 = dp2;

            dp0 = Math.max(prev0, prev2);        // stay at rest or come out of cooldown
            dp1 = Math.max(prev1, prev0 - price); // hold or buy
            dp2 = prev1 + price;                 // sell stock
        }

        return (int) Math.max(dp0, dp2);
    }
}
