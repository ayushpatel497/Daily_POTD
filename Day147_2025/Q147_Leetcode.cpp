class Solution {
public:
    int differenceOfSums(int n, int m) {
        // Q. Divisible and Non-divisible Sums Difference
        int k = n / m;
        return n * (n + 1) / 2 - k * (k + 1) * m;
    }
};