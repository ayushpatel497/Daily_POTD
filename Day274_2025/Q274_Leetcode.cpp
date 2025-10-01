class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        // Q. Water Bottles
        int totalBottles = numBottles;
        while (numBottles >= numExchange) {
            int emptyBottles = numBottles / numExchange;
            totalBottles += emptyBottles;
            numBottles = emptyBottles + (numBottles % numExchange);
        }
        return totalBottles;
    }
};