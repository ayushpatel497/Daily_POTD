class Q275_Leetcode {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            ans++;
            empty -= numExchange - 1; // spend numExchange, but gain 1 bottle
            numExchange++;            // exchange cost increases
        }

        return ans;
    }
}
