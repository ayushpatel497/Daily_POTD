class Q274_Leetcode {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        while (numBottles >= numExchange) {
            int emptyBottles = numBottles / numExchange;
            totalBottles += emptyBottles;
            numBottles = emptyBottles + (numBottles % numExchange);
        }
        return totalBottles;
    }
}
