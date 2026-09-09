class Solution {
public:
    long long countCommas(long long n) {
        // Q. Count Commas in Range II
        long long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }
};