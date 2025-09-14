class Q257_GFG {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int totalCost = 0, totalGas = 0;
        
        for (int i = 0; i < n; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        
        if (totalCost > totalGas)
            return -1;
        
        int start = 0;
        int profit = 0;
        
        for (int i = 0; i < n; i++) {
            profit += (gas[i] - cost[i]);
            if (profit < 0) {
                start = (i + 1) % n;
                profit = 0;
            }
        }
        
        return start;
    }
}
