class Solution {
public:
    int smallestNumber(int n) {
        // Q. Smallest Number With All Set Bits
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }
        return x;
    }
};