class Q079_GFG {
    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        
        for (int price : prices) {
            buy1 = Math.min(buy1, price); // Min price to buy first stock
            profit1 = Math.max(profit1, price - buy1); // Max profit after first sell
            buy2 = Math.min(buy2, price - profit1); // Min cost after second buy
            profit2 = Math.max(profit2, price - buy2); // Max profit after second sell
        }
        
        return profit2;
    }
}
