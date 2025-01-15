class Solution {
public:
    int minimizeXor(int num1, int num2) {
        // Q. Minimize XOR
        int result = 0;
        int targetSetBitsCount = __builtin_popcount(num2);
        int setBitsCount = 0;
        int currentBit = 31;

        while (setBitsCount < targetSetBitsCount) {
            if (num1 & (1 << currentBit) || (targetSetBitsCount - setBitsCount > currentBit)) {
                result |= (1 << currentBit);
                setBitsCount++;
            }
            currentBit--;
        }
        return result;
    }
};