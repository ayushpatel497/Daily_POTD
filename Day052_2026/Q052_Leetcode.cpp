class Solution {
    bool isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 || x == 11 || x == 13 || x == 17 || x == 19);
    }
public:
    int countPrimeSetBits(int left, int right) {
        // Q. Prime Number of Set Bits in Binary Representation
        int ans = 0;
        for (int x = left; x <= right; ++x)
            if (isSmallPrime(__builtin_popcount(x)))
                ans++;
        return ans;
    }
};