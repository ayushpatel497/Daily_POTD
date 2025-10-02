class Solution {
public:
    int maxBottlesDrunk(int numBottles, int numExchange) {
        // Q. Water Bottles II
        int ans = numBottles;
        for (int empty = numBottles; empty >= numExchange; numExchange++) {
            ans++;
            empty -= numExchange - 1;
        }
        return ans;
    }
};