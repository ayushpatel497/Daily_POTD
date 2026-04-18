class Solution {
    int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
public:
    int mirrorDistance(int n) {
        // Q. Mirror Distance of an Integer
        return abs(n - reverse(n));
    }
};