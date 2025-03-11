class Q070_GFG {
    public int countWays(int n) {
        // Base cases
        if (n == 1 || n == 2) return n;
        
        int prev2 = 1, prev1 = 2;
        
        for (int i = 3; i <= n; i++) {
            int sum = prev1 + prev2;
            prev2 = prev1;
            prev1 = sum;
        }
        
        return prev1;
    }
}
